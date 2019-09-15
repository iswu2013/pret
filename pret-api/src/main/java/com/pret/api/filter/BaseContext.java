package com.pret.api.filter;

import com.pret.api.feign.IUserService;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;

@Service
public class BaseContext {
    @Autowired
    private DiscoveryClient discoveryClient;
    // 不需要登录的接口
    protected IUserService iUserService;

    @Autowired
    private LoadBalancerClient loadBalancer;

    /* *
     * 功能描述: <br>
     * 〈〉User
     * @Param: []
            * @Return: com.pret.api.feign.IUserService
            * @Author: jswul
            * @Date: 2019/6/20  23:49
     */
    public IUserService getiUserService() {
        this.iUserService = Feign.builder().encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(IUserService.class, loadBalancer.choose("pret-user").getUri().toString());

        return this.iUserService;
    }
}
