package com.pret.open.service;

import java.text.ParseException;
import java.util.*;

import com.google.common.reflect.TypeToken;
import com.pret.api.vo.ResBody;
import com.pret.common.constant.CommonConstants;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.exception.BusinessException;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.common.util.DateUtil;
import com.pret.open.constant.OpenBEEnum;
import com.pret.open.entity.*;
import com.pret.open.entity.bo.AddressMatch;
import com.pret.open.entity.bo.PretMTransOrderBo;
import com.pret.open.entity.bo.PretMTransOrderItemBo;
import com.pret.open.entity.bo.PretPickUpPlanBo;
import com.pret.open.entity.user.Dept;
import com.pret.open.entity.vo.PretTransOrderVo;
import com.pret.open.repository.*;
import com.pret.open.repository.user.DeptRepository;
import com.pret.open.vo.req.*;
import com.pret.api.service.impl.BaseServiceImpl;
import com.pret.open.vo.res.PR1000000Vo;
import com.pret.open.vo.res.PR1000006Vo;
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
public class PretTransOrderService extends BaseServiceImpl<PretTransOrderRepository, PretTransOrder, PretTransOrderVo> {
    @Autowired
    private PretPickUpPlanRepository pretPickUpPlanRepository;
    @Autowired
    private PretPickUpPlanService pretPickUpPlanService;
    @Autowired
    private PretCustomerRepository pretCustomerRepository;
    @Autowired
    private PretServiceRouteItemRepository pretServiceRouteItemRepository;
    @Autowired
    private PretAddressService pretAddressService;
    @Autowired
    private PretServiceRouteOriginRepository pretServiceRouteOriginRepository;
    @Autowired
    private PretAddressRepository pretAddressRepository;
    @Autowired
    private PretTransOrderStatisticsRepository pretTransOrderStatisticsRepository;
    @Autowired
    private PretTransOrderGroupRepository pretTransOrderGroupRepository;
    @Autowired
    private DeptRepository deptRepository;
    @Autowired
    private PretTransOrderGroupService pretTransOrderGroupService;
    @Autowired
    private PretSalesRepository pretSalesRepository;

    public void genPickUpPlan(PretPickUpPlanBo bo) {
        String[] idArr = bo.getIds().split(",");
        PretPickUpPlan pretPickUpPlan = pretPickUpPlanService.genDefaultPretPickUpPlan(null, null);
        BeanUtilsExtended.copyProperties(pretPickUpPlan, bo);
        pretPickUpPlanRepository.save(pretPickUpPlan);

        for (String id : idArr) {
            PretTransOrder pretTransOrder = this.repository.findById(id).get();
            pretTransOrder.setPickUpPlanId(pretPickUpPlan.getId());
            this.repository.save(pretTransOrder);
        }
    }

    /* *
     * 功能描述: 下单
     * 〈〉
     * @Param: [res]
     * @Return: com.pret.api.vo.ResBody
     * @Author: wujingsong
     * @Date: 2019/10/10  4:49 下午
     */
    public ResBody order(P1000000Vo res) {
        PR1000000Vo retVo = new PR1000000Vo();

        PretTransOrderGroup pretTransOrderGroup = pretTransOrderGroupRepository.findBySourceCodeAndS(res.getSourceCode(), ConstantEnum.S.N.getLabel());
        if (pretTransOrderGroup != null) {
            throw new BusinessException(OpenBEEnum.E90000008.name(), OpenBEEnum.E90000008.getMsg());
        }

        this.pretTransOrderAdd(res);
        retVo.setSerialNo(res.getSerialNo());

        return retVo;
    }

