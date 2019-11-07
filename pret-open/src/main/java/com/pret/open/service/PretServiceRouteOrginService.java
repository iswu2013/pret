package com.pret.open.service;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Joiner;
import com.google.common.reflect.TypeToken;
import com.pret.api.vo.ResBody;
import com.pret.common.constant.CommonConstants;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.entity.PretPickUpAddress;
import com.pret.open.entity.PretServiceRouteOrgin;
import com.pret.open.entity.bo.AddressBo;
import com.pret.open.entity.bo.PretQuotationItemBo;
import com.pret.open.entity.bo.PretServiceRouteItemBo;
import com.pret.open.entity.bo.PretServiceRouteOrginBo;
import com.pret.open.entity.vo.PretServiceRouteOrginVo;
import com.pret.open.repository.PretPickUpAddressRepository;
import com.pret.open.vo.req.*;
import com.pret.open.repository.PretServiceRouteOrginRepository;
import com.pret.api.service.impl.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
public class PretServiceRouteOrginService extends BaseServiceImpl<PretServiceRouteOrginRepository, PretServiceRouteOrgin, PretServiceRouteOrginVo> {
    /* *
     * 功能描述: 新增起运地
     * 〈〉
     * @Param: [bo]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/10/26  10:30 下午
     */
    public void serviceRouteOrginAdd(PretServiceRouteOrginBo bo) {
        PretServiceRouteOrgin item = new PretServiceRouteOrgin();
        BeanUtilsExtended.copyProperties(item, bo);
        this.repository.save(item);
    }
}
