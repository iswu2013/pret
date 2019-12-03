package com.pret.open.service.user;


import com.pret.api.service.impl.BaseServiceImpl;
import com.pret.api.vo.ResBody;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.exception.BusinessException;
import com.pret.open.constant.OpenBEEnum;
import com.pret.open.entity.PretCustomer;
import com.pret.open.entity.PretDriver;
import com.pret.open.entity.user.User;
import com.pret.open.entity.vo.user.UserVo;
import com.pret.open.repository.PretCustomerRepository;
import com.pret.open.repository.PretDriverRepository;
import com.pret.open.repository.user.UserRepository;
import com.pret.open.vo.req.P1000004Vo;
import com.pret.open.vo.req.P1000007Vo;
import com.pret.open.vo.res.PR1000004Vo;
import com.pret.open.vo.res.PR1000007Vo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

/**
 * Description: [t服务]
 * Created on 2019年10月19日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class UserService extends BaseServiceImpl<UserRepository, User, UserVo> {
    @Autowired
    private PretCustomerRepository pretCustomerRepository;
    @Autowired
    private PretDriverRepository pretDriverRepository;

    /* *
     * 功能描述: 绑定用户
     * 〈〉
     * @Param: [res]
     * @Return: com.pret.api.vo.ResBody
     * @Author: wujingsong
     * @Date: 2019/10/19  6:30 上午
     */
    public ResBody bindUser(P1000004Vo res) {
        PR1000004Vo retVo = new PR1000004Vo();

        User user = this.repository.findByMobileAndS(res.getPhone(), ConstantEnum.S.N.getLabel());
        if (res.getType() == ConstantEnum.EUserType.理货员.getLabel()) {
            if (user != null) {
                user.setOpenid(res.getOpenId());
                user.setBinding(ConstantEnum.YesOrNo.是.getLabel());
                user.setUserType(res.getType());
                this.repository.save(user);
            } else {
                throw new BusinessException(OpenBEEnum.E90000003.name(), OpenBEEnum.E90000003.getMsg());
            }
        } else if (res.getType() == ConstantEnum.EUserType.业务员.getLabel()) {
            if (user != null) {
                user.setOpenid(res.getOpenId());
                user.setBinding(ConstantEnum.YesOrNo.是.getLabel());
                user.setUserType(res.getType());
                if (StringUtils.isEmpty(user.getU9code())) {
                    retVo.setHasU9code(0);
                } else {
                    retVo.setHasU9code(1);
                }

                this.repository.save(user);
            } else {
                user = new User();
                retVo.setHasU9code(1);
                user.setOpenid(res.getOpenId());
                user.setBinding(ConstantEnum.YesOrNo.是.getLabel());
                user.setUserType(res.getType());
                this.repository.save(user);
            }
        } else if (res.getType() == ConstantEnum.EUserType.门卫.getLabel()) {
            if (user != null) {
                user.setOpenid(res.getOpenId());
                user.setBinding(ConstantEnum.YesOrNo.是.getLabel());
                user.setUserType(res.getType());
                this.repository.save(user);
            } else {
                throw new BusinessException(OpenBEEnum.E90000003.name(), OpenBEEnum.E90000003.getMsg());
            }
        } else if (res.getType() == ConstantEnum.EUserType.客户.getLabel()) {
            PretCustomer pretCustomer = pretCustomerRepository.findByLinkPhoneAndS(res.getPhone(), ConstantEnum.S.N.getLabel());
            if (pretCustomer != null) {
                pretCustomer.setOpenid(res.getOpenId());
                pretCustomerRepository.save(pretCustomer);
            } else {
                throw new BusinessException(OpenBEEnum.E90000003.name(), OpenBEEnum.E90000003.getMsg());
            }
        } else if (res.getType() == ConstantEnum.EUserType.司机.getLabel()) {
            PretDriver pretDriver = pretDriverRepository.findByPhoneAndS(res.getPhone(), ConstantEnum.S.N.getLabel());
            pretDriver.setOpenid(res.getOpenId());
            pretDriverRepository.save(pretDriver);
        }
        user.setToken(UUID.randomUUID().toString().replace("-", ""));
        retVo.setData(user);
        retVo.setOpenId(user.getOpenid());
        retVo.setToken(user.getToken());
        retVo.setSessionKey(user.getSessionKey());
        retVo.setUser(user);
        this.repository.save(user);

        return retVo;
    }

    /* *
     * 功能描述: <br>
     * 〈〉
     * @Param: [res]
     * @Return: com.pret.api.vo.ResBody
     * @Author: wujingsong
     * @Date: 2019/12/2  11:31 下午
     */
    public ResBody inputU9Code(P1000007Vo res) {
        PR1000007Vo retVo = new PR1000007Vo();
        User user = this.repository.findById(res.getId()).get();
        user.setU9code(res.getU9code());
        this.repository.save(user);

        return retVo;
    }
}
