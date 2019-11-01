package com.pret.open.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Joiner;
import com.google.common.reflect.TypeToken;
import com.pret.api.vo.ResBody;
import com.pret.common.constant.CommonConstants;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.entity.PretQuotation;
import com.pret.open.entity.PretQuotationItem;
import com.pret.open.entity.PretServiceRoute;
import com.pret.open.entity.PretServiceRouteItem;
import com.pret.open.entity.bo.PretQuotationBo;
import com.pret.open.entity.bo.PretQuotationItemBo;
import com.pret.open.entity.bo.PretServiceRouteBo;
import com.pret.open.entity.bo.PretServiceRouteItemBo;
import com.pret.open.entity.vo.PretQuotationVo;
import com.pret.open.repository.PretBillingIntervalItemRepository;
import com.pret.open.repository.PretQuotationItemRepository;
import com.pret.open.vo.req.*;
import com.pret.open.repository.PretQuotationRepository;
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
public class PretQuotationService extends BaseServiceImpl<PretQuotationRepository, PretQuotation, PretQuotationVo> {
    @Autowired
    private PretQuotationItemRepository pretQuotationItemRepository;
    @Autowired
    private PretBillingIntervalItemRepository pretBillingIntervalItemRepository;

    /* *
     * 功能描述: 新增报价
     * 〈〉
     * @Param: [bo]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/10/24  10:20 上午
     */
    public void pretQuotationAdd(PretQuotationBo bo) {
        PretQuotation pretQuotation = new PretQuotation();
        BeanUtilsExtended.copyProperties(pretQuotation, bo);
        this.repository.save(pretQuotation);

        JSONArray json = JSONArray.parseArray(bo.getPretQuotationItemStr());
        List<String> serviceRouteOrginIdList = new ArrayList<>();
        for (int i = 0; i < json.size(); i++) {
            // 线路明细
            JSONObject jsonObject = json.getJSONObject(i);
            PretQuotationItem item = new PretQuotationItem();
//            item.setBillingIntervalItemId(itemBo.getBillingIntervalItemId());
//            item.setCostType(itemBo.getCostType());
//            item.setQuotationId(pretQuotation.getId());
//            item.setServiceRouteItemId(itemBo.getServiceRouteItemId());
//            item.setServiceRouteOriginId(itemBo.getServiceRouteOriginId());
//            item.setVenderId(bo.getVenderId());
//            pretQuotationItemRepository.save(item);
//            if (!serviceRouteOrginIdList.contains(itemBo.getServiceRouteId())) {
//                serviceRouteOrginIdList.add(itemBo.getServiceRouteId());
//            }
        }
        pretQuotation.setServiceRouteId(Joiner.on(",").join(serviceRouteOrginIdList));
        this.repository.save(pretQuotation);
    }

    /* *
     * 功能描述: 编辑服务报价
     * 〈〉
     * @Param: [bo]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/10/24  9:23 上午
     */
    public void pretQuotationEdit(PretQuotationBo bo) {
        PretQuotation pretQuotation = this.repository.findById(bo.getId()).get();
        BeanUtilsExtended.copyProperties(pretQuotation, bo);
        this.repository.save(pretQuotation);

        // 删除之前的报价明细
        List<PretQuotationItem> pretQuotationItemList = pretQuotationItemRepository.findByQuotationId(bo.getId());
        if (pretQuotationItemList != null && pretQuotationItemList.size() > 0) {
            for (PretQuotationItem item : pretQuotationItemList) {
                item.setS(ConstantEnum.S.D.getLabel());
            }
            this.pretQuotationItemRepository.saveAll(pretQuotationItemList);
        }

        List<PretQuotationItemBo> list = CommonConstants.GSON.fromJson(bo.getPretQuotationItemStr(),
                new TypeToken<List<PretQuotationItemBo>>() {
                }.getType());
        List<String> serviceRouteOrginIdList = new ArrayList<>();
        for (PretQuotationItemBo itemBo : list) {
            // 线路明细
            PretQuotationItem item = new PretQuotationItem();
            item.setBillingIntervalItemId(itemBo.getBillingIntervalItemId());
            item.setCostType(itemBo.getCostType());
            item.setQuotationId(pretQuotation.getId());
            item.setServiceRouteItemId(itemBo.getServiceRouteItemId());
            item.setServiceRouteOriginId(itemBo.getServiceRouteOriginId());
            item.setVenderId(bo.getVenderId());
            pretQuotationItemRepository.save(item);
            if (!serviceRouteOrginIdList.contains(itemBo.getServiceRouteId())) {
                serviceRouteOrginIdList.add(itemBo.getServiceRouteId());
            }
        }
        pretQuotation.setServiceRouteId(Joiner.on(",").join(serviceRouteOrginIdList));
        this.repository.save(pretQuotation);
    }

    /* *
     * 功能描述: 报价审核
     * 〈〉
     * @Param: [id, type]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/10/25  3:20 下午
     */
    public void check(String userId, String id, int status) {
        PretQuotation pretQuotation = this.repository.findById(id).get();
        pretQuotation.setStatus(status);
        pretQuotation.setCheckDate(new Date());
        pretQuotation.setCheckUserId(userId);
        this.repository.save(pretQuotation);

    }
}
