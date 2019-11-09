package com.pret.open.service;

import java.math.BigDecimal;
import java.util.*;

import com.pret.api.vo.ResBody;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.constant.Constants;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.common.util.NoUtil;
import com.pret.common.util.SfUtil;
import com.pret.common.util.StringUtil;
import com.pret.open.config.Sender;
import com.pret.open.entity.*;
import com.pret.open.entity.bo.PretTransPlanBo;
import com.pret.open.entity.vo.PretPickUpPlanVo;
import com.pret.open.entity.vo.PretTransPlanVo;
import com.pret.open.repository.*;
import com.pret.open.vo.req.*;
import com.pret.api.service.impl.BaseServiceImpl;
import com.pret.open.vo.res.PR8000002Vo;
import com.pret.open.vo.res.PR8000003Vo;
import com.sf.csim.express.service.CallExpressServiceTools;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Description: [pret服务]
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class PretTransPlanService extends BaseServiceImpl<PretTransPlanRepository, PretTransPlan, PretTransPlanVo> {
    @Autowired
    private PretTransOrderRepository transOrderRepository;
    @Autowired
    private PretTransPlanRepository transPlanRepository;
    @Autowired
    private PretTransFeeRepository transFeeRepository;
    @Autowired
    private PretTransFeeService transFeeService;
    @Autowired
    private PretCustomerRepository customerRepository;
    @Autowired
    private PretTransTrajectoryRepository transTrajectoryRepository;
    @Autowired
    private Sender sender;
    @Autowired
    private PretCustomerRepository pretCustomerRepository;
    @Value("${sf.url}")
    private String sfUrl;

    /* *
     * 功能描述: 生成模板运输计划
     * 〈〉
     * @Param: [no, tail]
     * @Return: com.pret.open.entity.PretTransPlan
     * @Author: wujingsong
     * @Date: 2019/10/4  2:05 下午
     */
    public PretTransPlan genDefaultPretTransPlan(String no, String tail) {
        Date date = DateUtils.truncate(new Date(), Calendar.DATE);
        Date endDate = DateUtils.addDays(date, 1);
        PretTransPlan transPlan = new PretTransPlan();

        if (!StringUtils.isEmpty(no)) {
            transPlan.setNo(no);
        } else {
            if (StringUtils.isEmpty(tail)) {
                PretTransPlan firstOrder = this.repository.findTop1ByCreateTimeLongBetweenOrderByCreateTimeLongDesc(date.getTime(), endDate.getTime());
                if (firstOrder != null) {
                    String str = StringUtil.disposeFrontZero(firstOrder.getNo().substring(19));
                    int intStr = Integer.parseInt(str) + 1;
                    tail = StringUtil.addFrontZero(String.valueOf(intStr), 6);
                } else {
                    tail = Constants.TAIL;
                }
                transPlan.setNo(NoUtil.genNo(ConstantEnum.NoTypeEnum.YS.name()) + tail);
            }
        }
        this.repository.save(transPlan);

        return transPlan;
    }

    /* *
     * 功能描述: 生成运输计划
     * 〈〉
     * @Param: [bo]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/10/4  2:01 下午
     */
    public void pretTransPlanAdd(PretTransPlanBo bo) {
        String[] idArr = bo.getIds().split(",");
        PretTransPlan transPlan = this.genDefaultPretTransPlan(null, null);
        BeanUtilsExtended.copyProperties(transPlan, bo);
        PretTransOrder transOrder = null;
        String venderId = StringUtils.EMPTY;
        int count = 0;
        int gw = 0;
        int cw = 0;

        for (String id : idArr) {
            PretTransOrder pretTransOrder = transOrderRepository.findById(id).get();
            pretTransOrder.setTransPlanId(transPlan.getId());
            pretTransOrder.setStatus(ConstantEnum.ETransOrderStatus.运输中.getLabel());
            transOrderRepository.save(pretTransOrder);
            if (transOrder == null) {
                transOrder = pretTransOrder;
            }
            if (StringUtils.isEmpty(venderId)) {
                venderId = pretTransOrder.getVenderId();
            }
            count += pretTransOrder.getGw();
            cw += pretTransOrder.getGw();
        }
        transPlan.setCustomerId(transOrder.getCustomerId());
        transPlan.setVenderId(venderId);
        transPlan.setStatus(ConstantEnum.ETransPlanStatus.运输中.getValue());
        transPlan.setGoodsNum(count);
        transPlan.setGw(cw);
        this.repository.save(transPlan);

        // 生产顺丰单号
        this.genSfMailno(transPlan);
    }

    /* *
     * 功能描述: 代客签收
     * 〈〉
     * @Param: [ids]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/10/4  3:16 下午
     */
    public void sign(String ids) {
        String[] idArr = ids.split(",");
        boolean first = true;
        int sn = 0;
        for (String id : idArr) {
            PretTransPlan pretTransPlan = transPlanRepository.findById(id).get();
            pretTransPlan.setStatus(ConstantEnum.ETransPlanStatus.已签收.getValue());
            transPlanRepository.save(pretTransPlan);

            List<PretTransOrder> pretTransOrderList = transOrderRepository.findByTransPlanIdAndS(id, ConstantEnum.S.N.getLabel());
            if (pretTransOrderList != null && pretTransOrderList.size() > 0) {
                for (PretTransOrder pretTransOrder : pretTransOrderList) {
                    pretTransOrder.setStatus(ConstantEnum.ETransOrderStatus.已签收.getLabel());
                    transOrderRepository.save(pretTransOrder);
                }
            }
            // 生成费用
            PretTransFee pretTransFee;
            if (first) {
                pretTransFee = transFeeService.genDefaultPretTransFee(null, null);
                sn = Integer.parseInt(pretTransFee.getNo().substring(19));
            } else {
                sn++;
                // 生成费用
                pretTransFee = new PretTransFee();
                String tail = StringUtil.addFrontZero(String.valueOf(sn), 6);
                pretTransFee.setNo(NoUtil.genNo(ConstantEnum.NoTypeEnum.TF.name()) + tail);
            }
            pretTransFee.setVenderId(pretTransPlan.getVenderId());
            pretTransFee.setCustomerId(pretTransPlan.getCustomerId());
            pretTransFee.setQuotation(new BigDecimal(100l));
            pretTransFee.setQuotationCount(1);
            pretTransFee.setStatus(ConstantEnum.EPretTransFeeStatus.待申报.getLabel());
            transFeeRepository.save(pretTransFee);
        }
    }

    /* *
     * 功能描述: 获取用户运输计划
     * 〈〉
     * @Param: [res]
     * @Return: com.pret.api.vo.ResBody
     * @Author: wujingsong
     * @Date: 2019/10/18  10:45 下午
     */
    public ResBody getTransPanList(P8000002Vo res) {
        PR8000002Vo retVo = new PR8000002Vo();

        PretCustomer customer = customerRepository.findByOpenid(res.getOpenid());
        PretTransPlanVo vo = new PretTransPlanVo();
        vo.setEq$customerId(customer.getId());
        List<PretTransPlan> list = this.page(vo).getContent();
        retVo.setData(list);

        return retVo;
    }

    /* *
     * 功能描述: 获取用户运输计划详情
     * 〈〉
     * @Param: [res]
     * @Return: com.pret.api.vo.ResBody
     * @Author: wujingsong
     * @Date: 2019/10/18  10:53 下午
     */
    public ResBody getTransPlanDetail(P8000003Vo res) {
        PR8000003Vo retVo = new PR8000003Vo();

        PretTransPlan transPlan = transPlanRepository.findById(res.getId()).get();
        retVo.setData(transPlan);

        List<PretTransTrajectory> list = transTrajectoryRepository.findByTransPlanIdAndS(transPlan.getId(), ConstantEnum.S.N.getLabel());
        retVo.setTransTrajectoryList(list);

        return retVo;
    }

    public void genSfMailno(PretTransPlan pretTransPlan) {
        Map map = new HashMap();
        PretCustomer pretCustomer = pretCustomerRepository.findById(pretTransPlan.getCustomerId()).get();

        boolean hasGet = false;
        map.put("d_company", pretCustomer.getName());
        map.put("d_contact", pretCustomer.getLinkName());
        map.put("d_tel", pretCustomer.getLinkPhone());
        map.put("d_address", pretTransPlan.getDestAddress());
        if (!StringUtils.isEmpty(pretTransPlan.getMailno())) {
            hasGet = true;
        }

        if (!hasGet) {
            map.put("orderid", String.valueOf(new Date().getTime()));
            map.put("mailno", String.valueOf(new Date().getTime()));
            map.put("j_company", sender.getJ_company());
            map.put("j_contact", sender.getJ_contact());
            map.put("j_tel", sender.getJ_tel());
            map.put("j_address", sender.getAddress());
            map.put("custid", sender.getCustid());
            map.put("clientCode", sender.getClientCode());
            String xmlStr = SfUtil.getOrderServiceRequestXml(map);
            CallExpressServiceTools client = CallExpressServiceTools.getInstance();
            String respXml = client.callSfExpressServiceByCSIM(sfUrl, xmlStr, sender.getClientCode(), sender.getCheckword());
            Document doc = null;
            try {
                doc = DocumentHelper.parseText(respXml);
                Element root = doc.getRootElement();
                String head = root.elementText("Head");
                if (head.equals("OK")) {
                    Element body = root.element("Body");
                    Element response = body.element("OrderResponse");
                    String wayBillNo = response.attributeValue("mailno");//获取子节点
                    String desctCode = response.attributeValue("destcode");//获取子节点
                    pretTransPlan.setDesctcode(desctCode);
                    pretTransPlan.setMailno(wayBillNo);
                } else {
                }
            } catch (Exception e) {
            }
        }
    }
}
