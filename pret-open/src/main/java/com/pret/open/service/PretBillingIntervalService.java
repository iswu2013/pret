package com.pret.open.service;

import com.google.common.reflect.TypeToken;
import com.pret.api.service.impl.BaseServiceImpl;
import com.pret.common.constant.CommonConstants;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.entity.PretBillingInterval;
import com.pret.open.entity.PretBillingIntervalItem;
import com.pret.open.entity.PretServiceRoute;
import com.pret.open.entity.bo.PretBillingIntervalBo;
import com.pret.open.entity.bo.PretBillingIntervalItemBo;
import com.pret.open.entity.vo.PretBillingIntervalVo;
import com.pret.open.repository.PretBillingIntervalItemRepository;
import com.pret.open.repository.PretBillingIntervalRepository;
import com.pret.open.repository.PretServiceRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
public class PretBillingIntervalService extends BaseServiceImpl<PretBillingIntervalRepository, PretBillingInterval, PretBillingIntervalVo> {
    @Autowired
    private PretBillingIntervalItemRepository pretBillingIntervalItemRepository;
    @Autowired
    private PretServiceRouteRepository pretServiceRouteRepository;


    /* *
     * 功能描述: 生成计费区间
     * 〈〉
     * @Param: [bo]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/10/27  10:27 下午
     */
    public void pretBillingIntervalAdd(PretBillingIntervalBo bo) {
        PretBillingInterval pretBillingInterval = new PretBillingInterval();
        BeanUtilsExtended.copyProperties(pretBillingInterval, bo);
        this.repository.save(pretBillingInterval);

        PretServiceRoute pretServiceRoute = this.pretServiceRouteRepository.findById(bo.getServiceRouteId()).get();
        pretServiceRoute.setBillingIntervalId(pretBillingInterval.getId());
        this.pretServiceRouteRepository.save(pretServiceRoute);

        List<PretBillingIntervalItemBo> list = CommonConstants.GSON.fromJson(bo.getBillingIntervalItemStr(),
                new TypeToken<List<PretBillingIntervalItemBo>>() {
                }.getType());
        for (PretBillingIntervalItemBo itemBo : list) {
            // 线路明细
            PretBillingIntervalItem item = new PretBillingIntervalItem();
            BeanUtilsExtended.copyProperties(item, itemBo);
            item.setBillingIntervalId(pretBillingInterval.getId());
            item.setVenderId(bo.getVenderId());
            pretBillingIntervalItemRepository.save(item);
        }
    }

    /* *
     * 功能描述: 编辑计费区间
     * 〈〉
     * @Param: [bo]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/10/29  12:04 上午
     */
    public void pretBillingIntervalEdit(PretBillingIntervalBo bo) {
        PretBillingInterval pretBillingInterval = this.repository.findById(bo.getId()).get();
        BeanUtilsExtended.copyProperties(pretBillingInterval, bo);
        this.repository.save(pretBillingInterval);

        List<PretBillingIntervalItem> pretBillingIntervalItemList = pretBillingIntervalItemRepository.findByBillingIntervalIdAndS(bo.getId(), ConstantEnum.S.N.getLabel());
        if (pretBillingIntervalItemList != null && pretBillingIntervalItemList.size() > 0) {
            for (PretBillingIntervalItem item : pretBillingIntervalItemList) {
                item.setS(ConstantEnum.S.D.getLabel());
                this.pretBillingIntervalItemRepository.save(item);
            }
        }

        List<PretBillingIntervalItemBo> list = CommonConstants.GSON.fromJson(bo.getBillingIntervalItemStr(),
                new TypeToken<List<PretBillingIntervalItemBo>>() {
                }.getType());
        for (PretBillingIntervalItemBo itemBo : list) {
            // 线路明细
            PretBillingIntervalItem item = new PretBillingIntervalItem();
            BeanUtilsExtended.copyProperties(item, itemBo);
            item.setBillingIntervalId(pretBillingInterval.getId());
            item.setVenderId(bo.getVenderId());
            pretBillingIntervalItemRepository.save(item);
        }
    }
}
