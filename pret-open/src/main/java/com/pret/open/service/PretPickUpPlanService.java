package com.pret.open.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import com.pret.common.exception.FebsException;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.common.util.NoUtil;
import com.pret.common.util.StringUtil;
import com.pret.common.util.UUIDUtils;
import com.pret.open.entity.PretDriver;
import com.pret.open.entity.PretPickUpPlan;
import com.pret.open.entity.PretTransOrder;
import com.pret.open.entity.PretVender;
import com.pret.open.entity.bo.PretPickUpPlanBo;
import com.pret.open.entity.bo.PretPickUpPlanModifyDriverBo;
import com.pret.open.entity.bo.PretTransPlanBo;
import com.pret.open.entity.user.Role;
import com.pret.open.entity.user.User;
import com.pret.open.entity.user.UserRole;
import com.pret.open.entity.vo.PretPickUpPlanVo;
import com.pret.open.repository.PretDriverRepository;
import com.pret.open.repository.PretTransOrderRepository;
import com.pret.open.repository.PretVenderRepository;
import com.pret.open.repository.user.RoleRepository;
import com.pret.open.repository.user.UserRepository;
import com.pret.open.repository.user.UserRoleRepository;
import com.pret.open.vo.req.*;
import com.pret.open.repository.PretPickUpPlanRepository;
import com.pret.api.service.impl.BaseServiceImpl;
import com.pret.open.vo.res.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.swing.filechooser.FileSystemView;
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
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PretVenderRepository pretVenderRepository;
    @Autowired
    private PretDriverRepository pretDriverRepository;
    @Autowired
    private PretTransOrderRepository pretTransOrderRepository;

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
                    String str = StringUtil.disposeFrontZero(firstOrder.getNo().substring(12));
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
    public void genPickUpPlan(PretPickUpPlanBo bo) throws FebsException {
        PretDriver pretDriver = driverRepository.findByCarNumberAndPhoneAndS(bo.getCarNumber(), bo.getPhone(), ConstantEnum.S.N.getLabel());
        if (pretDriver == null) {
            pretDriver = new PretDriver();
            BeanUtilsExtended.copyProperties(pretDriver, bo);
            driverRepository.save(pretDriver);
        }


        String[] idArr = bo.getIds().split(",");
        PretPickUpPlan pretPickUpPlan = this.genDefaultPretPickUpPlan(null, null);
        BeanUtilsExtended.copyProperties(pretPickUpPlan, bo);
        pretPickUpPlan.setDriverId(pretDriver.getId());
        this.repository.save(pretPickUpPlan);
        String venderId = StringUtils.EMPTY;
        String serviceRouteOriginId = StringUtils.EMPTY;
        for (String id : idArr) {
            PretTransOrder pretTransOrder = transOrderRepository.findById(id).get();
            pretTransOrder.setPickUpPlanId(pretPickUpPlan.getId());
            pretTransOrder.setStatus(ConstantEnum.ETransOrderStatus.计划提货.getLabel());
            transOrderRepository.save(pretTransOrder);
            if (StringUtils.isEmpty(venderId)) {
                venderId = pretTransOrder.getVenderId();
            }
            if (StringUtils.isEmpty(serviceRouteOriginId)) {
                serviceRouteOriginId = pretTransOrder.getServiceRouteOriginId();
            }
        }

        pretPickUpPlan.setVenderId(venderId);
        pretPickUpPlan.setServiceRouteOriginId(serviceRouteOriginId);

//        Role role = roleRepository.findByCode(ConstantEnum.ERoleCode.Tallylerk.name());
//        List<UserRole> userRoleList = userRoleRepository.findByRoleIdAndS(role.getId(), ConstantEnum.S.N.getLabel());
//        if (userRoleList != null && userRoleList.size() > 0) {
//
//        }

        List<User> userList = userRepository.findByUserTypeAndS(ConstantEnum.EUserType.理货员.getLabel(), ConstantEnum.S.N.getLabel());
        if (userList != null && userList.size() > 0) {
            pretPickUpPlan.setTallyClerkId(userList.get(0).getId());
        }

        // 生成二维码
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            String uuid = UUID.randomUUID().toString().replace("-", "");
            String qrcode = ConstantEnum.NoTypeEnum.QR.name() + uuid;
            String p = Constants.dfyyyyMMdd.format(new Date()) + "\\" + ConstantEnum.NoTypeEnum.QR.name() + uuid + ".png";
            String urlP = Constants.dfyyyyMMdd.format(new Date()) + "/" + ConstantEnum.NoTypeEnum.QR.name() + uuid + ".png";
            try {
                BitMatrix bitMatrix = qrCodeWriter.encode(qrcode, BarcodeFormat.QR_CODE, Constants.QR_WIDTH, Constants.QR_HEIGHT);
                String fullPath = Constants.QR_ROOT_PATH + p;
                MatrixToImageWriter.writeToPath(bitMatrix, "PNG", Paths.get(fullPath));
            } catch (Exception e) {
                throw new FebsException(e.getMessage());
            }
            pretPickUpPlan.setQrcode(qrcode);
            pretPickUpPlan.setQrcodePath(p);
            pretPickUpPlan.setQrcodeUrl(Constants.QR_ROOT_URL + urlP);
        } catch (Exception e) {
        }

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

        PretDriver pretDriver = driverRepository.findByOpenidAndS(res.getUserInfo().getOpenid(), ConstantEnum.S.N.getLabel());
        PretPickUpPlanVo vo = new PretPickUpPlanVo();
        vo.setEq$status(res.getStatus());
        vo.setEq$stockUpStatus(res.getStockUpStatus());
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

        PretPickUpPlan pretPickUpPlanList = this.repository.findById(res.getId()).get();
        Date date = new Date();
        pretPickUpPlanList.setStartTime(date);
        this.repository.save(pretPickUpPlanList);

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

        PretPickUpPlan pretPickUpPlan = this.repository.findById(res.getId()).get();
        Date date = new Date();
        pretPickUpPlan.setEndTime(date);
        pretPickUpPlan.setInOutStatus(ConstantEnum.EInOutStatus.已进厂.getLabel());
        this.repository.save(pretPickUpPlan);

        List<PretTransOrder> pretTransOrderList = transOrderRepository.findByTransPlanIdAndS(pretPickUpPlan.getId(), ConstantEnum.S.N.getLabel());
        for (PretTransOrder pretTransOrder : pretTransOrderList) {
            pretTransOrder.setStatus(ConstantEnum.ETransOrderStatus.完成提货.getLabel());
            transOrderRepository.save(pretTransOrder);
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

    /* *
     * 功能描述: 修改提货计划
     * 〈〉
     * @Param: [bo]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/11/22  7:06 上午
     */
    public void pretModifyDriver(PretPickUpPlanModifyDriverBo bo) {
        PretDriver pretDriver = driverRepository.findByCarNumberAndPhoneAndS(bo.getCarNumber(), bo.getPhone(), ConstantEnum.S.N.getLabel());
        if (pretDriver == null) {
            pretDriver = new PretDriver();
            BeanUtilsExtended.copyProperties(pretDriver, bo);
            driverRepository.save(pretDriver);
        }

        PretPickUpPlan pretPickUpPlan = this.repository.findById(bo.getId()).get();
        pretPickUpPlan.setDriverId(pretDriver.getId());
        BeanUtilsExtended.copyProperties(pretPickUpPlan, bo);

        this.repository.save(pretPickUpPlan);
    }

    /* *
     * 功能描述: 获取理货员备货列表
     * 〈〉
     * @Param: [res]
     * @Return: com.pret.api.vo.ResBody
     * @Author: wujingsong
     * @Date: 2019/12/1  11:17 下午
     */
    public ResBody getPickupPlanListByTallyClerk(P8000006Vo res) {
        PR8000006Vo retVo = new PR8000006Vo();
        User user = userRepository.findByOpenidAndUserTypeAndS(res.getUserInfo().getOpenid(), ConstantEnum.EUserType.理货员.getLabel(), ConstantEnum.S.N.getLabel());
        PretPickUpPlanVo vo = new PretPickUpPlanVo();
        vo.setEq$status(res.getStatus());
        vo.setEq$tallyClerkId(user.getId());
        vo.setEq$stockUpStatus(res.getStockUpStatus());
        List<PretPickUpPlan> list = this.page(vo).getContent();
        for (PretPickUpPlan pretPickUpPlan : list) {
            if (!StringUtils.isEmpty(pretPickUpPlan.getVenderId())) {
                PretVender pretVender = pretVenderRepository.findById(pretPickUpPlan.getVenderId()).get();
                pretPickUpPlan.setPretVender(pretVender);
            }
        }
        retVo.setData(list);

        return retVo;
    }

    /* *
     * 功能描述: 获取理货员待备货详情
     * 〈〉
     * @Param: [res]
     * @Return: com.pret.api.vo.ResBody
     * @Author: wujingsong
     * @Date: 2019/10/18  10:06 下午
     */
    public ResBody getPickupPlanDetailByTallyClerk(P8000007Vo res) {
        PR8000007Vo retVo = new PR8000007Vo();

        PretPickUpPlan pretPickUpPlan = this.repository.findById(res.getId()).get();
        retVo.setData(pretPickUpPlan);
        if (!StringUtils.isEmpty(pretPickUpPlan.getVenderId())) {
            PretVender pretVender = pretVenderRepository.findById(pretPickUpPlan.getVenderId()).get();
            pretPickUpPlan.setPretVender(pretVender);
        }
        if (!StringUtils.isEmpty(pretPickUpPlan.getDriverId())) {
            PretDriver pretDriver = pretDriverRepository.findById(pretPickUpPlan.getDriverId()).get();
            pretPickUpPlan.setPretDriver(pretDriver);
        }
        List<PretTransOrder> pretTransOrderList = pretTransOrderRepository.findByPickUpPlanIdAndS(res.getId(), ConstantEnum.S.N.getLabel());
        pretPickUpPlan.setTransOrderList(pretTransOrderList);


        return retVo;
    }
}
