package com.pret.open.service;

import java.nio.file.Paths;
import java.util.*;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.pret.api.vo.ResBody;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.constant.Constants;
import com.pret.common.exception.BusinessException;
import com.pret.common.exception.FebsException;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.common.util.DateUtil;
import com.pret.common.util.NoUtil;
import com.pret.common.util.StringUtil;
import com.pret.open.constant.OpenBEEnum;
import com.pret.open.entity.*;
import com.pret.open.entity.bo.PretPickUpPlanBo;
import com.pret.open.entity.bo.PretPickUpPlanModifyDriverBo;
import com.pret.open.entity.user.Dept;
import com.pret.open.entity.user.User;
import com.pret.open.entity.vo.PretPickUpPlanVo;
import com.pret.open.repository.*;
import com.pret.open.repository.user.DeptRepository;
import com.pret.open.repository.user.RoleRepository;
import com.pret.open.repository.user.UserRepository;
import com.pret.open.repository.user.UserRoleRepository;
import com.pret.open.vo.req.*;
import com.pret.api.service.impl.BaseServiceImpl;
import com.pret.open.vo.res.*;
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
    @Autowired
    private PretTransOrderGroupRepository pretTransOrderGroupRepository;
    @Autowired
    private PretServiceRouteOriginRepository pretServiceRouteOriginRepository;
    @Autowired
    private PretServiceRouteOriginUserRepository pretServiceRouteOriginUserRepository;
    @Autowired
    private PretPickUpPlanRepository pretPickUpPlanRepository;
    @Autowired
    private PretPickUpRecordRepository pretPickUpRecordRepository;
    @Autowired
    private PretMemberAuthRepository pretMemberAuthRepository;
    @Autowired
    private DeptRepository deptRepository;

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
                    String str = StringUtil.disposeFrontZero(firstOrder.getNo().substring(7));
                    int intStr = Integer.parseInt(str) + 1;
                    tail = StringUtil.addFrontZero(String.valueOf(intStr), 4);
                } else {
                    tail = Constants.TAIL;
                }
                pretPickUpPlan.setNo(NoUtil.genNo(ConstantEnum.NoTypeEnum.P.name()) + tail);
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
        String deptId = StringUtils.EMPTY;
        String ownFactoryCd = StringUtils.EMPTY;
        String serviceRouteOriginId = StringUtils.EMPTY;
        for (String id : idArr) {
            List<PretTransOrder> pretTransOrderList = pretTransOrderRepository.findByTransOrderGroupIdAndS(id, ConstantEnum.S.N.getLabel());
            for (PretTransOrder pretTransOrder : pretTransOrderList) {
                pretTransOrder.setPickUpPlanId(pretPickUpPlan.getId());
                pretTransOrder.setStatus(ConstantEnum.ETransOrderStatus.待提货.getLabel());
                transOrderRepository.save(pretTransOrder);
                if (StringUtils.isEmpty(venderId)) {
                    venderId = pretTransOrder.getVenderId();
                }
                if (StringUtils.isEmpty(deptId)) {
                    deptId = pretTransOrder.getDeptId();
                }
                if (StringUtils.isEmpty(ownFactoryCd)) {
                    ownFactoryCd = pretTransOrder.getOwnFactoryCd();
                }
                if (StringUtils.isEmpty(serviceRouteOriginId)) {
                    serviceRouteOriginId = pretTransOrder.getServiceRouteOriginId();
                }
            }
            PretTransOrderGroup pretTransOrderGroup = pretTransOrderGroupRepository.findById(id).get();
            pretTransOrderGroup.setStatus(ConstantEnum.ETransOrderStatus.待提货.getLabel());
            pretTransOrderGroupRepository.save(pretTransOrderGroup);
        }

        pretPickUpPlan.setVenderId(venderId);
        pretPickUpPlan.setDeptId(deptId);
        pretPickUpPlan.setOwnFactoryCd(ownFactoryCd);
        pretPickUpPlan.setServiceRouteOriginId(serviceRouteOriginId);

        // 生成二维码
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            String uuid = UUID.randomUUID().toString().replace("-", "");
            String qrcode = ConstantEnum.NoTypeEnum.QR.name() + uuid;
            String p = "\\images\\" + ConstantEnum.NoTypeEnum.QR.name() + uuid + ".png";
            String urlP = "/" + ConstantEnum.NoTypeEnum.QR.name() + uuid + ".png";
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

        // 添加一条记录
        PretPickUpRecord pretTransRecord = new PretPickUpRecord();

        pretTransRecord.setDescription(ConstantEnum.EPretPickUpRecordDescription.生成提货计划.name());
        pretTransRecord.setPickUpPlanId(pretPickUpPlan.getId());
        pretTransRecord.setType(ConstantEnum.ETransOrderStatisticsUserType.物流供应商.getLabel());
        pretTransRecord.setUsername(bo.getUsername());

        pretPickUpRecordRepository.save(pretTransRecord);
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
        vo.setRows(res.getRows());
        vo.setPage(res.getPage());
        vo.setEq$status(res.getStatus());
        vo.setEq$stockUpStatus(res.getStockUpStatus());
        vo.setEq$driverId(pretDriver.getId());
        List<PretPickUpPlan> list = this.page(vo).getContent();
        retVo.setData(list);

        retVo.setSerialNo(res.getSerialNo());
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

        retVo.setSerialNo(res.getSerialNo());
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

        PretMemberAuth pretMemberAuth = pretMemberAuthRepository.findByOpenidAndS(res.getOpenid(), ConstantEnum.S.N.getLabel());
        PretPickUpPlan pickUpPlan = this.repository.findById(res.getId()).get();
        pickUpPlan.setStockUpStatus(ConstantEnum.EPretPickUpPlantockUpStatus.已备货.getLabel());
        pickUpPlan.setTallyClerkId(pretMemberAuth.getId());
        this.repository.save(pickUpPlan);

        // 添加一条记录
        PretPickUpRecord pretTransRecord = new PretPickUpRecord();

        pretTransRecord.setDescription(ConstantEnum.EPretPickUpRecordDescription.备货完成.name());
        pretTransRecord.setPickUpPlanId(pickUpPlan.getId());
        pretTransRecord.setType(ConstantEnum.ETransOrderStatisticsUserType.物流供应商.getLabel());
        pretTransRecord.setUsername(pretMemberAuth.getName());

        pretPickUpRecordRepository.save(pretTransRecord);

        List<String> idList = StringUtil.idsStr2ListString(res.getIds());
        List<PretTransOrder> PretTransOrder = pretTransOrderRepository.findByIdInAndS(idList, ConstantEnum.S.N.getLabel());
        for (PretTransOrder pretTransOrder : PretTransOrder) {
            pretTransOrder.setPickUpPlanId(null);
            pretTransOrder.setStatus(ConstantEnum.ETransOrderStatus.已分配.getLabel());
            pretTransOrderRepository.save(pretTransOrder);
        }

        retVo.setSerialNo(res.getSerialNo());
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

        PretMemberAuth pretMemberAuth = pretMemberAuthRepository.findByOpenidAndS(res.getOpenid(), ConstantEnum.S.N.getLabel());
        PretPickUpPlan pretPickUpPlan = this.repository.findById(res.getId()).get();
        Date date = new Date();
        pretPickUpPlan.setStartTime(date);
        pretPickUpPlan.setInOutStatus(ConstantEnum.EInOutStatus.已进厂.getLabel());
        pretPickUpPlan.setInGuardId(pretMemberAuth.getId());
        this.repository.save(pretPickUpPlan);

        // 添加一条记录
        PretPickUpRecord pretTransRecord = new PretPickUpRecord();

        pretTransRecord.setDescription(ConstantEnum.EPretPickUpRecordDescription.进厂提货.name());
        pretTransRecord.setPickUpPlanId(pretPickUpPlan.getId());
        pretTransRecord.setType(ConstantEnum.ETransOrderStatisticsUserType.门卫.getLabel());
        pretTransRecord.setUsername(pretMemberAuth.getName());

        pretPickUpRecordRepository.save(pretTransRecord);

        retVo.setSerialNo(res.getSerialNo());
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
        PretMemberAuth pretMemberAuth = pretMemberAuthRepository.findByOpenidAndS(res.getOpenid(), ConstantEnum.S.N.getLabel());

        PretPickUpPlan pretPickUpPlan = this.repository.findById(res.getId()).get();
        Date date = new Date();
        pretPickUpPlan.setEndTime(date);
        pretPickUpPlan.setInOutStatus(ConstantEnum.EInOutStatus.已出厂.getLabel());
        pretPickUpPlan.setOutGuardId(pretMemberAuth.getId());
        this.repository.save(pretPickUpPlan);

        // 添加一条记录
        PretPickUpRecord pretTransRecord = new PretPickUpRecord();

        pretTransRecord.setDescription(ConstantEnum.EPretPickUpRecordDescription.出厂确认.name());
        pretTransRecord.setPickUpPlanId(pretPickUpPlan.getId());
        pretTransRecord.setType(ConstantEnum.ETransOrderStatisticsUserType.门卫.getLabel());
        pretTransRecord.setUsername(pretMemberAuth.getName());

        pretPickUpRecordRepository.save(pretTransRecord);

        retVo.setSerialNo(res.getSerialNo());
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
            this.lDelete(id);

            List<String> groupIdList = new ArrayList<>();

            List<PretTransOrder> pretTransOrderList = pretTransOrderRepository.findByPickUpPlanIdAndS(id, ConstantEnum.S.N.getLabel());
            if (pretTransOrderList != null && pretTransOrderList.size() > 0) {
                for (PretTransOrder pretTransOrder : pretTransOrderList) {
                    pretTransOrder.setPickUpPlanId(null);
                    pretTransOrder.setStatus(ConstantEnum.ETransOrderStatus.已分配.getLabel());
                    pretTransOrderRepository.save(pretTransOrder);
                    if (!groupIdList.contains(pretTransOrder.getTransOrderGroupId())) {
                        PretTransOrderGroup pretTransOrderGroup = pretTransOrderGroupRepository.findById(pretTransOrder.getTransOrderGroupId()).get();
                        pretTransOrderGroup.setStatus(ConstantEnum.ETransOrderStatus.已分配.getLabel());
                        pretTransOrderGroupRepository.save(pretTransOrderGroup);
                        groupIdList.add(pretTransOrder.getTransOrderGroupId());
                    }
                }
            }


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
        PretMemberAuth pretMemberAuth = pretMemberAuthRepository.findByOpenidAndS(res.getOpenid(), ConstantEnum.S.N.getLabel());
        PretPickUpPlanVo vo = new PretPickUpPlanVo();
        if (res.getStockUpStatus() == ConstantEnum.EPretPickUpPlantockUpStatus.待备货.getLabel()) {
            Dept dept = deptRepository.findById(pretMemberAuth.getDeptId()).get();
            if (dept.getU9code().equals(ConstantEnum.EDeptCode.headquarters.getLabel())) {
                List<String> ds = new ArrayList<>();
                List<Dept> deptList = deptRepository.findByS(ConstantEnum.S.N.getLabel());
                for (Dept d : deptList) {
                    ds.add(d.getId());
                }
                vo.setIn$deptId(ds);
            } else {
                vo.setEq$deptId(pretMemberAuth.getDeptId());
            }

            vo.setEq$status(ConstantEnum.EPretPickUpPlanStatus.待提货.getLabel());
        } else {
            vo.setEq$tallyClerkId(pretMemberAuth.getId());
        }
        vo.setEq$stockUpStatus(res.getStockUpStatus());
        vo.setPage(res.getPage());
        vo.setRows(res.getRows());
        List<PretPickUpPlan> list = this.page(vo).getContent();
        for (PretPickUpPlan pretPickUpPlan : list) {
            if (!StringUtils.isEmpty(pretPickUpPlan.getVenderId())) {
                PretVender pretVender = pretVenderRepository.findById(pretPickUpPlan.getVenderId()).get();
                pretPickUpPlan.setPretVender(pretVender);
            }
            pretPickUpPlan.setDateGap(DateUtil.getShortTime(pretPickUpPlan.getCreateTimeLong()));
            pretPickUpPlan.setPickUpTimeStr(Constants.df2.format(pretPickUpPlan.getPickUpTime()));
        }
        retVo.setData(list);

        retVo.setSerialNo(res.getSerialNo());
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
        pretPickUpPlan.setPickUpTimeStr(Constants.df2.format(pretPickUpPlan.getPickUpTime()));
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
        List<String> deliveryBillNumberList = new ArrayList<>();
        for (PretTransOrder p : pretTransOrderList) {
            if (!deliveryBillNumberList.contains(p.getDeliveryBillNumber())) {
                PR8000007ItemVo itemVo = new PR8000007ItemVo();
                itemVo.setCustomerName(p.getCustomerName());
                itemVo.setDeliveryBillNumber(p.getDeliveryBillNumber());
                itemVo.setPretTransOrderList(pretTransOrderRepository.findByDeliveryBillNumberAndS(p.getDeliveryBillNumber(), ConstantEnum.S.N.getLabel()));
                deliveryBillNumberList.add(p.getDeliveryBillNumber());
                retVo.getItemVoList().add(itemVo);
            }
        }


        pretPickUpPlan.setTransOrderList(pretTransOrderList);

        retVo.setSerialNo(res.getSerialNo());
        return retVo;
    }

    /* *
     * 功能描述: 根据提货计划获取司机详情
     * 〈〉
     * @Param: [res]
     * @Return: com.pret.api.vo.ResBody
     * @Author: wujingsong
     * @Date: 2019/12/5  8:59 上午
     */
    public ResBody getDriveryByPickUpPlanEwm(P8000008Vo res) {
        PR8000008Vo retVo = new PR8000008Vo();

        PretMemberAuth pretMemberAuth = pretMemberAuthRepository.findByOpenidAndS(res.getOpenid(), ConstantEnum.S.N.getLabel());

        PretPickUpPlan pretPickUpPlan = pretPickUpPlanRepository.findByQrcodeAndS(res.getCode(), ConstantEnum.S.N.getLabel());
        Dept dept = deptRepository.findById(pretMemberAuth.getDeptId()).get();
        if (!dept.getU9code().equals(ConstantEnum.EDeptCode.headquarters.getLabel())) {
            if (!pretMemberAuth.getDeptId().equals(pretPickUpPlan.getDeptId())) {
                throw new BusinessException(OpenBEEnum.E90000006.name(), OpenBEEnum.E90000006.getMsg());
            }
        }
        
        pretPickUpPlan.setPickUpTimeStr(Constants.df2.format(pretPickUpPlan.getPickUpTime()));
        PretDriver pretDriver = pretDriverRepository.findById(pretPickUpPlan.getDriverId()).get();
        pretPickUpPlan.setPretDriver(pretDriver);

        retVo.setData(pretPickUpPlan);

        retVo.setSerialNo(res.getSerialNo());
        return retVo;
    }
}
