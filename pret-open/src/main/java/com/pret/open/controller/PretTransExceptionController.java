package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.exception.FebsException;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.entity.*;
import com.pret.open.entity.bo.PretTransExceptionBo;
import com.pret.open.entity.vo.PretTransExceptionVo;
import com.pret.open.repository.*;
import com.pret.open.service.PretTransExceptionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Validated
@RestController
@RequestMapping("pretTransException")
public class PretTransExceptionController extends BaseManageController<PretTransExceptionService, PretTransException, PretTransExceptionVo> {
    @Autowired
    private PretVenderRepository pretVenderRepository;
    @Autowired
    private PretTransPlanRepository pretTransPlanRepository;
    @Autowired
    private PretTransExceptionItemRepository pretTransExceptionItemRepository;
    @Autowired
    private PretTransExceptionRepository pretTransExceptionRepository;
    @Autowired
    private PretTransOrderRepository pretTransOrderRepository;
    @Autowired
    private PretTransExceptionHandleRecordRepository pretTransExceptionHandleRecordRepository;

    @GetMapping
    @Override()
    public Map<String, Object> list(PretTransExceptionVo request, PretTransException t) {
        Page<PretTransException> page = this.service.page(request);
        for (PretTransException orgin : page.getContent()) {
            if (!StringUtils.isEmpty(orgin.getVenderId())) {
                PretVender pretVender = pretVenderRepository.findById(orgin.getVenderId()).get();
                orgin.setPretVender(pretVender);
            }
            if (!StringUtils.isEmpty(orgin.getTransPlanId())) {
                PretTransPlan pretTransPlan = pretTransPlanRepository.findById(orgin.getTransPlanId()).get();
                orgin.setPretTransPlan(pretTransPlan);
            }
        }
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", page.getContent());
        rspData.put("total", page.getTotalElements());

        return rspData;
    }

    @Log("查看")
    @PostMapping("/view/{id}")
    public PretTransException view(@PathVariable String id) throws FebsException {
        try {
            PretTransException item = this.service.findById(id).get();
            List<PretTransExceptionItem> itemList = pretTransExceptionItemRepository.findByTransExceptionId(item.getId());
            item.setPretTransExceptionItemList(itemList);

            List<PretTransExceptionHandleRecord> pretTransExceptionHandleRecordList = pretTransExceptionHandleRecordRepository.findByExceptionIdAndS(id, ConstantEnum.S.N.getLabel());
            item.setPretTransExceptionHandleRecordList(pretTransExceptionHandleRecordList);

            return item;
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
    }

    @Log("审核")
    @PostMapping("/auth/{id}/{status}")
    public void auth(@PathVariable String id, @PathVariable Integer status) throws FebsException {
        try {
            PretTransException pretTransException = this.service.findById(id).get();
            pretTransException.setStatus(status);
            pretTransExceptionRepository.save(pretTransException);

            if (status == ConstantEnum.ECheckStatus.通过.getLabel()) {
                PretTransPlan pretTransPlan = pretTransPlanRepository.findById(pretTransException.getTransPlanId()).get();
                PretTransPlan newP = new PretTransPlan();
                BeanUtilsExtended.copyProperties(newP, pretTransPlan);
                newP.setType(ConstantEnum.EPretTransPlanType.退货运输.getLabel());
                pretTransPlanRepository.save(newP);

                List<PretTransOrder> transOrderList = pretTransOrderRepository.findByTransPlanIdAndS(id, ConstantEnum.S.N.getLabel());
                if (transOrderList != null && transOrderList.size() > 0) {
                    for (PretTransOrder pretTransOrder : transOrderList) {
                        PretTransOrder transOrder = new PretTransOrder();
                        BeanUtilsExtended.copyProperties(transOrder, pretTransOrder);
                        transOrder.setType(ConstantEnum.EPretTransOrderType.返程配送单.getLabel());
                        pretTransOrderRepository.save(transOrder);
                    }
                }
            }


        } catch (Exception e) {
            message = "生成异常单失败";
            throw new FebsException(message);
        }
    }

    @Log("处理")
    @PostMapping("/handle")
    public void handle(PretTransExceptionBo bo) throws FebsException {
        try {
            this.service.handle(bo);
        } catch (Exception e) {
            throw new FebsException(message);
        }
    }

    @Log("更新")
    @PostMapping("/updateException")
    public void updateException(PretTransExceptionBo bo) throws FebsException {
        try {
            this.service.handle(bo);
        } catch (Exception e) {
            throw new FebsException(message);
        }
    }

    @Log("生成返程配送任务单")
    @PostMapping("/genRTransPlan/{id}")
    public void genRTransPlan(@PathVariable String id) throws FebsException {
        try {
            PretTransException pretTransException = this.service.findById(id).get();
            this.service.genRTransPlan(pretTransException);
        } catch (Exception e) {
            message = "生成异常单失败";
            throw new FebsException(message);
        }
    }

    @Log("结案")
    @PostMapping("/closeCase/{id}")
    public void closeCase(@PathVariable String id) throws FebsException {
        try {
            PretTransException pretTransException = this.service.findById(id).get();
            if (pretTransException.getIsReturnStatus() == 1 && pretTransException.getReturnStatus() == 2) {
                message = "货物未退回，无法结案";
                throw new FebsException(message);
            } else if (pretTransException.getReturnFeeStatus() == 1 && pretTransException.getCompensationStatus() == 2) {
                message = "赔偿金未支付，无法结案";
                throw new FebsException(message);
            }
            this.service.closeCase(id);
        } catch (Exception e) {
            throw new FebsException(message);
        }
    }

    @Log("赔款单上传")
    @PostMapping("/indemnityAccount/{id}/{images}/{handleUserId}/{handleUserName}")
    public void indemnityAccount(@PathVariable String id, @PathVariable String images, @PathVariable String handleUserId, @PathVariable String handleUserName) throws FebsException {
        try {
            this.service.indemnityAccount(id, images, handleUserId, handleUserName);
        } catch (Exception e) {
            message = "赔款单上传失败";
            throw new FebsException(message);
        }
    }
}