//package com.pret.rpc;
//
//import com.pret.api.feign.IUserService;
//import com.pret.api.info.UserInfo;
//import com.pret.common.constant.ConstantEnum;
//import com.pret.common.util.BeanUtilsExtended;
//import com.pret.entity.CmsUser;
//import com.pret.repository.CmsUserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
///**
// *
// */
//@RestController
//@CrossOrigin
//@RequestMapping("api")
//public class UserRest implements IUserService {
//    @Autowired
//    private CmsUserRepository cmsUserRepository;
//
//    /* *
//     * 功能描述: 根据token查找用户
//     * 〈〉
//     * @Param: [userInfo]
//     * @Return: com.pret.api.info.UserInfo
//     * @Author: jswul
//     * @Date: 2019/6/27  10:08
//     */
//    @RequestMapping(value = "/user/findByToken", method = RequestMethod.POST)
//    @Override
//    public UserInfo findByToken(@RequestBody UserInfo userInfo) {
//        CmsUser user = cmsUserRepository.findByToken(userInfo.getUtoken());
//        if (user != null) {
//            BeanUtilsExtended.copyPropertiesAdd(userInfo, user, userInfo.getLang(), ConstantEnum.LangEnum.getByName(ConstantEnum.EntityEnum.User.name()));
//        } else {
//            return null;
//        }
//        return userInfo;
//    }
//}
