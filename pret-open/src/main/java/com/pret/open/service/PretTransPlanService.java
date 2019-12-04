package com.pret.open.service;

import java.util.*;

import com.google.common.reflect.TypeToken;
import com.pret.api.vo.ResBody;
import com.pret.common.constant.CommonConstants;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.constant.Constants;
import com.pret.common.exception.FebsException;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.common.util.NoUtil;
import com.pret.common.util.SfUtil;
import com.pret.common.util.StringUtil;
import com.pret.open.config.Sender;
import com.pret.open.entity.*;
import com.pret.open.entity.bo.*;
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
    private PretTransOrderRepository pretTransOrderRepository;
    @Autowired
    private PretTransPlanRepository pretTransPlanRepository;
    @Autowired
    private PretTransFeeService pretTransFeeService;
    @Autowired
    private PretTransTrajectoryRepository transTrajectoryRepository;
    @Autowired
    private Sender sender;
    @Autowired
    private PretCustomerRepository pretCustomerRepository;
    @Autowired
    private PretPickUpPlanRepository pretPickUpPlanRepository;
    @Autowired
    private PretTransExceptionRepository pretTransExceptionRepository;
    @Autowired
    private PretTransExceptionItemRepository pretTransExceptionItemRepository;
    @Autowired
    private PretTransExceptionService pretTransExceptionService;
    @Autowired
    private PretTransFeeRepository pretTransFeeRepository;
    @Autowired
    private PretTransOrderGroupRepository pretTransOrderGroupRepository;

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
                    String str = StringUtil.disposeFrontZero(firstOrder.getNo().substring(7));
                    int intStr = Integer.parseInt(str) + 1;
                    tail = StringUtil.addFrontZero(String.valueOf(intStr), 4);
                } else {
                    tail = Constants.TAIL;
                }
                transPlan.setNo(NoUtil.genNo(ConstantEnum.NoTypeEnum.T.name()) + tail);
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
        List<String> idList = StringUtil.idsStr2ListString(bo.getIds());

        // 将配送任务单分组
        Map<String, List<PretTransOrder>> map = new HashMap<>();
        for (String id : idList) {
            PretTransOrder pretTransOrder = pretTransOrderRepository.findById(id).get();
            String dateStr = Constants.dfyyyyMMdd.format(pretTransOrder.getDeliveryDate());
            String key = pretTransOrder.getServiceRouteOriginId() + pretTransOrder.getCustomerDetailAddress() + dateStr;
            if (map.containsKey(key)) {
                map.get(key).add(pretTransOrder);
            } else {
                List<PretTransOrder> transOrderList = new ArrayList<>();
                transOrderList.add(pretTransOrder);
                map.put(key, transOrderList);
            }
        }

        for (Map.Entry<String, List<PretTransOrder>> item : map.entrySet()) {
            PretTransPlan transPlan = this.genDefaultPretTransPlan(null, null);
            BeanUtilsExtended.copyProperties(transPlan, bo);
            PretTransOrder transOrder = null;
            String venderId = StringUtils.EMPTY;
            int count = 0;
            Float gw = 0.0f;
            for (PretTransOrder pretTransOrder : item.getValue()) {
                pretTransOrder.setTransPlanId(transPlan.getId());
                pretTransOrder.setStatus(ConstantEnum.ETransOrderStatus.完成提货.getLabel());
                pretTransOrderRepository.save(pretTransOrder);
                if (transOrder == null) {
                    transOrder = pretTransOrder;
                }
                if (StringUtils.isEmpty(venderId)) {
                    venderId = pretTransOrder.getVenderId();
                }
                gw += pretTransOrder.getGw();
            }
            transPlan.setCustomerId(transOrder.getCustomerId());
            transPlan.setVenderId(venderId);
            transPlan.setStatus(ConstantEnum.ETransPlanStatus.运输中.getValue());
            transPlan.setGoodsNum(count);
            transPlan.setCustomerDetailAddress(transOrder.getCustomerDetailAddress());
            transPlan.setServiceRouteOriginName(transOrder.getServiceRouteOriginName());
            transPlan.setServiceRouteOriginId(transOrder.getServiceRouteOriginId());
            transPlan.setServiceRouteOriginAddress(transOrder.getServiceRouteOriginAddress());
            transPlan.setServiceRouteItemId(transOrder.getServiceRouteItemId());
            transPlan.setGw(gw);
            transPlan.setDeliveryDate(transOrder.getDeliveryDate());
            this.repository.save(transPlan);

            PretTransOrderGroup pretTransOrderGroup = pretTransOrderGroupRepository.findById(transOrder.getTransOrderGroupId()).get();
            pretTransOrderGroup.setStatus(ConstantEnum.ETransOrderStatus.完成提货.getLabel());
            pretTransOrderGroupRepository.save(pretTransOrderGroup);

            // 设置提货计划状态
            String[] pickUpArr = bo.getPickUpIds().split(",");
            for (String pickUp : pickUpArr) {
                PretPickUpPlan pretPickUpPlan = pretPickUpPlanRepository.findById(pickUp).get();
                List<PretTransOrder> transOrderList = pretTransOrderRepository.findByTransPlanIdAndStatusAndS(pickUp, ConstantEnum.ETransOrderStatus.完成提货.getLabel(), ConstantEnum.S.N.getLabel());
                if (transOrderList != null && transOrderList.size() > 0) {
                    pretPickUpPlan.setStatus(ConstantEnum.EPretPickUpPlanStatus.部分完成.getLabel());
                } else {
                    pretPickUpPlan.setStatus(ConstantEnum.EPretPickUpPlanStatus.已完成.getLabel());
                }
                pretPickUpPlan.setEndTime(new Date());
                pretPickUpPlanRepository.save(pretPickUpPlan);
            }

            // 生产顺丰单号
            this.genSfMailno(transPlan);
        }
    }

    /* *
     * 功能描述: 代客签收
     * 〈〉
     * @Param: [ids]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/10/4  3:16 下午
     */
    public void sign(PretTransPlanSignBo bo) throws FebsException {
        // 异常单生成
        if (bo.isHasException()) {
            PretTransPlan pretTransPlan = this.repository.findById(bo.getId()).get();
            PretTransException pretTransException = pretTransExceptionService.genDefaultPretTransException(null, null);
            pretTransException.setVenderId(pretTransPlan.getVenderId());
            pretTransException.setTransPlanId(bo.getId());
            pretTransExceptionRepository.save(pretTransException);
            Float count = 0.0f;
            List<PretTransOrderSignBo> list = CommonConstants.GSON.fromJson(bo.getPretTransOrderSignBoStr(),
                    new TypeToken<List<PretTransOrderSignBo>>() {
                    }.getType());
            for (PretTransOrderSignBo signBo : list) {
                if (signBo.getRejectCount() > 0) {
                    count += signBo.getRejectCount();

                    PretTransExceptionItem item = new PretTransExceptionItem();
                    item.setTransOrderId(signBo.getId());
                    item.setTransExceptionId(pretTransException.getId());
                    item.setTransPlanId(bo.getId());
                    item.setCount(signBo.getRejectCount());
                    item.setReason(signBo.getRejectReason());

                    pretTransExceptionItemRepository.save(item);
                }
            }
            pretTransException.setRejectCount(count);
            pretTransExceptionRepository.save(pretTransException);
            pretTransPlan.setTransExceptionId(pretTransException.getId());
            pretTransPlanRepository.save(pretTransPlan);
        }

        // 计算费用
        pretTransFeeService.calFee(bo);


    }

    /* *
     * 功能描述: 退货签收
     * 〈〉
     * @Param: [ids]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/11/18  5:15 下午
     */
    public void signRefund(PretTransPlanSignBo bo) throws FebsException {
        pretTransFeeService.calFee(bo);
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

        PretCustomer customer = pretCustomerRepository.findByOpenidAndS(res.getOpenid(), ConstantEnum.S.N.getLabel());
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

        PretTransPlan transPlan = pretTransPlanRepository.findById(res.getId()).get();
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
        map.put("d_address", pretTransPlan.getCustomerDetailAddress());
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

    /* *
     * 功能描述: 起运确认
     * 〈〉
     * @Param: [bo]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/11/22  3:07 下午
     */
    public void pretStartShipmentConfirm(PretTransPlanStartShipmentConfirmBo bo) {
        PretTransPlan pretTransPlan = this.repository.findById(bo.getId()).get();

        pretTransPlan.setPreDeliveryDate(bo.getPreDeliveryDate());
        pretTransPlan.setTransDatetime(bo.getTransDatetime());
        List<PretTransOrder> pretTransOrderList = pretTransOrderRepository.findByTransPlanIdAndS(bo.getId(), ConstantEnum.S.N.getLabel());
        String groupId = StringUtils.EMPTY;
        for (PretTransOrder order : pretTransOrderList) {
            order.setStatus(ConstantEnum.ETransOrderStatus.起运.getLabel());
            if(StringUtils.isEmpty(groupId)) {
               groupId = order.getTransOrderGroupId();
            }
        }
        pretTransOrderRepository.saveAll(pretTransOrderList);

        PretTransOrderGroup pretTransOrderGroup = pretTransOrderGroupRepository.findById(groupId).get();
        pretTransOrderGroup.setStatus(ConstantEnum.ETransOrderStatus.起运.getLabel());
        pretTransOrderGroupRepository.save(pretTransOrderGroup);

        this.repository.save(pretTransPlan);
    }

    /* *
     * 功能描述: 检查是否有异常
     * 〈〉
     * @Param: [transFeeIds]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/11/27  11:52 下午
     */
    public void checkException(String transFeeIds) throws FebsException {
        List<String> idList = StringUtil.idsStr2ListString(transFeeIds);
        List<PretTransFee> pretTransFeeList = pretTransFeeRepository.findByIdIn(idList);
        String message = StringUtils.EMPTY;

        for (PretTransFee pretTransFee : pretTransFeeList) {
            PretTransPlan pretTransPlan = this.repository.findById(pretTransFee.getTransPlanId()).get();
            if (!StringUtils.isEmpty(pretTransPlan.getTransExceptionId())) {
                PretTransException pretTransException = pretTransExceptionRepository.findById(pretTransPlan.getTransExceptionId()).get();
                if (pretTransException.getStatus() != ConstantEnum.ETransExceptionStatus.已结案.getLabel()) {
                    message += pretTransFee.getNo() + "存在未结案的异常;";
                }
            }
        }

        if (!StringUtils.isEmpty(message)) {
            throw new FebsException(message);
        }
    }
}
