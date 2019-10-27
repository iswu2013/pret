package com.pret.open.service;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.pret.api.vo.ResBody;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.constant.Constants;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.common.util.NoUtil;
import com.pret.common.util.StringUtil;
import com.pret.common.util.UUIDUtils;
import com.pret.open.entity.PretDriver;
import com.pret.open.entity.PretPickUpPlan;
import com.pret.open.entity.PretTransOrder;
import com.pret.open.entity.bo.PretPickUpPlanBo;
import com.pret.open.entity.bo.PretTransPlanBo;
import com.pret.open.entity.vo.PretPickUpPlanVo;
import com.pret.open.repository.PretDriverRepository;
import com.pret.open.repository.PretTransOrderRepository;
import com.pret.open.vo.req.*;
import com.pret.open.repository.PretPickUpPlanRepository;
import com.pret.api.service.impl.BaseServiceImpl;
import com.pret.open.vo.res.*;
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
public class PretPickUpPlanService extends BaseServiceImpl<PretPickUpPlanRepository, PretPickUpPlan, PretPickUpPlanVo> {
    @Autowired
    private PretTransOrderRepository transOrderRepository;
    @Autowired
    private PretDriverRepository driverRepository;

    public PretPickUpPlan genDefaultPretPickUpPlan(String no, String tail) {
        Date date = DateUtils.truncate(new Date(), Calendar.DATE);
        Date endDate = DateUtils.addDays(date, 1);
        PretPickUpPlan pretPickUpPlan = new PretPickUpPlan();

        if (!StringUtils.isEmpty(no)) {
            pretPickUpPlan.setNo(no);
        } else {
            if (StringUtils.isEmpty(tail)) {
                PretPickUpPlan firstOrder = this.repository.findTop1ByCreateTimeLongBetweenOrderByCreateTimeLongDesc(date.getTime(), endDate.getTime());
                if (firstOrder != null) {
                    String str = StringUtil.disposeFrontZero(firstOrder.getNo().substring(19));
                    int intStr = Integer.parseInt(str) + 1;
                    tail = StringUtil.addFrontZero(String.valueOf(intStr), 6);
                } else {
                    tail = Constants.TAIL;
                }
                pretPickUpPlan.setNo(NoUtil.genNo(ConstantEnum.NoTypeEnum.TH.name()) + tail);
            }
        }

        return pretPickUpPlan;
    }

