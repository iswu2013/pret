package com.pret.open.service;

import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.entity.PretServiceRouteOrigin;
import com.pret.open.entity.bo.PretServiceRouteOrginBo;
import com.pret.open.entity.vo.PretServiceRouteOrginVo;
import com.pret.open.repository.PretServiceRouteOriginRepository;
import com.pret.api.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class PretServiceRouteOriginService extends BaseServiceImpl<PretServiceRouteOriginRepository, PretServiceRouteOrigin, PretServiceRouteOrginVo> {
    @Autowired
    private PretAddressService pretAddressService;

    /* *
     * 功能描述: 新增起运地
     * 〈〉
     * @Param: [bo]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/10/26  10:30 下午
     */
    public void serviceRouteOrginAdd(PretServiceRouteOrginBo bo) {
        PretServiceRouteOrigin item = new PretServiceRouteOrigin();
        BeanUtilsExtended.copyProperties(item, bo);
        item.setFullAddress(pretAddressService.getDetailByAddressId(item.getAddressId()) + item.getDetail());
        this.repository.save(item);
    }
}
