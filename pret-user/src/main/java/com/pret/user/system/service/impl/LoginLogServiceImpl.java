package com.pret.user.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pret.common.utils.HttpContextUtil;
import com.pret.common.utils.IPUtil;
import com.pret.user.common.utils.AddressUtil;
import com.pret.user.system.dao.LoginLogMapper;
import com.pret.user.system.domain.LoginLog;
import com.pret.user.system.service.LoginLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service("loginLogService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements LoginLogService {

    @Override
    @Transactional
    public void saveLoginLog(LoginLog loginLog) {
        loginLog.setLoginTime(new Date());
        HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
        String ip = IPUtil.getIpAddr(request);
        loginLog.setIp(ip);
        loginLog.setLocation(AddressUtil.getCityInfo(ip));
        this.save(loginLog);
    }
}
