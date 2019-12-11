package com.pret.api.feign;


import com.pret.api.info.TypeUserInfo;
import com.pret.api.info.UserInfo;
import feign.Headers;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * 用户管理
 */
@FeignClient(name = "pret-open")
public interface IUserService {
    /**
     * 功能描述: 根据token查找
     * 〈〉
     *
     * @Param: [userInfo]
     * @Return: com.pret.api.info.UserInfo
     * @Author: jswul
     * @Date: 2019/6/27  10:13
     */
    @RequestLine(value = "POST /api/user/findByOpenid")
    @Headers("Content-Type: application/json")
    TypeUserInfo findByOpenid(@RequestBody TypeUserInfo typeUserInfo);
}
