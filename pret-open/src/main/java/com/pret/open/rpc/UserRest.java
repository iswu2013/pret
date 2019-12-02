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
import com.pret.open.entity.user.User;
import com.pret.open.repository.PretCustomerRepository;
import com.pret.open.repository.PretDriverRepository;
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
        User user = userRepository.findByOpenid(typeUserInfo.getOpenid());
        if (user != null) {
            if (user.getUserType() == ConstantEnum.EUserType.理货员.getLabel() || user.getUserType() == ConstantEnum.EUserType.业务员.getLabel() || user.getUserType() == ConstantEnum.EUserType.门卫.getLabel()) {
                UserInfo userInfo = new UserInfo();
                BeanUtilsExtended.copyProperties(userInfo, user);
                typeUserInfo.setUserInfo(userInfo);
                has = true;
                typeUserInfo.setType(user.getUserType());
            }
        }
        if (!has) {
            PretCustomer pretCustomer = pretCustomerRepository.findByOpenidAndS(typeUserInfo.getOpenid(), ConstantEnum.S.N.getLabel());
            CustomerInfo customerInfo = new CustomerInfo();
            BeanUtilsExtended.copyProperties(customerInfo, pretCustomer);
            typeUserInfo.setCustomerInfo(customerInfo);
            has = true;
            typeUserInfo.setType(ConstantEnum.ERoleCode.Customer.getLabel());
        }
        if (!has) {
            PretDriver pretDriver = pretDriverRepository.findByOpenidAndS(typeUserInfo.getOpenid(), ConstantEnum.S.N.getLabel());
            DriverInfo driverInfo = new DriverInfo();
            BeanUtilsExtended.copyProperties(driverInfo, pretDriver);
            typeUserInfo.setDriverInfo(driverInfo);
            has = true;
            typeUserInfo.setType(ConstantEnum.ERoleCode.Driver.getLabel());
        }
        if (!has) {
            return null;
        }
        return typeUserInfo;
    }
}
