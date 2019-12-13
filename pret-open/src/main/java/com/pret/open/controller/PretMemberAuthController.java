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
import com.pret.open.repository.user.DeptRepository;
import com.pret.open.repository.user.UserRepository;
import com.pret.open.service.PretMemberAuthService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Log("审核")
    @PostMapping("/auth")
    public void auth(PretMemberAuth pretMemberAuth) throws FebsException {
        try {
            PretMemberAuth old = this.service.findById(pretMemberAuth.getId()).get();
            BeanUtilsExtended.copyPropertiesIgnore(old, pretMemberAuth);
            old.setAuthDate(new Date().getTime());
            pretMemberAuthRepository.save(old);


            if (old.getUserType() == ConstantEnum.EUserType.客户.getLabel()) {
                PretCustomer pretCustomer = pretCustomerRepository.findByCodeAndS(old.getU9code(), ConstantEnum.S.N.getLabel());
                if (pretCustomer == null) {
                    pretCustomer = new PretCustomer();
                    pretCustomer.setOpenid(old.getOpenid());
                    pretCustomer.setCode(old.getU9code());
                    pretCustomer.setLinkPhone(old.getMobile());
                    pretCustomer.setLinkName(old.getName());
                    pretCustomer.setStatus(old.getStatus());
                    pretCustomer.setNickName(old.getNickName());
                    pretCustomer.setAvatar(old.getAvatarUrl());
                }
                pretCustomer.setStatus(old.getStatus());
                pretCustomerRepository.save(pretCustomer);
            } else if (old.getUserType() == ConstantEnum.EUserType.业务员.getLabel() || old.getUserType() == ConstantEnum.EUserType.门卫.getLabel() || old.getUserType() == ConstantEnum.EUserType.理货员.getLabel()) {
                User user = userRepository.findByMobileAndS(old.getMobile(), ConstantEnum.S.N.getLabel());
                if (user == null) {
                    user = new User();
                    user.setU9code(old.getU9code());
                    user.setNo(old.getNo());
                    user.setUserType(old.getUserType());
                    user.setName(old.getName());
                    user.setNickName(old.getNickName());
                    user.setAvatar(old.getAvatarUrl());
                    user.setUsername(old.getMobile());
                    user.setMobile(old.getMobile());
                    user.setOpenid(old.getOpenid());
                    user.setPassword(MD5Util.encrypt(user.getUsername(), User.DEFAULT_PASSWORD));
                    if (old.getUserType() == ConstantEnum.EUserType.业务员.getLabel()) {
                        Dept dept = deptRepository.findByU9codeAndS(ConstantEnum.EDeptCode.headquarters.name(), ConstantEnum.S.N.getLabel());
                        user.setDeptId(dept.getId());
                    } else {
                        user.setDeptId(old.getDeptId());
                    }
                }
                user.setStatus(old.getStatus());
                userRepository.save(user);
            }
        } catch (Exception e) {
            message = "审核失败";
            throw new FebsException(message);
        }
    }
}