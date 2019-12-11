package com.pret.open.service.user;


import com.pret.api.service.impl.BaseServiceImpl;
import com.pret.api.vo.ResBody;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.exception.BusinessException;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.constant.OpenBEEnum;
import com.pret.open.entity.PretCustomer;
import com.pret.open.entity.PretDriver;
import com.pret.open.entity.PretMemberAuth;
import com.pret.open.entity.user.Dept;
import com.pret.open.entity.user.User;
import com.pret.open.entity.vo.user.UserVo;
import com.pret.open.repository.PretCustomerRepository;
import com.pret.open.repository.PretDriverRepository;
import com.pret.open.repository.PretMemberAuthRepository;
import com.pret.open.repository.user.DeptRepository;
import com.pret.open.repository.user.UserRepository;
import com.pret.open.vo.req.P1000004Vo;
import com.pret.open.vo.req.P1000007Vo;
import com.pret.open.vo.res.PR1000004Vo;
import com.pret.open.vo.res.PR1000007Vo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
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
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DeptRepository deptRepository;
    @Autowired
    private PretMemberAuthRepository pretMemberAuthRepository;

    public List<String> getDeptIdListByUserId(String userId) {
        List<String> idList = new ArrayList<>();

        if (!StringUtils.isEmpty(userId)) {
            User user = userRepository.findById(userId).get();
            Dept dept = deptRepository.findById(user.getDeptId()).get();
            idList.add(dept.getId());
            List<Dept> deptList = deptRepository.findByParentIdAndS(dept.getId(), ConstantEnum.S.N.getLabel());
            if (deptList != null && deptList.size() > 0) {
                for (Dept p : deptList) {
                    idList.add(p.getId());
                    deptList = deptRepository.findByParentIdAndS(p.getId(), ConstantEnum.S.N.getLabel());
                    if (deptList != null && deptList.size() > 0) {
                        for (Dept d : deptList) {
                            idList.add(d.getId());
                        }
                    }
                }
            }
        }

        return idList;
    }

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
     * 功能描述: 注册
     * 〈〉
     * @Param: [res]
     * @Return: com.pret.api.vo.ResBody
     * @Author: wujingsong
     * @Date: 2019/12/2  11:31 下午
     */
    public ResBody inputU9Code(P1000007Vo res) {
        PR1000007Vo retVo = new PR1000007Vo();

        PretMemberAuth pretMemberAuth = pretMemberAuthRepository.findByOpenidAndS(res.getOpenId(), ConstantEnum.S.N.getLabel());
        if (pretMemberAuth != null) {
            throw new BusinessException(OpenBEEnum.E90000005.name(), OpenBEEnum.E90000005.getMsg() + "：" + this.getRoleName(pretMemberAuth.getUserType()));
        }

        pretMemberAuth = new PretMemberAuth();
        BeanUtilsExtended.copyPropertiesIgnore(pretMemberAuth, res);
        pretMemberAuth.setOpenid(res.getOpenId());
        pretMemberAuthRepository.save(pretMemberAuth);

        return retVo;
    }

    public String getRoleName(Integer type) {
        if (type == ConstantEnum.EUserType.理货员.getLabel()) {
            return ConstantEnum.EUserType.理货员.name();
        } else if (type == ConstantEnum.EUserType.客户.getLabel()) {
            return ConstantEnum.EUserType.客户.name();
        } else if (type == ConstantEnum.EUserType.业务员.getLabel()) {
            return ConstantEnum.EUserType.业务员.name();
        } else if (type == ConstantEnum.EUserType.门卫.getLabel()) {
            return ConstantEnum.EUserType.门卫.name();
        }

        return StringUtils.EMPTY;
    }
}
