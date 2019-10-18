package com.pret.open.service;

import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.entity.PretDriver;
import com.pret.open.entity.vo.PretDriverVo;
import com.pret.open.vo.req.*;
import com.pret.open.repository.PretDriverRepository;
import com.pret.api.service.impl.BaseServiceImpl;
import com.pret.open.vo.res.PR8000004Vo;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Description: [pret服务]
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class PretDriverService extends BaseServiceImpl<PretDriverRepository, PretDriver, PretDriverVo> {
    /* *
     * 功能描述: 获取司机详情
     * 〈〉
     * @Param: [res]
     * @Return: com.pret.api.vo.ResBody
     * @Author: wujingsong
     * @Date: 2019/10/18  11:01 下午
     */
    public ResBody getDriverDetail(P8000004Vo res) {
        PR8000004Vo retVo = new PR8000004Vo();
        PretDriver pretDriver = this.repository.findByOpenid(res.getOpenid());
        retVo.setData(pretDriver);

        return retVo;
    }
}
