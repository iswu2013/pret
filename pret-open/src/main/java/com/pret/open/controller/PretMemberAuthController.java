package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.exception.FebsException;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.entity.PretCustomer;
import com.pret.open.entity.PretMemberAuth;
import com.pret.open.entity.user.Dept;
import com.pret.open.entity.user.User;
import com.pret.open.entity.vo.PretMemberAuthVo;
import com.pret.open.repository.PretCustomerRepository;
import com.pret.open.repository.PretMemberAuthRepository;
import com.pret.open.repository.user.DeptRepository;
import com.pret.open.repository.user.UserRepository;
import com.pret.open.service.PretMemberAuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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

    @Log("审核")
    @PostMapping("/auth")
    public void auth(PretMemberAuth pretMemberAuth) throws FebsException {
        try {
            PretMemberAuth old = this.service.findById(pretMemberAuth.getId()).get();
            BeanUtilsExtended.copyPropertiesIgnore(old, pretMemberAuth);
            old.setAuthDate(new Date().getTime());
            pretMemberAuthRepository.save(old);


            if (pretMemberAuth.getUserType() == ConstantEnum.EUserType.客户.getLabel()) {
                PretCustomer pretCustomer = pretCustomerRepository.findByCodeAndS(pretMemberAuth.getU9code(), ConstantEnum.S.N.getLabel());
                if (pretCustomer == null) {
                    pretCustomer = new PretCustomer();
                    pretCustomer.setOpenid(pretMemberAuth.getOpenid());
                    pretCustomer.setCode(pretMemberAuth.getU9code());
                    pretCustomer.setLinkPhone(pretMemberAuth.getMobile());
                    pretCustomer.setLinkName(pretMemberAuth.getName());
                    pretCustomer.setStatus(pretMemberAuth.getStatus());
                    pretCustomer.setNickName(pretMemberAuth.getNickName());
                    pretCustomer.setAvatar(pretMemberAuth.getAvatarUrl());
                }
                pretCustomer.setStatus(pretMemberAuth.getStatus());
                pretCustomerRepository.save(pretCustomer);
            } else if (pretMemberAuth.getUserType() == ConstantEnum.EUserType.业务员.getLabel() || pretMemberAuth.getUserType() == ConstantEnum.EUserType.门卫.getLabel() || pretMemberAuth.getUserType() == ConstantEnum.EUserType.理货员.getLabel()) {
                User user = userRepository.findByMobileAndS(pretMemberAuth.getMobile(), ConstantEnum.S.N.getLabel());
                if (user == null) {
                    user = new User();
                    user.setU9code(pretMemberAuth.getU9code());
                    user.setNo(pretMemberAuth.getNo());
                    user.setUserType(pretMemberAuth.getUserType());
                    user.setName(pretMemberAuth.getName());
                    user.setNickName(pretMemberAuth.getNickName());
                    user.setAvatar(pretMemberAuth.getAvatarUrl());
                    user.setUsername(pretMemberAuth.getMobile());
                    user.setMobile(pretMemberAuth.getMobile());
                    user.setOpenid(pretMemberAuth.getOpenid());
                    if (pretMemberAuth.getUserType() == ConstantEnum.EUserType.业务员.getLabel()) {
                        Dept dept = deptRepository.findByU9codeAndS(ConstantEnum.EDeptCode.headquarters.name(), ConstantEnum.S.N.getLabel());
                        user.setDeptId(dept.getId());
                    } else {
                        user.setDeptId(pretMemberAuth.getDeptId());
                    }
                }
                user.setStatus(pretMemberAuth.getStatus());
                userRepository.save(user);
            }
        } catch (Exception e) {
            message = "审核失败";
            throw new FebsException(message);
        }
    }
}