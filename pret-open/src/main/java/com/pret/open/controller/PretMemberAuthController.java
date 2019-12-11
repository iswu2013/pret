package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.exception.FebsException;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.entity.PretCustomer;
import com.pret.open.entity.PretMemberAuth;
import com.pret.open.entity.user.User;
import com.pret.open.entity.vo.PretMemberAuthVo;
import com.pret.open.repository.PretCustomerRepository;
import com.pret.open.repository.PretMemberAuthRepository;
import com.pret.open.repository.user.UserRepository;
import com.pret.open.service.PretMemberAuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Log("审核")
    @PostMapping("/auth")
    public void auth(PretMemberAuth pretMemberAuth) throws FebsException {
        try {
            PretMemberAuth old = this.service.findById(pretMemberAuth.getId()).get();
            BeanUtilsExtended.copyPropertiesIgnore(old, pretMemberAuth);
            pretMemberAuthRepository.save(old);

            if (pretMemberAuth.getUserType() == ConstantEnum.EUserType.客户.getLabel()) {
                PretCustomer pretCustomer = new PretCustomer();
                pretCustomer.setOpenid(pretMemberAuth.getOpenid());
                pretCustomer.setCode(pretMemberAuth.getNo());
                pretCustomer.setLinkPhone(pretMemberAuth.getMobile());
                pretCustomer.setLinkName(pretMemberAuth.getName());
                pretCustomerRepository.save(pretCustomer);
            } else if (pretMemberAuth.getUserType() == ConstantEnum.EUserType.业务员.getLabel() || pretMemberAuth.getUserType() == ConstantEnum.EUserType.门卫.getLabel() || pretMemberAuth.getUserType() == ConstantEnum.EUserType.理货员.getLabel()) {
                User user = new User();
                user.setU9code(pretMemberAuth.getNo());
                user.setUserType(pretMemberAuth.getUserType());
                user.setName(pretMemberAuth.getName());
                user.setNickName(pretMemberAuth.getNickName());
                user.setAvatar(pretMemberAuth.getAvatarUrl());
                user.setUsername(pretMemberAuth.getMobile());
                user.setMobile(pretMemberAuth.getMobile());
                user.setOpenid(pretMemberAuth.getOpenid());
                if (pretMemberAuth.getUserType() == ConstantEnum.EUserType.业务员.getLabel()) {
                    user.setDeptId(pretMemberAuth.getDeptId());
                } else {
                    user.setDeptId(pretMemberAuth.getDeptId());
                }

                userRepository.save(user);
            }
        } catch (Exception e) {
            message = "审核失败";
            throw new FebsException(message);
        }
    }
}