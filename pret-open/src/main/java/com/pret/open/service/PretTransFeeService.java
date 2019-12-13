package com.pret.open.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.google.common.reflect.TypeToken;
import com.pret.common.constant.CommonConstants;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.constant.Constants;
import com.pret.common.exception.FebsException;
import com.pret.common.util.NoUtil;
import com.pret.common.util.StringUtil;
import com.pret.common.utils.HttpUtil;
import com.pret.open.entity.*;
import com.pret.open.entity.bo.PretTransFeeBo;
import com.pret.open.entity.bo.PretTransPlanSignBo;
import com.pret.open.entity.bo.U9ReturnBo;
import com.pret.open.entity.vo.PretTransFeeVo;
import com.pret.open.repository.*;
import com.pret.api.service.impl.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
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
public class PretTransFeeService extends BaseServiceImpl<PretTransFeeRepository, PretTransFee, PretTransFeeVo> {
    @Autowired
    private PretTransPlanRepository pretTransPlanRepository;
    @Autowired
    private PretTransOrderRepository pretTransOrderRepository;
    @Autowired
    private PretBillingIntervalItemRepository pretBillingIntervalItemRepository;
    @Autowired
    private PretQuotationItemRepository pretQuotationItemRepository;
    @Autowired
    private PretFeeTypeRepository pretFeeTypeRepository;
    @Autowired
    private PretTransExceptionRepository pretTransExceptionRepository;
    @Autowired
    private PretTransFeeItemRepository pretTransFeeItemRepository;
    @Autowired
    private PretTransFeeItemService pretTransFeeItemService;
    @Autowired
    private PretTransOrderGroupRepository pretTransOrderGroupRepository;
    @Value("${u9.ulr}")
    private String u9Url;

    public PretTransFee genDefaultPretTransFee(String no, String tail) {
        Date date = DateUtils.truncate(new Date(), Calendar.DATE);
        Date endDate = DateUtils.addDays(date, 1);
        PretTransFee transFee = new PretTransFee();

        if (!StringUtils.isEmpty(no)) {
            transFee.setNo(no);
        } else {
            if (StringUtils.isEmpty(tail)) {
                PretTransFee firstOrder = this.repository.findTop1ByCreateTimeLongBetweenOrderByCreateTimeLongDesc(date.getTime(), endDate.getTime());
                if (firstOrder != null) {
                    String str = StringUtil.disposeFrontZero(firstOrder.getNo().substring(8));
                    int intStr = Integer.parseInt(str) + 1;
                    tail = StringUtil.addFrontZero(String.valueOf(intStr), 4);
                } else {
                    tail = Constants.TAIL;
                }
                transFee.setNo(NoUtil.genNo(ConstantEnum.NoTypeEnum.TR.name()) + tail);
            }
        }

        return transFee;
    }


