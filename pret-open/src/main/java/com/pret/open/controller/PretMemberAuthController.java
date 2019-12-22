package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.exception.FebsException;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.common.utils.MD5Util;
import com.pret.open.entity.*;
import com.pret.open.entity.user.Dept;
import com.pret.open.entity.user.User;
import com.pret.open.entity.vo.PretMemberAuthVo;
import com.pret.open.entity.vo.PretPickUpPlanVo;
import com.pret.open.repository.PretCustomerRepository;
import com.pret.open.repository.PretMemberAuthRepository;
import com.pret.open.repository.PretSalesRepository;
import com.pret.open.repository.user.DeptRepository;
import com.pret.open.repository.user.UserRepository;
import com.pret.open.service.PretMemberAuthService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 审核
 */
@Slf4j
@Validated
@RestController
@RequestMapping("pretMemberAuth")
public class PretMemberAuthController extends BaseManageController<PretMemberAuthService, PretMemberAuth, PretMemberAuthVo> {
    @Autowired
    private PretMemberAuthRepository pretMemberAuthRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PretCustomerRepository pretCustomerRepository;
    @Autowired
    private DeptRepository deptRepository;
    @Autowired
    private PretSalesRepository pretSalesRepository;

    @GetMapping
    @Override()
    public Map<String, Object> list(PretMemberAuthVo request, PretMemberAuth t) {
        Page<PretMemberAuth> page = this.service.page(request);
        for (PretMemberAuth memberAuth : page.getContent()) {
            if (!StringUtils.isEmpty(memberAuth.getDeptId())) {
                Dept dept = deptRepository.findById(memberAuth.getDeptId()).get();
                memberAuth.setDept(dept);
            }
        }
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", page.getContent());
        rspData.put("total", page.getTotalElements());

        return rspData;
    }

    @Log("查看")
    @PostMapping("/view/{id}")
    public PretMemberAuth view(@PathVariable String id) throws FebsException {
        try {
            PretMemberAuth item = this.service.findById(id).get();
            if (item.getUserType() == ConstantEnum.EUserType.客户.getLabel()) {
                if (!StringUtils.isEmpty(item.getCustomerId())) {
                    PretCustomer pretCustomer = pretCustomerRepository.findById(item.getCustomerId()).get();
                    List<PretCustomer> pretCustomerList = new ArrayList<>();
                    pretCustomerList.add(pretCustomer);
                    item.setCustomerList(pretCustomerList);
                }
            } else if (item.getUserType() == ConstantEnum.EUserType.业务员.getLabel()) {
                if (!StringUtils.isEmpty(item.getSalesId())) {
                    PretSales pretSales = pretSalesRepository.findById(item.getSalesId()).get();
                    List<PretSales> pretSalesList = new ArrayList<>();
                    pretSalesList.add(pretSales);
                    item.setSalesList(pretSalesList);
                }
            }
            return item;
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
    }

    @Log("审核")
    @PostMapping("/auth")
    public void auth(PretMemberAuth pretMemberAuth) throws FebsException {
        try {
            PretMemberAuth old = this.service.findById(pretMemberAuth.getId()).get();
            BeanUtilsExtended.copyPropertiesIgnore(old, pretMemberAuth);
            old.setAuthDate(new Date().getTime());
            if (pretMemberAuth.getUserType() == ConstantEnum.EUserType.客户.getLabel()) {
                PretCustomer pretCustomer = pretCustomerRepository.findById(pretMemberAuth.getCustomerId()).get();
                old.setU9code(pretCustomer.getCode());
            } else if (pretMemberAuth.getUserType() == ConstantEnum.EUserType.业务员.getLabel()) {
                PretSales pretSales = pretSalesRepository.findById(pretMemberAuth.getSalesId()).get();
                old.setU9code(pretSales.getSalesCd());
            }
            pretMemberAuthRepository.save(old);
        } catch (Exception e) {
            message = "审核失败";
            throw new FebsException(message);
        }
    }
}