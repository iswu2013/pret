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
import com.pret.open.u9.tempuri.*;
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
    private PretTransRecordRepository pretTransRecordRepository;
    @Autowired
    private PretTransOrderGroupRepository pretTransOrderGroupRepository;
    @Autowired
    private PretTransFeeRecordRepository pretTransFeeRecordRepository;
    @Autowired
    private PretVenderRepository pretVenderRepository;
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
    public void transFeeAppl(String ids, String username) {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            PretTransFee transFee = this.repository.findById(id).get();
            transFee.setStatus(ConstantEnum.EPretTransFeeStatus.已申报.getLabel());
            this.repository.save(transFee);

            // 添加一条记录
            PretTransFeeRecord pretTransFeeRecord = new PretTransFeeRecord();

            pretTransFeeRecord.setDescription(ConstantEnum.EPretTransFeeRecordDescription.运费申报.name());
            pretTransFeeRecord.setTransFeeId(transFee.getId());
            pretTransFeeRecord.setType(ConstantEnum.ETransOrderStatisticsUserType.物流供应商.getLabel());
            pretTransFeeRecord.setUsername(username);
            pretTransFeeRecordRepository.save(pretTransFeeRecord);
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
        Float signGw = pretTransPlan.getSignGw();

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
                    pretTransFeeItem.setQuotation(pretQuotationItem.getQuotation().multiply(new BigDecimal(signGw)).setScale(2, BigDecimal.ROUND_HALF_UP));
                    pretTransFeeItem.setQuotationCount(signGw);
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
        pretTransFee.setTransNo(pretTransPlan.getNo());
        pretTransFee.setStatus(ConstantEnum.EPretTransFeeStatus.待申报.getLabel());
        pretTransFee.setQuotation(quotation);
        pretTransFee.setCustomerId(pretTransPlan.getCustomerId());
        pretTransFee.setVenderId(pretTransPlan.getVenderId());
        pretTransFee.setTransPlanId(pretTransPlan.getId());
        pretTransFee.setUnitPrice(unitPrice);
        pretTransFee.setTransDatetimeLong(pretTransPlan.getTransDatetime().getTime());

        // 对接U9
        //组装请求参数
        MBToERPService mbToERPService = new MBToERPService();
        ObjectFactory objectFactory = new ObjectFactory();
        MBToERPServiceSoap mbToERPServiceSoap = mbToERPService.getMBToERPServiceSoap();
        ArrayOfDTDoc arrayOfDTDoc = objectFactory.createArrayOfDTDoc();
        DTDoc dtDoc = new DTDoc();
        dtDoc.setTransType(String.valueOf(pretTransPlan.getTransType()));
        PretVender pretVender = pretVenderRepository.findById(pretTransPlan.getVenderId()).get();
        dtDoc.setSupplier(pretVender.getCode());
        dtDoc.setMBDocNo(pretTransPlan.getNo());


        ArrayOfDTLines arrayOfDTLines = new ArrayOfDTLines();
        Integer docType = null;
        List<PretTransOrder> pretTransOrderList = pretTransOrderRepository.findByTransPlanIdAndS(pretTransPlan.getId(), ConstantEnum.S.N.getLabel());
        if (pretTransOrderList != null && pretTransOrderList.size() > 0) {
            List<DTLines> dtLinesList = new ArrayList<>();
            for (PretTransOrder pretTransOrder : pretTransOrderList) {
                DTLines dtLines = new DTLines();
                dtLines.setConfirmedQty(new BigDecimal(pretTransOrder.getSignCount()));
                dtLines.setShipQty(new BigDecimal(pretTransOrder.getGw()));
                dtLines.setU9DocLineNo(Integer.parseInt(pretTransOrder.getLineNo()));
                dtLines.setU9DocNo(pretTransOrder.getDeliveryBillNumber());
                dtLinesList.add(dtLines);
                arrayOfDTLines.getDTLines().add(dtLines);
                if (docType == null) {
                    docType = pretTransOrder.getTransType();
                }
            }
        }
        dtDoc.setDocType(String.valueOf(docType));
        dtDoc.setDTLines(arrayOfDTLines);
        arrayOfDTDoc.getDTDoc().add(dtDoc);
//        if (pretTransPlan.getTransType() == ConstantEnum.ETransType.测试数据.getLabel()) {
        try {
            RetMsg retMsg = mbToERPServiceSoap.createDeliveryTask(arrayOfDTDoc, null, null);
            if (retMsg.getMessageType().equals("True")) {
                pretTransFee.setRevokeStatus(ConstantEnum.ERevokeStatus.成功.getLabel());

                // 添加一条记录
                PretTransRecord pretTransRecord = new PretTransRecord();

                pretTransRecord.setDescription(ConstantEnum.EPretTransRecordDescription.运单传ERP.name());
                pretTransRecord.setTransPlanId(bo.getId());
                pretTransRecord.setType(ConstantEnum.ETransOrderStatisticsUserType.系统.getLabel());
                pretTransRecord.setUsername(bo.getUsername());
                pretTransRecordRepository.save(pretTransRecord);

                // 添加一条记录
                PretTransFeeRecord pretTransFeeRecord = new PretTransFeeRecord();

                pretTransFeeRecord.setDescription(ConstantEnum.EPretTransFeeRecordDescription.费用转ERP.name());
                pretTransFeeRecord.setTransFeeId(pretTransFee.getId());
                pretTransFeeRecord.setType(ConstantEnum.ETransOrderStatisticsUserType.系统.getLabel());
                pretTransFeeRecord.setUsername(bo.getUsername());
                pretTransFeeRecordRepository.save(pretTransFeeRecord);
            } else {
                pretTransFee.setRevokeStatus(ConstantEnum.ERevokeStatus.失败.getLabel());
            }
        } catch (Exception e) {

        }
//        }
        this.repository.save(pretTransFee);
        pretTransPlan.setTransFeeId(pretTransFee.getId());
        pretTransPlanRepository.save(pretTransPlan);

        // 添加一条记录
        PretTransFeeRecord pretTransFeeRecord = new PretTransFeeRecord();

        pretTransFeeRecord.setDescription(ConstantEnum.EPretTransFeeRecordDescription.生成运输费用.name());
        pretTransFeeRecord.setTransFeeId(pretTransFee.getId());
        pretTransFeeRecord.setType(ConstantEnum.ETransOrderStatisticsUserType.系统.getLabel());
        pretTransFeeRecord.setUsername(ConstantEnum.ETransOrderStatisticsUserType.系统.name());
        pretTransFeeRecordRepository.save(pretTransFeeRecord);
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
        }
        this.repository.save(pretTransFee);

        // 添加一条记录
        PretTransFeeRecord pretTransFeeRecord = new PretTransFeeRecord();

        pretTransFeeRecord.setDescription(ConstantEnum.EPretTransFeeRecordDescription.运费审核.name());
        pretTransFeeRecord.setTransFeeId(pretTransFee.getId());
        pretTransFeeRecord.setType(ConstantEnum.ETransOrderStatisticsUserType.平台.getLabel());
        pretTransFeeRecord.setUsername(bo.getUsername());
        pretTransFeeRecordRepository.save(pretTransFeeRecord);

        MBToERPService mbToERPService = new MBToERPService();
        ObjectFactory objectFactory = new ObjectFactory();
        MBToERPServiceSoap mbToERPServiceSoap = mbToERPService.getMBToERPServiceSoap();

        PretTransPlan pretTransPlan = pretTransPlanRepository.findById(pretTransFee.getTransPlanId()).get();

        ArrayOfFeeDoc arrayOfFeeDoc = objectFactory.createArrayOfFeeDoc();
        FeeDoc feeDoc = new FeeDoc();
        feeDoc.setMBDocNo(pretTransPlan.getNo());

        ArrayOfFeeLines arrayOfDTLines = new ArrayOfFeeLines();
        PretFeeType pretFeeType = pretFeeTypeRepository.findByNameAndS(ConstantEnum.EFeeTypeName.运费.name(), ConstantEnum.S.N.getLabel());
        List<PretTransFeeItem> pretTransFeeItems = pretTransFeeItemRepository.findByTransFeeIdAndFeeTypeIdAndS(bo.getId(), pretFeeType.getId(), ConstantEnum.S.N.getLabel());
        BigDecimal bigDecimal = BigDecimal.ZERO;
        for (PretTransFeeItem transFee : pretTransFeeItems) {
            bigDecimal = bigDecimal.add(transFee.getQuotation());
        }
        FeeLines dtLines = new FeeLines();
        dtLines.setConfirmedQty(new BigDecimal(pretTransPlan.getSignGw()));
        dtLines.setFee(bigDecimal);
        dtLines.setStartArea(pretTransPlan.getOrgBigAreaCd());
        dtLines.setEndArea(pretTransPlan.getDestBigAreaCd());
        //dtLines.setFeeType("物流费");
        arrayOfDTLines.getFeeLines().add(dtLines);

        pretTransFeeItems = pretTransFeeItemRepository.findByTransFeeIdAndFeeTypeIdNotAndS(bo.getId(), pretFeeType.getId(), ConstantEnum.S.N.getLabel());
        bigDecimal = BigDecimal.ZERO;
        for (PretTransFeeItem transFee : pretTransFeeItems) {
            bigDecimal = bigDecimal.add(transFee.getQuotation());
        }
        dtLines = new FeeLines();
        dtLines.setConfirmedQty(new BigDecimal(pretTransPlan.getSignGw()));
        dtLines.setFee(bigDecimal);
        dtLines.setStartArea(pretTransPlan.getOrgBigAreaCd());
        dtLines.setEndArea(pretTransPlan.getDestBigAreaCd());
        // dtLines.setFeeType("杂费");
        arrayOfDTLines.getFeeLines().add(dtLines);
        feeDoc.setFeeLines(arrayOfDTLines);

        if (pretTransPlan.getTransType() == ConstantEnum.ETransType.测试数据.getLabel()) {
            mbToERPServiceSoap.updateDeliveryTaskFee(arrayOfFeeDoc, null, null);
        }
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

            // 添加一条记录
            PretTransFeeRecord pretTransFeeRecord = new PretTransFeeRecord();

            pretTransFeeRecord.setDescription(ConstantEnum.EPretTransFeeRecordDescription.费用调整.name());
            pretTransFeeRecord.setTransFeeId(pretTransFee.getId());
            pretTransFeeRecord.setType(ConstantEnum.ETransOrderStatisticsUserType.平台.getLabel());
            pretTransFeeRecord.setUsername(bo.getUsername());
            pretTransFeeRecordRepository.save(pretTransFeeRecord);
        }
    }
}
