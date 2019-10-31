package com.pret.open.service;

import com.pret.api.service.impl.BaseServiceImpl;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.entity.PretUserTableConfig;
import com.pret.open.entity.bo.PretUserTableConfigBo;
import com.pret.open.entity.vo.PretUserTableConfigVo;
import com.pret.open.repository.PretUserTableConfigRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Description: [pluto服务]
 * Created on 2019年10月03日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class PretUserTableConfigService extends BaseServiceImpl<PretUserTableConfigRepository, PretUserTableConfig, PretUserTableConfigVo> {
    /* *
     * 功能描述: 设置用户表格配置
     * 〈〉
     * @Param: [bo]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/10/30  6:54 下午
     */
    public void userTableConfigAdd(PretUserTableConfigBo bo) {
        PretUserTableConfig old = this.repository.findByUserIdAndModule(bo.getUserId(), bo.getModule());
        if (old != null) {
            this.repository.delete(old);
        }
        PretUserTableConfig userTableConfig = new PretUserTableConfig();
        BeanUtilsExtended.copyProperties(userTableConfig, bo);
        this.repository.save(userTableConfig);
    }
}