    /* *
     * 功能描述: 费用申报
     * 〈〉
     * @Param: [ids]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/10/4  5:29 下午
     */
    public void transFeeAppl(String ids) {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            PretTransFee transFee = this.repository.findById(id).get();
            transFee.setStatus(ConstantEnum.EPretTransFeeStatus.已申报.getLabel());
            this.repository.save(transFee);
        }
    }

    /* *
     * 功能描述: 根据运输计划计算费用
     * 〈〉
     * @Param: [ids]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/11/19  5:57 下午
     */
    public void calFee(PretTransPlanSignBo bo) throws FebsException {
        String id = bo.getId();
        PretTransPlan pretTransPlan = pretTransPlanRepository.findById(id).get();
        pretTransPlan.setStatus(ConstantEnum.ETransPlanStatus.已签收.getValue());
        pretTransPlan.setSignUsername(bo.getUsername());
        pretTransPlan.setSignDatetime(bo.getSignDatetime());
        Float totalGw = pretTransPlan.getGw();

        // 生成费用
        PretTransFee pretTransFee = this.genDefaultPretTransFee(null, null);
        BigDecimal quotation = BigDecimal.ZERO;
        this.repository.save(pretTransFee);
        List<PretQuotationItem> pretQuotationItemList = pretQuotationItemRepository.findByVenderIdAndServiceRouteItemIdAndS(pretTransPlan.getVenderId(), pretTransPlan.getServiceRouteItemId(), ConstantEnum.S.N.getLabel());
        BigDecimal unitPrice = BigDecimal.ZERO;
        for (PretQuotationItem pretQuotationItem : pretQuotationItemList) {
            PretTransFeeItem pretTransFeeItem = new PretTransFeeItem();
            pretTransFeeItem.setTransFeeId(pretTransFee.getId());
            pretTransFeeItem.setVenderId(pretTransPlan.getVenderId());
            PretBillingIntervalItem pretBillingIntervalItem = pretBillingIntervalItemRepository.findById(pretQuotationItem.getBillingIntervalItemId()).get();
            if (totalGw >= pretBillingIntervalItem.getKstart() && totalGw <= pretBillingIntervalItem.getKend()) {
                PretFeeType pretFeeType = pretFeeTypeRepository.findById(pretQuotationItem.getFeeTypeId()).get();
                if (pretFeeType.getName().equals(ConstantEnum.EFeeType.运费.name())) {
                    unitPrice = pretQuotationItem.getQuotation();
                }
                if (pretFeeType.getType() == ConstantEnum.ECostType.量.getLabel()) {
                    pretTransFeeItem.setQuotation(pretQuotationItem.getQuotation().multiply(new BigDecimal(totalGw)).setScale(2, BigDecimal.ROUND_HALF_UP));
                    pretTransFeeItem.setQuotationCount(totalGw);
                    pretTransFeeItem.setUnitPrice(pretQuotationItem.getQuotation());
                    quotation = quotation.add(pretTransFeeItem.getQuotation());
                } else {
                    pretTransFeeItem.setQuotation(pretQuotationItem.getQuotation());
                    pretTransFeeItem.setQuotationCount(1f);
                    pretTransFeeItem.setUnitPrice(pretQuotationItem.getQuotation());
                    quotation = quotation.add(pretTransFeeItem.getQuotation());
                }
                pretTransFeeItem.setFeeTypeId(pretQuotationItem.getFeeTypeId());
                pretTransFeeItemRepository.save(pretTransFeeItem);
            }
        }

        pretTransFee.setDeptId(pretTransPlan.getDeptId());
        pretTransFee.setQuotationCount(totalGw);
        pretTransFee.setStatus(ConstantEnum.EPretTransFeeStatus.待申报.getLabel());
        pretTransFee.setQuotation(quotation);
        pretTransFee.setCustomerId(pretTransPlan.getCustomerId());
        pretTransFee.setVenderId(pretTransPlan.getVenderId());
        pretTransFee.setTransPlanId(pretTransPlan.getId());
        pretTransFee.setUnitPrice(unitPrice);

        // 对接U9
        //组装请求参数
        JSONObject map = new JSONObject();
        map.put("ShipDocNo", pretTransPlan.getDeliveryBillNumber());
        map.put("ShipDocLineNo", pretTransPlan.getShipDocLineNo());
        map.put("ShipQty", pretTransPlan.getGw());
        map.put("ConfirmedQty", pretTransPlan.getGw());
        map.put("MBDTDocNo", pretTransPlan.getNo());
        String params = map.toString();
        /*try {
            String result = HttpUtil.sendPost(u9Url + "/services/UFIDA.U9.Cust.MBToERPSv.IOpDeliveryTaskSv.svc", params);
            U9ReturnBo u9ReturnBo = Constants.GSON.fromJson(result, U9ReturnBo.class);
            if (u9ReturnBo.getRtnBool().equals("True")) {
                pretTransFee.setRevokeStatus(ConstantEnum.ERevokeStatus.成功.getLabel());
            } else {
                pretTransFee.setRevokeStatus(ConstantEnum.ERevokeStatus.失败.getLabel());
            }
        } catch (Exception e) {
        }*/
        this.repository.save(pretTransFee);
        pretTransPlan.setTransFeeId(pretTransFee.getId());
        pretTransPlanRepository.save(pretTransPlan);
    }

    /* *
     * 功能描述: 编辑费用
     * 〈〉
     * @Param: [bo]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/11/28  10:12 下午
     */
    public void editTransFee(PretTransFeeBo bo) {
        PretTransFee pretTransFee = this.repository.findById(bo.getId()).get();
        pretTransFee.setStatus(ConstantEnum.EPretTransFeeStatus.审核通过.getLabel());
        List<PretTransFeeItem> list = CommonConstants.GSON.fromJson(bo.getPretTransFeeStr(),
                new TypeToken<List<PretTransFeeItem>>() {
                }.getType());
        List<PretTransFeeItem> pretTransFeeItemList = pretTransFeeItemRepository.findByCalTypeAndS(ConstantEnum.ECalType.手动计费.getLabel(), ConstantEnum.S.N.getLabel());
        if (pretTransFeeItemList != null && pretTransFeeItemList.size() > 0) {
            for (PretTransFeeItem pretTransFeeItem : pretTransFeeItemList) {
                pretTransFeeItemService.lDelete(pretTransFeeItem.getId());
            }
        }
        List<String> idList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            for (PretTransFeeItem item : list) {
                if (!StringUtils.isEmpty(item.getId())) {
                    idList.add(item.getId());
                }
                item.setVenderId(pretTransFee.getVenderId());
                item.setTransFeeId(pretTransFee.getId());
            }
            pretTransFeeItemRepository.saveAll(list);
            PretTransPlan pretTransPlan = pretTransPlanRepository.findById(pretTransFee.getTransPlanId()).get();

            //组装请求参数
          /*  JSONObject map = new JSONObject();
            map.put("ShipDocNo", pretTransPlan.getDeliveryBillNumber());
            map.put("ShipDocLineNo", pretTransPlan.getShipDocLineNo());
            map.put("ShipQty", pretTransPlan.getGw());
            map.put("ConfirmedQty", pretTransPlan.getGw());
            map.put("MBDTDocNo", pretTransPlan.getNo());
            String params = map.toString();
            try {
                String result = HttpUtil.sendPost(u9Url + "/services/UFIDA.U9.Cust.MBToERPUpdate.IDTUpdateFeeSv.svc", params);
                U9ReturnBo u9ReturnBo = Constants.GSON.fromJson(result, U9ReturnBo.class);
                if (u9ReturnBo.getRtnBool().equals("True")) {
                    pretTransFee.setRevokeStatus(ConstantEnum.ERevokeStatus.成功.getLabel());
                } else {
                    pretTransFee.setRevokeStatus(ConstantEnum.ERevokeStatus.失败.getLabel());
                }
            } catch (Exception e) {
            }*/
        }
        this.repository.save(pretTransFee);
    }

    public void editExceptionTransFee(PretTransFeeBo bo) {
        PretTransFee pretTransFee = this.repository.findById(bo.getId()).get();
        List<PretTransFeeItem> list = CommonConstants.GSON.fromJson(bo.getPretTransFeeStr(),
                new TypeToken<List<PretTransFeeItem>>() {
                }.getType());
        List<String> idList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            for (PretTransFeeItem item : list) {
                if (!StringUtils.isEmpty(item.getId())) {
                    idList.add(item.getId());
                }
                item.setVenderId(pretTransFee.getVenderId());
                item.setTransFeeId(pretTransFee.getId());
                item.setExceptionFee(ConstantEnum.EYesOrNo.是.getLabel());
            }
            List<PretTransFeeItem> pretTransFeeItemList = pretTransFeeItemRepository.findByExceptionFeeAndIdNotInAndS(ConstantEnum.EYesOrNo.是.getLabel(), idList, ConstantEnum.S.N.getLabel());
            if (pretTransFeeItemList != null && pretTransFeeItemList.size() > 0) {
                for (PretTransFeeItem pretTransFeeItem : pretTransFeeItemList) {
                    pretTransFeeItemService.lDelete(pretTransFeeItem.getId());
                }
            }
            pretTransFeeItemRepository.saveAll(list);
            this.repository.save(pretTransFee);
            PretTransPlan pretTransPlan = pretTransPlanRepository.findById(pretTransFee.getTransPlanId()).get();

            //组装请求参数
            JSONObject map = new JSONObject();
            map.put("ShipDocNo", pretTransPlan.getDeliveryBillNumber());
            map.put("ShipDocLineNo", pretTransPlan.getShipDocLineNo());
            map.put("ShipQty", pretTransPlan.getGw());
            map.put("ConfirmedQty", pretTransPlan.getGw());
            map.put("MBDTDocNo", pretTransPlan.getNo());
            String params = map.toString();
            try {
                String result = HttpUtil.sendPost(u9Url + "/services/UFIDA.U9.Cust.MBToERPUpdate.IDTUpdateFeeSv.svc", params);
                U9ReturnBo u9ReturnBo = Constants.GSON.fromJson(result, U9ReturnBo.class);
                if (u9ReturnBo.getRtnBool().equals("True")) {
                    pretTransFee.setRevokeStatus(ConstantEnum.ERevokeStatus.成功.getLabel());
                } else {
                    pretTransFee.setRevokeStatus(ConstantEnum.ERevokeStatus.失败.getLabel());
                }
            } catch (Exception e) {
            }
        }
    }
}