    /* *
     * 功能描述: 手动创建订单
     * 〈〉
     * @Param: [bo]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/11/7  10:34 上午
     */
    public void pretTransOrderAdd(P1000000Vo bo) {
        List<PretMTransOrderItemBo> list = CommonConstants.GSON.fromJson(bo.getItemListStr(),
                new TypeToken<List<PretMTransOrderItemBo>>() {
                }.getType());

        // 起运地
        PretServiceRouteOrigin pretServiceRouteOrigin = this.getPretServiceRouteOrigin(bo);
        // 部门
        Dept dept = deptRepository.findByU9codeAndS(bo.getOwnFactoryCd(), ConstantEnum.S.N.getLabel());
        if (dept == null) {
            throw new BusinessException(OpenBEEnum.E90000004.name(), OpenBEEnum.E90000004.getMsg());
        }
        // 客户地址
        PretAddress pretAddress = null;
        if (!StringUtils.isEmpty(bo.getDestAreaCd())) {
            pretAddress = pretAddressRepository.findByValueAndLevelsAndS(bo.getDestAreaCd(), ConstantEnum.AreaLevelEnum.区县.getLabel(), ConstantEnum.S.N.getLabel());
        } else if (!StringUtils.isEmpty(bo.getDestCityCd())) {
            pretAddress = pretAddressRepository.findByValueAndLevelsAndS(bo.getDestCityCd(), ConstantEnum.AreaLevelEnum.市.getLabel(), ConstantEnum.S.N.getLabel());
        } else if (!StringUtils.isEmpty(bo.getDestProvinceCd())) {
            pretAddress = pretAddressRepository.findByValueAndLevelsAndS(bo.getDestProvinceCd(), ConstantEnum.AreaLevelEnum.省.getLabel(), ConstantEnum.S.N.getLabel());
        }
        PretCustomer pretCustomer = this.getPretCustomer(bo);
        PretSales pretSales = this.getPretSales(bo);

        PretTransOrderGroup pretTransOrderGroup = new PretTransOrderGroup();
        this.pretTransOrderGroupRepository.save(pretTransOrderGroup);
        PretTransOrder transOrder = null;
        Float totalGw = 0.0f;
        if (list != null && list.size() > 0) {
            for (PretMTransOrderItemBo pretMTransOrderBo : list) {
                PretTransOrder pretTransOrder = new PretTransOrder();
                BeanUtilsExtended.copyProperties(pretTransOrder, bo);
                BeanUtilsExtended.copyProperties(pretTransOrder, pretMTransOrderBo);
                pretTransOrder.setAddressId(pretAddress.getId());
                pretTransOrder.setCustomerAddress(bo.getCustAddr());
                pretTransOrder.setCustomerName(bo.getCustName());
                pretTransOrder.setCustomerLinkPhone(bo.getCustTel());
                pretTransOrder.setCustomerLinkName(bo.getCustAttn());
                pretTransOrder.setDeliveryBillNumber(bo.getDlvOrdNo());
                if (pretServiceRouteOrigin.getType() == ConstantEnum.EPretServiceRouteOriginType.外库.getLabel()) {
                    pretTransOrder.setTransType(ConstantEnum.ETransType.外库配送.getLabel());
                }
                try {
                    pretTransOrder.setDeliveryDate(DateUtils.parseDate(bo.getReqDlvDatetime(), "yyyy-MM-dd HH:mm:ss"));
                    pretTransOrder.setTakeDeliveryDate(DateUtils.parseDate(bo.getReqPickupDatetime(), "yyyy-MM-dd HH:mm:ss"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                pretTransOrder.setRemark(pretMTransOrderBo.getRemark());
                pretTransOrder.setCustomerId(pretCustomer.getId());
                pretTransOrder.setSalesId(pretSales.getId());
                pretTransOrder.setDeptId(dept.getId());
                pretTransOrder.setDeptName(dept.getDeptName());
                if (pretMTransOrderBo.getUnit() == ConstantEnum.EUnit.吨.getLabel()) {
                    pretTransOrder.setSignGw(pretTransOrder.getGw() * 1000);
                } else {
                    pretTransOrder.setSignGw(pretTransOrder.getGw());
                }
                pretTransOrder.setServiceRouteOriginName(pretServiceRouteOrigin.getName());
                String detailAddr = pretAddressService.getDetailByAddressId(pretServiceRouteOrigin.getAddressId()) + pretServiceRouteOrigin.getDetail();
                pretTransOrder.setServiceRouteOriginAddress(detailAddr);
                pretTransOrder.setCustomerDetailAddress(pretAddressService.getDetailByAddressId(pretAddress.getId()) + bo.getCustAddr());
                Float kilo = 0.0f;
                if (pretTransOrder.getUnit() == ConstantEnum.EUnit.公斤.getLabel()) {
                    kilo += pretTransOrder.getGw();
                    totalGw += pretTransOrder.getGw();
                } else {
                    kilo += pretTransOrder.getGw() * 1000;
                    totalGw += pretTransOrder.getGw() * 1000;
                }
                pretTransOrder.setKilo(kilo);
                pretTransOrder.setTransOrderGroupId(pretTransOrderGroup.getId());
                pretTransOrder.setServiceRouteOriginId(pretServiceRouteOrigin.getId());
                this.repository.save(pretTransOrder);

                // 是否存在同一客户，同一地址，同一送达日期的运输单
                List<Integer> statusList = new ArrayList<>();
                statusList.add(ConstantEnum.ETransOrderStatus.待分配.getLabel());
                statusList.add(ConstantEnum.ETransOrderStatus.已分配.getLabel());
                Date date = DateUtils.truncate(pretTransOrder.getDeliveryDate(), Calendar.DATE);
                Date endDate = DateUtils.addDays(date, 1);

                Date dateT = DateUtils.truncate(pretTransOrder.getTakeDeliveryDate(), Calendar.DATE);
                Date endDateT = DateUtils.addDays(dateT, 1);
                List<PretTransOrder> pretTransOrderList = this.repository.findByAddressIdAndTakeDeliveryDateBetweenAndDeliveryDateBetweenAndStatusInAndReturnFlagAndS(pretTransOrder.getAddressId(), dateT, endDateT, date, endDate, statusList, ConstantEnum.YesOrNo.否.getLabel(), ConstantEnum.S.N.getLabel());
                this.calBillingInterval(pretTransOrderList);
                // 统计平台
                this.pretTransOrderStatistics(ConstantEnum.ETransOrderStatisticsUserType.平台.getLabel(), null);
                if (transOrder == null) {
                    transOrder = pretTransOrder;
                }
            }
        }
        BeanUtilsExtended.copyPropertiesIgnore(pretTransOrderGroup, transOrder,"id");
        pretTransOrderGroup.setTotalGw(totalGw);
        pretTransOrderGroupRepository.save(pretTransOrderGroup);
    }

    /* *
     * 功能描述: 生成起运地
     * 〈〉
     * @Param: [bo]
     * @Return: com.pret.open.entity.PretServiceRouteOrigin
     * @Author: wujingsong
     * @Date: 2019/12/22  6:54 下午
     */
    private PretServiceRouteOrigin getPretServiceRouteOrigin(P1000000Vo bo) {
        PretServiceRouteOrigin pretServiceRouteOrigin = pretServiceRouteOriginRepository.findByCodeAndS(bo.getPickupFactoryCd(), ConstantEnum.S.N.getLabel());
        if (pretServiceRouteOrigin == null) {
            PretAddress address = null;
            if (!StringUtils.isEmpty(bo.getOrgAreaCd())) {
                address = pretAddressRepository.findByValueAndLevelsAndS(bo.getOrgAreaCd(), ConstantEnum.AreaLevelEnum.区县.getLabel(), ConstantEnum.S.N.getLabel());
            } else if (!StringUtils.isEmpty(bo.getOrgCityCd())) {
                address = pretAddressRepository.findByValueAndLevelsAndS(bo.getOrgCityCd(), ConstantEnum.AreaLevelEnum.市.getLabel(), ConstantEnum.S.N.getLabel());
            } else if (!StringUtils.isEmpty(bo.getOrgProvinceCd())) {
                address = pretAddressRepository.findByValueAndLevelsAndS(bo.getOrgProvinceCd(), ConstantEnum.AreaLevelEnum.省.getLabel(), ConstantEnum.S.N.getLabel());
            }

            String fullAddress = pretAddressService.getDetailByAddressId(address.getId());
            pretServiceRouteOrigin = new PretServiceRouteOrigin();
            pretServiceRouteOrigin.setCode(bo.getPickupFactoryCd());
            pretServiceRouteOrigin.setAddressId(address.getId());
            pretServiceRouteOrigin.setFullAddress(fullAddress);
            pretServiceRouteOrigin.setLinkPhone(bo.getPickupTel());
            pretServiceRouteOrigin.setLinkMan(bo.getPickupAttn());
            pretServiceRouteOrigin.setDetail(bo.getPickupAddr());
            pretServiceRouteOriginRepository.save(pretServiceRouteOrigin);
        }
        return pretServiceRouteOrigin;
    }

    /* *
     * 功能描述: 获取销售员
     * 〈〉
     * @Param: [bo]
     * @Return: com.pret.open.entity.PretSales
     * @Author: wujingsong
     * @Date: 2019/12/22  6:54 下午
     */
    private PretSales getPretSales(P1000000Vo bo) {
        PretSales pretSales = pretSalesRepository.findBySalesCdAndS(bo.getSalesCd(), ConstantEnum.S.N.getLabel());
        if (pretSales == null) {
            pretSales = new PretSales();
            BeanUtilsExtended.copyProperties(pretSales, bo);
            pretSalesRepository.save(pretSales);
        }
        return pretSales;
    }

    /* *
     * 功能描述: 获取客户
     * 〈〉
     * @Param: [bo]
     * @Return: com.pret.open.entity.PretCustomer
     * @Author: wujingsong
     * @Date: 2019/12/22  6:54 下午
     */
    private PretCustomer getPretCustomer(P1000000Vo bo) {
        PretCustomer pretCustomer = pretCustomerRepository.findByCodeAndS(bo.getCustCd(), ConstantEnum.S.N.getLabel());
        if (pretCustomer == null) {
            pretCustomer = new PretCustomer();
            BeanUtilsExtended.copyProperties(pretCustomer, bo);
            pretCustomer.setName(bo.getCustName());
            pretCustomer.setLinkName(bo.getCustAttn());
            pretCustomer.setLinkPhone(bo.getCustTel());
            pretCustomer.setCode(bo.getCustCd());
            pretCustomerRepository.save(pretCustomer);
        } else {
            if (StringUtils.isEmpty(pretCustomer.getName())) {
                pretCustomer.setName(bo.getCustName());
            }
            pretCustomerRepository.save(pretCustomer);
        }
        return pretCustomer;
    }

    /* *
     * 功能描述: 查找供应商
     * 〈〉
     * @Param: [pretTransOrderList, isHeavyCargo, pretServiceRouteItemList]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/11/9  10:53 上午
     */
    public void calBillingInterval(List<PretTransOrder> pretTransOrderList) {
        Float totalGw = 0.0f;
        String venderId = StringUtils.EMPTY;
        PretAddress address = null;
        String pickupFactoryCd = null;
        for (PretTransOrder pretTransOrder : pretTransOrderList) {
            if (pretTransOrder.getUnit() == ConstantEnum.EUnit.公斤.getLabel()) {
                totalGw += pretTransOrder.getGw();
            } else {
                totalGw += pretTransOrder.getGw() * 1000;
            }
            venderId = pretTransOrder.getVenderId();
            if (address == null) {
                address = pretAddressRepository.findById(pretTransOrder.getAddressId()).get();
            }
            if (StringUtils.isEmpty(pickupFactoryCd)) {
                pickupFactoryCd = pretTransOrder.getPickupFactoryCd();
            }
        }

        if (!StringUtils.isEmpty(venderId)) {
            List<String> pretAddressList = pretAddressService.findAddressListByAddressIdAdd(address.getId());
            List<PretServiceRouteItem> pretServiceRouteItemList = pretServiceRouteItemRepository.findByCodeAndVenderTypeAndAddressIdInAndS(pickupFactoryCd, ConstantEnum.EVenderType.三方.getLabel(), pretAddressList, ConstantEnum.S.N.getLabel());

            String serviceRouteItemId = null;
            AddressMatch addressMatch = new AddressMatch();
            for (PretServiceRouteItem item : pretServiceRouteItemList) {
                Float lowLimit = item.getLowerLimit() == null ? 0 : item.getLowerLimit();
                if (totalGw >= lowLimit) {
                    PretAddress pretAddress = pretAddressRepository.findById(item.getAddressId()).get();
                    if (address.getLevels() == ConstantEnum.AreaLevelEnum.区县.getLabel()) {
                        if (pretAddress.getLevels() == ConstantEnum.AreaLevelEnum.区县.getLabel()) {
                            addressMatch.setArea(pretAddress);
                            addressMatch.setServiceRouteItemIdByArea(item.getServiceRouteId());
                        } else if (pretAddress.getLevels() == ConstantEnum.AreaLevelEnum.市.getLabel()) {
                            PretAddress parent = pretAddressRepository.findById(address.getParentId()).get();
                            if (parent.getId().equals(pretAddress.getId())) {
                                addressMatch.setCity(pretAddress);
                                addressMatch.setServiceRouteItemIdByCity(item.getServiceRouteId());
                            }
                        } else if (pretAddress.getLevels() == ConstantEnum.AreaLevelEnum.省.getLabel()) {
                            PretAddress parent = pretAddressRepository.findById(address.getParentId()).get();
                            parent = pretAddressRepository.findById(parent.getParentId()).get();
                            if (parent.getId().equals(pretAddress.getId())) {
                                addressMatch.setCity(pretAddress);
                                addressMatch.setServiceRouteItemIdByProvince(item.getServiceRouteId());
                            }
                        }
                    } else if (address.getLevels() == ConstantEnum.AreaLevelEnum.市.getLabel()) {
                        if (pretAddress.getLevels() == ConstantEnum.AreaLevelEnum.市.getLabel()) {
                            if (address.getId().equals(pretAddress.getId())) {
                                addressMatch.setCity(pretAddress);
                                addressMatch.setServiceRouteItemIdByCity(item.getServiceRouteId());
                            }
                        } else if (pretAddress.getLevels() == ConstantEnum.AreaLevelEnum.省.getLabel()) {
                            PretAddress parent = pretAddressRepository.findById(address.getParentId()).get();
                            if (parent.getId().equals(pretAddress.getId())) {
                                addressMatch.setCity(pretAddress);
                                addressMatch.setServiceRouteItemIdByProvince(item.getServiceRouteId());
                            }
                        }
                    } else if (address.getLevels() == ConstantEnum.AreaLevelEnum.省.getLabel()) {
                        if (pretAddress.getLevels() == ConstantEnum.AreaLevelEnum.省.getLabel()) {
                            if (address.getId().equals(pretAddress.getId())) {
                                addressMatch.setCity(pretAddress);
                                addressMatch.setServiceRouteItemIdByProvince(item.getServiceRouteId());
                            }
                        }
                    }
                }
            }

            if (!StringUtils.isEmpty(addressMatch.getServiceRouteItemIdByArea())) {
                serviceRouteItemId = addressMatch.getServiceRouteItemIdByArea();
            } else if (!StringUtils.isEmpty(addressMatch.getServiceRouteItemIdByCity())) {
                serviceRouteItemId = addressMatch.getServiceRouteItemIdByCity();
            } else {
                serviceRouteItemId = addressMatch.getServiceRouteItemIdByProvince();
            }

            for (PretTransOrder pretTransOrder : pretTransOrderList) {
                pretTransOrder.setVenderId(venderId);
                pretTransOrder.setStatus(ConstantEnum.ETransOrderStatus.已分配.getLabel());
                pretTransOrder.setServiceRouteItemId(serviceRouteItemId);
                this.pretTransOrderStatistics(ConstantEnum.ETransOrderStatisticsUserType.物流供应商.getLabel(), venderId);
            }
            this.repository.saveAll(pretTransOrderList);
            PretTransOrderGroup pretTransOrderGroup = pretTransOrderGroupRepository.findById(pretTransOrderList.get(0).getTransOrderGroupId()).get();
            pretTransOrderGroup.setVenderId(venderId);
            pretTransOrderGroup.setStatus(ConstantEnum.ETransOrderStatus.已分配.getLabel());
            pretTransOrderGroupRepository.save(pretTransOrderGroup);
        }
    }

    /* *
     * 功能描述: 指定供应商
     * 〈〉
     * @Param: [id, venderId]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/11/9  8:51 上午
     */
    public void allocateVender(String id, String venderId) {
        PretTransOrder pretTransOrder = this.repository.findById(id).get();
        pretTransOrder.setVenderId(venderId);
        pretTransOrder.setStatus(ConstantEnum.ETransOrderStatus.待提货.getLabel());
        this.repository.save(pretTransOrder);

        PretTransOrderGroup pretTransOrderGroup = pretTransOrderGroupRepository.findById(pretTransOrder.getTransOrderGroupId()).get();
        pretTransOrderGroup.setStatus(ConstantEnum.ETransOrderStatus.待提货.getLabel());
        pretTransOrderGroupRepository.save(pretTransOrderGroup);
    }

    /* *
     * 功能描述: 删除订单
     * 〈〉
     * @Param: [res]
     * @Return: com.pret.api.vo.ResBody
     * @Author: wujingsong
     * @Date: 2019/11/21  11:59 上午
     */
    public ResBody deleteOrder(P1000005Vo res) {
        PR1000006Vo retVo = new PR1000006Vo();

        PretTransOrderGroup pretTransOrderGroup = pretTransOrderGroupRepository.findBySourceCodeAndS(res.getSourceCode(), ConstantEnum.S.N.getLabel());
        if (pretTransOrderGroup == null) {
            throw new BusinessException(OpenBEEnum.E90000007.name(), OpenBEEnum.E90000007.getMsg());
        }
        if (pretTransOrderGroup != null) {
            PretTransOrder pretTransOrder = this.repository.findTop1ByTransOrderGroupIdAndS(pretTransOrderGroup.getId(), ConstantEnum.S.N.getLabel());
            if (!StringUtils.isEmpty(pretTransOrder.getPickUpPlanId())) {
                throw new BusinessException(OpenBEEnum.E90000006.name(), OpenBEEnum.E90000006.getMsg());
            }
        }


        this.pretTransOrderGroupService.lDelete(pretTransOrderGroup.getId());

        retVo.setSerialNo(res.getSerialNo());
        return retVo;
    }

    /* *
     * 功能描述: 订单统计数据添加
     * 〈〉
     * @Param: []
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/12/3  1:24 下午
     */
    public void pretTransOrderStatistics(Integer userType, String venderId) {
        Date start = DateUtils.truncate(new Date(), Calendar.DATE);
        Date dateEnd = DateUtils.addDays(start, 1);

        // 日统计
        this.doStat(userType, ConstantEnum.EDateType.日.getLabel(), venderId, start, dateEnd);
        // 周统计
        start = DateUtil.getBeginDayOfWeek();
        this.doStat(userType, ConstantEnum.EDateType.周.getLabel(), venderId, start, dateEnd);
        // 月统计
        start = DateUtil.getBeginDayOfMonth();
        this.doStat(userType, ConstantEnum.EDateType.月.getLabel(), venderId, start, dateEnd);
        // 年
        start = DateUtil.getBeginDayOfMonth();
        this.doStat(userType, ConstantEnum.EDateType.年.getLabel(), venderId, start, dateEnd);
    }

    protected void doStat(Integer userType, Integer dateType, String venderId, Date start, Date dateEnd) {
        List<PretTransOrderStatistics> pretTransOrderStatisticsList;
        if (userType == ConstantEnum.ETransOrderStatisticsUserType.平台.getLabel()) {
            pretTransOrderStatisticsList = pretTransOrderStatisticsRepository.findByUserTypeAndDateTypeAndCreateTimeLongBetween(userType, dateType, start.getTime(), dateEnd.getTime());
        } else {
            pretTransOrderStatisticsList = pretTransOrderStatisticsRepository.findByUserTypeAndUserIdAndDateTypeAndCreateTimeLongBetween(userType, venderId, dateType, start.getTime(), dateEnd.getTime());
        }
        PretTransOrderStatistics pretTransOrderStatistics;
        if (pretTransOrderStatisticsList != null && pretTransOrderStatisticsList.size() == 1) {
            pretTransOrderStatistics = pretTransOrderStatisticsList.get(0);
            pretTransOrderStatistics.setCount(pretTransOrderStatistics.getCount() + 1);
            pretTransOrderStatisticsRepository.save(pretTransOrderStatistics);
        } else {
            pretTransOrderStatistics = new PretTransOrderStatistics();
            pretTransOrderStatistics.setUserType(userType);
            pretTransOrderStatistics.setDateType(dateType);
            if (!StringUtils.isEmpty(venderId)) {
                pretTransOrderStatistics.setUserId(venderId);
            }
            pretTransOrderStatistics.setCount(1);
            pretTransOrderStatisticsRepository.save(pretTransOrderStatistics);
        }
        pretTransOrderStatisticsRepository.save(pretTransOrderStatistics);
    }
}
