package com.pret.open.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.google.common.reflect.TypeToken;
import com.pret.common.constant.CommonConstants;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.constant.Constants;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.common.util.NoUtil;
import com.pret.common.util.StringUtil;
import com.pret.open.entity.*;
import com.pret.open.entity.bo.PretTransExceptionBo;
import com.pret.open.entity.bo.PretTransExceptionItemBo;
import com.pret.open.entity.vo.PretTransExceptionVo;
import com.pret.open.repository.*;
import com.pret.api.service.impl.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
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
public class PretTransExceptionService extends BaseServiceImpl<PretTransExceptionRepository, PretTransException, PretTransExceptionVo> {
    @Autowired
    private PretTransPlanRepository transPlanRepository;
    @Autowired
    private PretTransExceptionItemRepository pretTransExceptionItemRepository;
    @Autowired
    private PretTransExceptionHandleRecordRepository pretTransExceptionHandleRecordRepository;
    @Autowired
    private PretTransOrderRepository pretTransOrderRepository;
    @Autowired
    private PretAddressService pretAddressService;

    /* *
     * 功能描述: 生成默认异常单
     * 〈〉
     * @Param: [no, tail]
     * @Return: com.pret.open.entity.PretTransException
     * @Author: wujingsong
     * @Date: 2019/10/4  10:34 下午
     */
    public PretTransException genDefaultPretTransException(String no, String tail) {
        Date date = DateUtils.truncate(new Date(), Calendar.DATE);
        Date endDate = DateUtils.addDays(date, 1);
        PretTransException transException = new PretTransException();

        if (!StringUtils.isEmpty(no)) {
            transException.setNo(no);
        } else {
            if (StringUtils.isEmpty(tail)) {
                PretTransException firstOrder = this.repository.findTop1ByCreateTimeLongBetweenOrderByCreateTimeLongDesc(date.getTime(), endDate.getTime());
                if (firstOrder != null) {
                    String str = StringUtil.disposeFrontZero(firstOrder.getNo().substring(6));
                    int intStr = Integer.parseInt(str) + 1;
                    tail = StringUtil.addFrontZero(String.valueOf(intStr), 4);
                } else {
                    tail = Constants.TAIL;
                }
                transException.setNo(NoUtil.genNo(ConstantEnum.NoTypeEnum.EX.name()) + tail);
            }
        }

        return transException;
    }

    /* *
     * 功能描述: 结案
     * 〈〉
     * @Param: [id]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/11/24  5:56 下午
     */
    public void closeCase(String id) {
        PretTransException exception = this.repository.findById(id).get();
        exception.setStatus(ConstantEnum.EHandleStatus.已结案.getLabel());
        this.repository.save(exception);
    }

    /* *
     * 功能描述: 赔款到账
     * 〈〉
     * @Param: [id]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/11/25  3:59 上午
     */
    public void indemnityAccount(String id, String images, String handleUserId, String handleUserName) {
        PretTransExceptionHandleRecord record = new PretTransExceptionHandleRecord();
        record.setDescription(ConstantEnum.EHandleDescription.赔款到账.name());
        record.setExceptionId(id);
        record.setImages(images);
        record.setHandleUserId(handleUserId);
        record.setHandleUserName(handleUserName);
        record.setType(ConstantEnum.EHandleType.货主.getLabel());


        pretTransExceptionHandleRecordRepository.save(record);
    }

    /* *
     * 功能描述: 创建返程运输单
     * 〈〉
     * @Param: [pretTransException]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/11/25  5:10 上午
     */
    public void genRTransPlan(PretTransException pretTransException) {
        List<PretTransExceptionItem> pretTransExceptionItemList = pretTransExceptionItemRepository.findByTransExceptionId(pretTransException.getId());
        for (PretTransExceptionItem pretTransExceptionItem : pretTransExceptionItemList) {
            PretTransOrder pretTransOrder = new PretTransOrder();
            PretTransOrder old = pretTransOrderRepository.findById(pretTransExceptionItem.getTransOrderId()).get();
            BeanUtilsExtended.copyProperties(pretTransOrder, old);
            pretTransOrder.setCustomerDetailAddress(old.getServiceRouteOriginAddress());
            pretTransOrder.setServiceRouteOriginAddress(old.getCustomerDetailAddress());

        }
    }

    /* *
     * 功能描述: 处理
     * 〈〉
     * @Param: [bo]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/11/25  7:40 上午
     */
    public void handle(PretTransExceptionBo bo) {
        PretTransException exception = this.repository.findById(bo.getId()).get();
        BeanUtilsExtended.copyProperties(exception, bo);
        if (!StringUtils.isEmpty(bo.getAddressId())) {
            String address = pretAddressService.getDetailByAddressId(bo.getAddressId());
            exception.setReturnAddress(address + bo.getAddressDetail());
        }
        exception.setStatus(ConstantEnum.ETransExceptionStatus.已认定.getLabel());
        this.repository.save(exception);
    }
}
