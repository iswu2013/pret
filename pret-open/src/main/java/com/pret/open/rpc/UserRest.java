package com.pret.open.rpc;

import com.pret.api.feign.IUserService;
import com.pret.api.info.CustomerInfo;
import com.pret.api.info.DriverInfo;
import com.pret.api.info.TypeUserInfo;
import com.pret.api.info.UserInfo;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.entity.PretCustomer;
import com.pret.open.entity.PretDriver;
import com.pret.open.entity.PretMemberAuth;
import com.pret.open.entity.user.User;
import com.pret.open.repository.PretCustomerRepository;
import com.pret.open.repository.PretDriverRepository;
import com.pret.open.repository.PretMemberAuthRepository;
import com.pret.open.repository.user.RoleRepository;
import com.pret.open.repository.user.UserRepository;
import com.pret.open.repository.user.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 */
@RestController
@CrossOrigin
@RequestMapping("api")
public class UserRest implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PretCustomerRepository pretCustomerRepository;
    @Autowired
    private PretDriverRepository pretDriverRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PretMemberAuthRepository pretMemberAuthRepository;

    /* *
     * 功能描述: 根据token查找用户
     * 〈〉
     * @Param: [userInfo]
     * @Return: com.pret.api.info.UserInfo
     * @Author: jswul
     * @Date: 2019/6/27  10:08
     */
    @RequestMapping(value = "/user/findByOpenid", method = RequestMethod.POST)
    @Override
    public TypeUserInfo findByOpenid(@RequestBody TypeUserInfo typeUserInfo) {
        boolean has = false;
        PretMemberAuth pretMemberAuth = pretMemberAuthRepository.findByOpenidAndS(typeUserInfo.getOpenid(), ConstantEnum.S.N.getLabel());
        if (pretMemberAuth != null) {
            has = true;
            typeUserInfo.setType(pretMemberAuth.getUserType());
            if (pretMemberAuth != null) {
                typeUserInfo.setNickName(pretMemberAuth.getNickName());
                typeUserInfo.setAvatarUrl(pretMemberAuth.getAvatarUrl());
            }
        }
        if (!has) {
            return null;
        }
        return typeUserInfo;
    }
}
