package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.*;
import com.pret.open.entity.bo.PretTransStatementBo;
import com.pret.open.entity.vo.PretTransStatementVo;
import com.pret.open.repository.*;
import com.pret.open.service.PretTransStatementService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Validated
@RestController
@RequestMapping("pretTransStatement")
public class PretTransStatementController extends BaseManageController<PretTransStatementService, PretTransStatement, PretTransStatementVo> {
    @Autowired
    private PretVenderRepository pretVenderRepository;
    @Autowired
    private PretCurrencyRepository pretCurrencyRepository;
    @Autowired
    private PretTransPlanRepository pretTransPlanRepository;
    @Autowired
    private PretTransFeeRepository pretTransFeeRepository;
    @Autowired
    private PretTransOrderRepository pretTransOrderRepository;
    @Autowired
    private PretCustomerRepository pretCustomerRepository;

    @GetMapping
    @Override()
    public Map<String, Object> list(PretTransStatementVo request, PretTransStatement t) {
        Page<PretTransStatement> page = this.service.page(request);
        for (PretTransStatement transStatement : page.getContent()) {
            if (!StringUtils.isEmpty(transStatement.getBillToId())) {
                PretVender pretVender = pretVenderRepository.findById(transStatement.getBillToId()).get();
                transStatement.setPretVender(pretVender);
            }
            if (!StringUtils.isEmpty(transStatement.getCurrencyId())) {
                PretCurrency pretCurrency = pretCurrencyRepository.findById(transStatement.getCurrencyId()).get();
                transStatement.setPretCurrency(pretCurrency);
            }
        }
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", page.getContent());
        rspData.put("total", page.getTotalElements());

        return rspData;
    }

    @Log("查看")
    @PostMapping("/view/{id}")
    public PretTransStatement view(@PathVariable String id) throws FebsException {
        try {
            PretTransStatement item = this.service.findById(id).get();
            if (!StringUtils.isEmpty(item.getBillToId())) {
                PretVender pretVender = pretVenderRepository.findById(item.getBillToId()).get();
                item.setPretVender(pretVender);
            }
            if (!StringUtils.isEmpty(item.getCurrencyId())) {
                PretCurrency pretCurrency = pretCurrencyRepository.findById(item.getCurrencyId()).get();
                item.setPretCurrency(pretCurrency);
            }

//            List<PretTransPlan> pretTransPlanList = pretTransPlanRepository.findByTransStatementIdAndS(item.getId(), ConstantEnum.S.N.getLabel());
//            for(PretTransPlan pretTransPlan:pretTransPlanList) {
//                PretCustomer pretCustomer = pretCustomerRepository.findById(pretTransPlan.getCustomerId()).get();
//                pretTransPlan.setPretCustomer(pretCustomer);
//            }
//            item.setPretTransPlanList(pretTransPlanList);
            List<PretTransFee> pretTransFeeList = pretTransFeeRepository.findByTransStatementIdAndS(id, ConstantEnum.S.N.getLabel());
            item.setPretTransFeeList(pretTransFeeList);

            return item;
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
    }

    @Log("生成对账作业")
    @PostMapping("/genTransStatement")
    public void genTransStatement(PretTransStatementBo bo) throws FebsException {
        try {
            this.service.genTransStatement(bo);
        } catch (Exception e) {
            message = "生成对账作业失败";
            throw new FebsException(message);
        }
    }

    @InitBinder
    protected void dateBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, editor);
    }
}