package com.pret.open.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Joiner;
import com.google.common.reflect.TypeToken;
import com.pret.api.vo.ResBody;
import com.pret.common.constant.CommonConstants;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.constant.Constants;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.common.utils.DateUtil;
import com.pret.open.entity.*;
import com.pret.open.entity.bo.PretQuotationBo;
import com.pret.open.entity.bo.PretQuotationItemBo;
import com.pret.open.entity.bo.PretServiceRouteBo;
import com.pret.open.entity.bo.PretServiceRouteItemBo;
import com.pret.open.entity.vo.PretQuotationVo;
import com.pret.open.repository.*;
import com.pret.open.vo.req.*;
import com.pret.api.service.impl.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
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
    @Autowired
    private PretFeeTypeRepository pretFeeTypeRepository;
    @Autowired
    private PretServiceRouteItemRepository pretServiceRouteItemRepository;


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
        try {
            pretQuotation.setPeriodFrom(DateUtils.parseDate(bo.getPeriodFromStr(), "yyyy-MM-dd"));
            pretQuotation.setPeriodTo(DateUtils.parseDate(bo.getPeriodToStr(), "yyyy-MM-dd"));
        } catch (ParseException e) {
        }

        this.repository.save(pretQuotation);
        this.editQuotion(bo, pretQuotation);
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
        try {
            pretQuotation.setPeriodFrom(DateUtils.parseDate(bo.getPeriodFromStr(), "yyyy-MM-dd"));
            pretQuotation.setPeriodTo(DateUtils.parseDate(bo.getPeriodToStr(), "yyyy-MM-dd"));
        } catch (ParseException e) {
        }
        this.repository.save(pretQuotation);

        // 删除之前的报价明细
        List<PretQuotationItem> pretQuotationItemList = pretQuotationItemRepository.findByQuotationId(bo.getId());
        if (pretQuotationItemList != null && pretQuotationItemList.size() > 0) {
            for (PretQuotationItem item : pretQuotationItemList) {
                item.setS(ConstantEnum.S.D.getLabel());
            }
            this.pretQuotationItemRepository.saveAll(pretQuotationItemList);
        }
        this.editQuotion(bo, pretQuotation);
    }

    /* *
     * 功能描述: 编辑报价
     * 〈〉
     * @Param: [bo, pretQuotation]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/11/1  4:16 下午
     */
    private void editQuotion(PretQuotationBo bo, PretQuotation pretQuotation) {
        JSONArray json = JSONArray.parseArray(bo.getPretQuotationItemStr());
        List<String> serviceRouteIdList = new ArrayList<>();
        for (int i = 0; i < json.size(); i++) {
            String serviceRouteId = StringUtils.EMPTY;
            // 线路明细
            JSONObject jsonObject = json.getJSONObject(i);
            String id = jsonObject.get("id").toString();
            PretServiceRouteItem pretServiceRouteItem = pretServiceRouteItemRepository.findById(id).get();
            pretServiceRouteItem.setVenderId(bo.getVenderId());
            pretServiceRouteItemRepository.save(pretServiceRouteItem);
            JSONArray pretFeeTypeDataSource0 = JSONArray.parseArray(jsonObject.get("pretFeeTypeDataSource0").toString());
            for (int j = 0; j < pretFeeTypeDataSource0.size(); j++) {
                JSONObject pretFeeTypeJsonObject = pretFeeTypeDataSource0.getJSONObject(j);
                String type = pretFeeTypeJsonObject.get("type").toString();
                Set<Map.Entry<String, Object>> entrySet = pretFeeTypeJsonObject.entrySet();
                for (Map.Entry<String, Object> map : entrySet) {
                    if (!(map.getKey().equals("type") || map.getKey().equals("operation"))) {
                        PretQuotationItem item = new PretQuotationItem();

                        item.setBillingIntervalItemId(map.getKey());
                        item.setFeeTypeId(type);
                        item.setQuotationId(pretQuotation.getId());
                        item.setServiceRouteItemId(id);
                        item.setVenderId(bo.getVenderId());
                        item.setAddressId(pretServiceRouteItem.getAddressId());
                        item.setCode(pretServiceRouteItem.getCode());
                        item.setQuotation(new BigDecimal(map.getValue().toString()));
                        item.setServiceRouteId(pretServiceRouteItem.getServiceRouteId());
                        item.setServiceRouteOriginId(pretServiceRouteItem.getServiceRouteOriginId());
                        pretQuotationItemRepository.save(item);


                        serviceRouteId = pretServiceRouteItem.getServiceRouteId();

                    }
                }
            }
            JSONArray pretFeeTypeDataSource1 = JSONArray.parseArray(jsonObject.get("pretFeeTypeDataSource1").toString());
            for (int j = 0; j < pretFeeTypeDataSource1.size(); j++) {
                JSONObject pretFeeTypeJsonObject = pretFeeTypeDataSource1.getJSONObject(j);
                String type = pretFeeTypeJsonObject.get("type").toString();

                Set<Map.Entry<String, Object>> entrySet = pretFeeTypeJsonObject.entrySet();
                for (Map.Entry<String, Object> map : entrySet) {
                    if (!(map.getKey().equals("type") || map.getKey().equals("operation"))) {
                        PretQuotationItem item = new PretQuotationItem();
                        item.setBillingIntervalItemId(map.getKey());
                        item.setFeeTypeId(type);
                        item.setQuotationId(pretQuotation.getId());
                        item.setServiceRouteItemId(id);
                        item.setVenderId(bo.getVenderId());
                        item.setAddressId(pretServiceRouteItem.getAddressId());
                        item.setCode(pretServiceRouteItem.getCode());
                        item.setQuotation(new BigDecimal(map.getValue().toString()));
                        item.setServiceRouteId(pretServiceRouteItem.getServiceRouteId());
                        item.setServiceRouteOriginId(pretServiceRouteItem.getServiceRouteOriginId());
                        pretQuotationItemRepository.save(item);


                        serviceRouteId = pretServiceRouteItem.getServiceRouteId();
                    }
                }
            }

            if (!serviceRouteIdList.contains(serviceRouteId)) {
                serviceRouteIdList.add(serviceRouteId);
            }
        }
        pretQuotation.setServiceRouteId(Joiner.on(",").join(serviceRouteIdList));
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
