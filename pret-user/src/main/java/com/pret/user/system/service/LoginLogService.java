package com.pret.user.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pret.user.system.domain.LoginLog;

public interface LoginLogService extends IService<LoginLog> {

    void saveLoginLog(LoginLog loginLog);
}