    /* *
     * 功能描述: 生成提货计划
     * 〈〉
     * @Param: [bo]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/10/4  2:03 下午
     */
    public void genPickUpPlan(PretPickUpPlanBo bo) {
        PretDriver pretDriver = new PretDriver();
        BeanUtilsExtended.copyProperties(pretDriver, bo);
        driverRepository.save(pretDriver);

        String[] idArr = bo.getIds().split(",");
        PretPickUpPlan pretPickUpPlan = this.genDefaultPretPickUpPlan(null, null);
        BeanUtilsExtended.copyProperties(pretPickUpPlan, bo);
        pretPickUpPlan.setDriverId(pretDriver.getId());
        this.repository.save(pretPickUpPlan);
        String venderId = StringUtils.EMPTY;
        for (String id : idArr) {
            PretTransOrder pretTransOrder = transOrderRepository.findById(id).get();
            pretTransOrder.setPickUpPlanId(pretPickUpPlan.getId());
            pretTransOrder.setStatus(ConstantEnum.ETransOrderStatus.待提货.getLabel());
            transOrderRepository.save(pretTransOrder);
            if (StringUtils.isEmpty(venderId)) {
                venderId = pretTransOrder.getVenderId();
            }
        }

        pretPickUpPlan.setVenderId(venderId);

        // 生成二维码
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String qrcode = ConstantEnum.NoTypeEnum.QR.name() + uuid;
        String p = Constants.dfyyyyMMdd.format(new Date()) + "/" + ConstantEnum.NoTypeEnum.QR.name() + uuid + ".png";
        try {
            BitMatrix bitMatrix = qrCodeWriter.encode(qrcode, BarcodeFormat.QR_CODE, Constants.QR_WIDTH, Constants.QR_HEIGHT);
            String fullPath = Constants.QR_ROOT_PATH + p;
            Path path = FileSystems.getDefault().getPath(fullPath);
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        pretPickUpPlan.setQrcode(qrcode);
        pretPickUpPlan.setQrcodePath(p);
        this.repository.save(pretPickUpPlan);
    }

    /* *
     * 功能描述: 获取司机备货列表
     * 〈〉
     * @Param: [res]
     * @Return: com.pret.api.vo.ResBody
     * @Author: wujingsong
     * @Date: 2019/10/18  9:55 下午
     */
    public ResBody getPickupPlanList(P8000000Vo res) {
        PR8000000Vo retVo = new PR8000000Vo();

        PretDriver pretDriver = driverRepository.findByOpenid(res.getUserInfo().getOpenid());
        PretPickUpPlanVo vo = new PretPickUpPlanVo();
        vo.setEq$status(res.getStatus());
        vo.setEq$driverId(pretDriver.getId());
        List<PretPickUpPlan> list = this.page(vo).getContent();
        retVo.setData(list);

        return retVo;
    }

    /* *
     * 功能描述: 获取待备货详情
     * 〈〉
     * @Param: [res]
     * @Return: com.pret.api.vo.ResBody
     * @Author: wujingsong
     * @Date: 2019/10/18  10:06 下午
     */
    public ResBody getPickupPlanDetail(P8000001Vo res) {
        PR8000001Vo retVo = new PR8000001Vo();

        PretPickUpPlan pretPickUpPlan = this.repository.findById(res.getId()).get();
        retVo.setData(pretPickUpPlan);

        return retVo;
    }

    /* *
     * 功能描述: 完成备货
     * 〈〉
     * @Param: [res]
     * @Return: com.pret.api.vo.ResBody
     * @Author: wujingsong
     * @Date: 2019/10/18  10:14 下午
     */
    public ResBody finishPickupPlan(P1000001Vo res) {
        PR1000001Vo retVo = new PR1000001Vo();

        List<String> idList = StringUtil.idsStr2ListString(res.getIds());
        for (String id : idList) {
            PretPickUpPlan pickUpPlan = this.repository.findById(id).get();
            pickUpPlan.setStatus(ConstantEnum.EPretPickUpPlanStatus.已完成.getLabel());
            this.repository.save(pickUpPlan);
        }

        return retVo;
    }

    /* *
     * 功能描述: 进厂确认
     * 〈〉
     * @Param: [res]
     * @Return: com.pret.api.vo.ResBody
     * @Author: wujingsong
     * @Date: 2019/10/18  11:06 下午
     */
    public ResBody inFactory(P1000002Vo res) {
        PR1000002Vo retVo = new PR1000002Vo();

        PretDriver driver = driverRepository.findByOpenid(res.getOpenid());

        List<PretPickUpPlan> pretPickUpPlanList = this.repository.findByDriverIdAndStartTimeIsNull(driver.getId());
        Date date = new Date();
        for (PretPickUpPlan pretPickUpPlan : pretPickUpPlanList) {
            pretPickUpPlan.setStartTime(date);
            this.repository.save(pretPickUpPlan);
        }

        return retVo;
    }

    /* *
     * 功能描述: 出厂确认
     * 〈〉
     * @Param: [res]
     * @Return: com.pret.api.vo.ResBody
     * @Author: wujingsong
     * @Date: 2019/10/18  11:06 下午
     */
    public ResBody outFactory(P1000003Vo res) {
        PR1000003Vo retVo = new PR1000003Vo();

        PretDriver driver = driverRepository.findByOpenid(res.getOpenid());

        List<PretPickUpPlan> pretPickUpPlanList = this.repository.findByDriverIdAndStartTimeIsNotNullAndEndTimeIsNull(driver.getId());
        Date date = new Date();
        for (PretPickUpPlan pretPickUpPlan : pretPickUpPlanList) {
            pretPickUpPlan.setEndTime(date);
            this.repository.save(pretPickUpPlan);

            List<PretTransOrder> pretTransOrderList = transOrderRepository.findByTransPlanId(pretPickUpPlan.getId());
            if (pretPickUpPlanList != null && pretPickUpPlanList.size() > 0) {
                for (PretTransOrder pretTransOrder : pretTransOrderList) {
                    pretTransOrder.setStatus(ConstantEnum.ETransOrderStatus.已提货.getLabel());
                    transOrderRepository.save(pretTransOrder);
                }
            }
        }

        return retVo;
    }

    /* *
     * 功能描述: 取消提货计划
     * 〈〉
     * @Param: [ids]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/10/24  1:36 下午
     */
    public void pretPickUpPlanCancel(String ids) {
        List<String> idList = StringUtil.idsStr2ListString(ids);
        for (String id : idList) {
            PretPickUpPlan pickUpPlan = this.repository.findById(id).get();
            pickUpPlan.setStatus(ConstantEnum.EPretPickUpPlanStatus.已取消.getLabel());
            this.repository.save(pickUpPlan);
        }
    }
}
