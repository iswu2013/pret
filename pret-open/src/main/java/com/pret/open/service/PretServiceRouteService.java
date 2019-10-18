package com.pret.open.service;

import java.util.List;

import com.google.common.reflect.TypeToken;
import com.pret.api.vo.ResBody;
import com.pret.common.constant.CommonConstants;
import com.pret.common.constant.Constants;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.entity.PretAddress;
import com.pret.open.entity.PretServiceRoute;
import com.pret.open.entity.PretServiceRouteItem;
import com.pret.open.entity.bo.PretServiceRouteBo;
import com.pret.open.entity.bo.PretServiceRouteItemBo;
import com.pret.open.entity.vo.PretServiceRouteVo;
import com.pret.open.repository.PretAddressRepository;
import com.pret.open.repository.PretServiceRouteItemRepository;
import com.pret.open.vo.req.*;
import com.pret.open.repository.PretServiceRouteRepository;
import com.pret.api.service.impl.BaseServiceImpl;
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
public class PretServiceRouteService extends BaseServiceImpl<PretServiceRouteRepository, PretServiceRoute, PretServiceRouteVo> {
    @Autowired
    private PretAddressRepository pretAddressRepository;
    @Autowired
    private PretServiceRouteItemRepository pretServiceRouteItemRepository;

    public void pretServiceRouteAdd(PretServiceRouteBo bo) {
        PretServiceRoute pretServiceRoute = new PretServiceRoute();
        BeanUtilsExtended.copyProperties(pretServiceRoute, bo);
        this.repository.save(pretServiceRoute);

        List<PretServiceRouteItemBo> list = CommonConstants.GSON.fromJson(bo.getServiceRouteItemStr(),
                new TypeToken<List<PretServiceRouteItemBo>>() {
                }.getType());
        for (PretServiceRouteItemBo itemBo : list) {
            // 线路明细
            PretServiceRouteItem item = new PretServiceRouteItem();
            item.setAddressId(itemBo.getAddressId());
            item.setPrescription(itemBo.getPrescription());
            item.setServiceLineId(pretServiceRoute.getId());
            pretServiceRouteItemRepository.save(item);
        }
    }
}
