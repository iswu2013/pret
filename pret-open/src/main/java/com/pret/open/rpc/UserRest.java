package com.pret.rpc;

import com.pret.api.feign.IUserService;
import com.pret.api.info.CustomerInfo;
import com.pret.api.info.DriverInfo;
import com.pret.api.info.TypeUserInfo;
import com.pret.api.info.UserInfo;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.entity.PretCustomer;
import com.pret.open.entity.PretDriver;
import com.pret.open.entity.user.Role;
import com.pret.open.entity.user.User;
import com.pret.open.entity.user.UserRole;
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
        if (typeUserInfo.getType() != null) {
            if (typeUserInfo.getType() == ConstantEnum.EUserType.理货员.getLabel() || typeUserInfo.getType() == ConstantEnum.EUserType.业务员.getLabel() || typeUserInfo.getType() == ConstantEnum.EUserType.门卫.getLabel()) {
                User user = userRepository.findByOpenid(typeUserInfo.getOpenid());
                UserInfo userInfo = new UserInfo();
                BeanUtilsExtended.copyProperties(userInfo, user);
                typeUserInfo.setUserInfo(userInfo);
                has = true;
            } else if (typeUserInfo.getType() == ConstantEnum.EUserType.客户.getLabel()) {
                PretCustomer pretCustomer = pretCustomerRepository.findByOpenidAndS(typeUserInfo.getOpenid(), ConstantEnum.S.N.getLabel());
                CustomerInfo customerInfo = new CustomerInfo();
                BeanUtilsExtended.copyProperties(customerInfo, pretCustomer);
                typeUserInfo.setCustomerInfo(customerInfo);
                has = true;
            } else if (typeUserInfo.getType() == ConstantEnum.EUserType.司机.getLabel()) {
                PretDriver pretDriver = pretDriverRepository.findByOpenidAndS(typeUserInfo.getOpenid(), ConstantEnum.S.N.getLabel());
                DriverInfo driverInfo = new DriverInfo();
                BeanUtilsExtended.copyProperties(driverInfo, pretDriver);
                typeUserInfo.setDriverInfo(driverInfo);
                has = true;
            }
        } else {
            User user = userRepository.findByOpenid(typeUserInfo.getOpenid());
            if (user != null) {
                UserInfo userInfo = new UserInfo();
                BeanUtilsExtended.copyProperties(userInfo, user);
                UserRole userRole = userRoleRepository.findById(userInfo.getId()).get();
                Role role = roleRepository.findById(userRole.getRoleId()).get();
                int type = 0;
                if (role.getCode().equals(ConstantEnum.ERoleCode.Tallylerk.name())) {
                    type = ConstantEnum.ERoleCode.Tallylerk.getLabel();
                } else if (role.getCode().equals(ConstantEnum.ERoleCode.Salesman.name())) {
                    type = ConstantEnum.ERoleCode.Salesman.getLabel();
                } else if (role.getCode().equals(ConstantEnum.ERoleCode.Guard.name())) {
                    type = ConstantEnum.ERoleCode.Guard.getLabel();
                }
                typeUserInfo.setType(type);
                has = true;
            } else {
                PretCustomer pretCustomer = pretCustomerRepository.findByOpenidAndS(typeUserInfo.getOpenid(), ConstantEnum.S.N.getLabel());
                if (pretCustomer != null) {
                    CustomerInfo customerInfo = new CustomerInfo();
                    BeanUtilsExtended.copyProperties(customerInfo, pretCustomer);
                    typeUserInfo.setCustomerInfo(customerInfo);
                    typeUserInfo.setType(ConstantEnum.ERoleCode.Customer.getLabel());
                    has = true;
                }
                PretDriver pretDriver = pretDriverRepository.findByOpenidAndS(typeUserInfo.getOpenid(), ConstantEnum.S.N.getLabel());
                if (pretDriver != null) {
                    DriverInfo driverInfo = new DriverInfo();
                    BeanUtilsExtended.copyProperties(driverInfo, pretDriver);
                    typeUserInfo.setDriverInfo(driverInfo);
                    typeUserInfo.setType(ConstantEnum.ERoleCode.Driver.getLabel());
                    has = true;
                }
            }
        }
        if (!has) {
            return null;
        }

        return typeUserInfo;
    }
}
