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

        // 客户
        PretMTransOrderBo bo = new PretMTransOrderBo();
        PretAddress pretAddress = null;
        if (!StringUtils.isEmpty(res.getDestAreaCd())) {
            pretAddress = pretAddressRepository.findByValueAndLevelsAndS(res.getDestAreaCd(), ConstantEnum.AreaLevelEnum.区县.getLabel(), ConstantEnum.S.N.getLabel());
        } else if (!StringUtils.isEmpty(res.getDestCityCd())) {
            pretAddress = pretAddressRepository.findByValueAndLevelsAndS(res.getDestCityCd(), ConstantEnum.AreaLevelEnum.市.getLabel(), ConstantEnum.S.N.getLabel());
        } else if (!StringUtils.isEmpty(res.getDestProvinceCd())) {
            pretAddress = pretAddressRepository.findByValueAndLevelsAndS(res.getDestProvinceCd(), ConstantEnum.AreaLevelEnum.省.getLabel(), ConstantEnum.S.N.getLabel());
        }
        bo.setAddressId(pretAddress.getId());
        bo.setCustomerAddress(res.getCustAddr());
        bo.setCustCd(res.getCustCd());
        bo.setCustomerLinkName(res.getCustAttn());
        bo.setCustomerLinkPhone(res.getCustTel());
        bo.setCustomerName(res.getCustName());
        bo.setDeliveryBillNumber(res.getDlvOrdNo());
        bo.setOwnFactoryCd(res.getOwnFactoryCd());
        bo.setTotalCbm(res.getTotalCbm());
        bo.setTotalPkg(res.getTotalPkg());
        bo.setDataSource(res.getDataSource());
        bo.setSourceCode(res.getSourceCode());
        bo.setTransType(res.getTransType());
        bo.setOrgBigAreaCd(res.getOrgBigAreaCd());
        bo.setDestBigAreaCd(res.getDestBigAreaCd());
        bo.setPickupAddr(res.getPickupAddr());
        bo.setPickupAttn(res.getPickupAttn());
        bo.setPickupTel(res.getPickupTel());
        try {
            bo.setDeliveryDate(DateUtils.parseDate(res.getReqDlvDatetime(), "yyyy-MM-dd HH:mm:ss"));
            bo.setTakeDeliveryDate(DateUtils.parseDate(res.getReqPickupDatetime(), "yyyy-MM-dd HH:mm:ss"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        bo.setPickupFactoryCd(res.getPickupFactoryCd());
        bo.setRemark(res.getRemark());
        PretServiceRouteOrigin pretServiceRouteOrigin = pretServiceRouteOriginRepository.findByCodeAndS(res.getPickupFactoryCd(), ConstantEnum.S.N.getLabel());
        if (pretServiceRouteOrigin != null) {
            bo.setServiceRouteOriginId(pretServiceRouteOrigin.getId());
        } else {
            PretAddress address = null;
            if (!StringUtils.isEmpty(res.getOrgAreaCd())) {
                address = pretAddressRepository.findByValueAndLevelsAndS(res.getOrgAreaCd(), ConstantEnum.AreaLevelEnum.区县.getLabel(), ConstantEnum.S.N.getLabel());
            } else if (!StringUtils.isEmpty(res.getOrgCityCd())) {
                address = pretAddressRepository.findByValueAndLevelsAndS(res.getOrgCityCd(), ConstantEnum.AreaLevelEnum.市.getLabel(), ConstantEnum.S.N.getLabel());
            } else if (!StringUtils.isEmpty(res.getOrgProvinceCd())) {
                address = pretAddressRepository.findByValueAndLevelsAndS(res.getOrgProvinceCd(), ConstantEnum.AreaLevelEnum.省.getLabel(), ConstantEnum.S.N.getLabel());
            }

            String fullAddress = pretAddressService.getDetailByAddressId(address.getId());
            pretServiceRouteOrigin = new PretServiceRouteOrigin();
            pretServiceRouteOrigin.setCode(res.getPickupFactoryCd());
            pretServiceRouteOrigin.setAddressId(address.getId());
            pretServiceRouteOrigin.setFullAddress(fullAddress);
            pretServiceRouteOriginRepository.save(pretServiceRouteOrigin);
            bo.setServiceRouteOriginId(pretServiceRouteOrigin.getId());
        }

        bo.setTransMode(res.getTransModeCd());
        bo.setTransModeNm(res.getTranModeNm());

        List<PretMTransOrderItemBo> list = CommonConstants.GSON.fromJson(res.getItemListStr(),
                new TypeToken<List<PretMTransOrderItemBo>>() {
                }.getType());

        this.pretTransOrderAdd(bo, list);
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
    public void pretTransOrderAdd(PretMTransOrderBo bo, List<PretMTransOrderItemBo> bo2) {
        List<PretMTransOrderItemBo> list = CommonConstants.GSON.fromJson(bo.getPretMTransOrderItemStr(),
                new TypeToken<List<PretMTransOrderItemBo>>() {
                }.getType());
        if (bo2 != null) {
            list = bo2;
        }
        boolean flag = false;
        Dept dept = deptRepository.findByU9codeAndS(bo.getOwnFactoryCd(), ConstantEnum.S.N.getLabel());
        if (dept == null) {
            throw new BusinessException(OpenBEEnum.E90000004.name(), OpenBEEnum.E90000004.getMsg());
        }
        if (list != null && list.size() > 0) {
            for (PretMTransOrderItemBo pretMTransOrderBo : list) {
                PretTransOrderGroup pretTransOrderGroup = pretTransOrderGroupRepository.findByDeliveryBillNumberAndS(bo.getDeliveryBillNumber(), ConstantEnum.S.N.getLabel());
                if (pretTransOrderGroup != null) {
                    flag = true;
                } else {
                    pretTransOrderGroup = new PretTransOrderGroup();
                    pretTransOrderGroup.setDeptId(dept.getId());
                    pretTransOrderGroup.setOwnFactoryCd(bo.getOwnFactoryCd());
                    pretTransOrderGroup.setTotalCbm(bo.getTotalCbm());
                    pretTransOrderGroup.setTotalPkg(bo.getTotalPkg());
                    pretTransOrderGroup.setTransModeCd(bo.getTransModeCd());
                    pretTransOrderGroup.setSalesCd(bo.getSalesCd());
                    pretTransOrderGroup.setSourceCode(bo.getSourceCode());
                    pretTransOrderGroup.setDataSource(bo.getDataSource());
                    pretTransOrderGroup.setTransType(bo.getTransType());
                    pretTransOrderGroup.setOrgBigAreaCd(bo.getOrgBigAreaCd());
                    pretTransOrderGroup.setDestBigAreaCd(bo.getDestBigAreaCd());
                    pretTransOrderGroup.setPickupAddr(bo.getPickupAddr());
                    pretTransOrderGroup.setPickupAttn(bo.getPickupAttn());
                    pretTransOrderGroup.setPickupTel(bo.getPickupTel());
                    this.pretTransOrderGroupRepository.save(pretTransOrderGroup);
                }
                PretTransOrder pretTransOrder = new PretTransOrder();
                pretTransOrder.setGw(pretMTransOrderBo.getGw());
                pretTransOrder.setUnit(pretMTransOrderBo.getUnit());
                pretTransOrder.setTransModeCd(bo.getTransModeCd());
                pretTransOrder.setGoodsNum(pretMTransOrderBo.getGoodsNum());
                pretTransOrder.setTransOrderGroupId(pretTransOrderGroup.getId());
                pretTransOrder.setDeptId(dept.getId());
                pretTransOrder.setSourceCode(bo.getSourceCode());
                pretTransOrder.setOwnFactoryCd(bo.getOwnFactoryCd());
                pretTransOrder.setSalesCd(bo.getSalesCd());
                pretTransOrder.setCustCd(bo.getCustCd());
                pretTransOrder.setTransType(bo.getTransType());
                pretTransOrder.setSignGw(pretTransOrder.getGw());
                pretTransOrder.setPickupAddr(bo.getPickupAddr());
                pretTransOrder.setPickupAttn(bo.getPickupAttn());
                pretTransOrder.setPickupTel(bo.getPickupTel());

                BeanUtilsExtended.copyProperties(pretTransOrder, pretMTransOrderBo);
                pretTransOrder.setRemark(pretMTransOrderBo.getRemark());
                if (StringUtils.isEmpty(bo.getCustomerName())) {
                    pretTransOrder.setCustomerName(bo.getCustomerLinkName());
                }
                // 设置起运地详细地址
                PretServiceRouteOrigin pretServiceRouteOrigin = pretServiceRouteOriginRepository.findById(bo.getServiceRouteOriginId()).get();
                pretTransOrder.setServiceRouteOriginName(pretServiceRouteOrigin.getName());
                String detailAddr = pretAddressService.getDetailByAddressId(pretServiceRouteOrigin.getAddressId()) + pretServiceRouteOrigin.getDetail();
                pretTransOrder.setServiceRouteOriginAddress(detailAddr);
                pretTransOrder.setServiceRouteOriginName(pretServiceRouteOrigin.getName());

                BeanUtilsExtended.copyProperties(pretTransOrder, bo);
                pretTransOrder.setCustomerDetailAddress(pretAddressService.getDetailByAddressId(bo.getAddressId()) + bo.getCustomerAddress());
                BeanUtilsExtended.copyProperties(pretTransOrder, pretMTransOrderBo);
                Float kilo = 0.0f;
                if (pretTransOrder.getUnit() == ConstantEnum.EUnit.公斤.getLabel()) {
                    kilo += pretTransOrder.getGw();
                } else {
                    kilo += pretTransOrder.getGw() * 1000;
                }
                pretTransOrder.setKilo(kilo);
                this.repository.save(pretTransOrder);
                PretCustomer pretCustomer = pretCustomerRepository.findByCodeAndS(bo.getCustCd(), ConstantEnum.S.N.getLabel());
                if (pretCustomer == null) {
                    pretCustomer = new PretCustomer();
                    BeanUtilsExtended.copyProperties(pretCustomer, bo);
                    pretCustomer.setName(bo.getCustomerName());
                    pretCustomer.setLinkName(bo.getCustomerLinkName());
                    pretCustomer.setLinkPhone(bo.getCustomerLinkPhone());
                    pretCustomer.setCode(bo.getCustCd());
                    pretCustomerRepository.save(pretCustomer);
                } else {
                    if (StringUtils.isEmpty(pretCustomer.getName())) {
                        pretCustomer.setName(bo.getCustomerName());
                    }
                    pretCustomerRepository.save(pretCustomer);
                }
                pretTransOrder.setCustomerId(pretCustomer.getId());
                // 是否存在同一客户，同一地址，同一送达日期的运输单
                List<Integer> statusList = new ArrayList<>();
                statusList.add(ConstantEnum.ETransOrderStatus.待分配.getLabel());
                statusList.add(ConstantEnum.ETransOrderStatus.已分配.getLabel());
                Date date = DateUtils.truncate(bo.getDeliveryDate(), Calendar.DATE);
                Date endDate = DateUtils.addDays(date, 1);

                Date dateT = DateUtils.truncate(bo.getTakeDeliveryDate(), Calendar.DATE);
                Date endDateT = DateUtils.addDays(dateT, 1);
                List<String> pretAddressList = pretAddressService.findAddressListByAddressIdAdd(bo.getAddressId());
                List<PretTransOrder> pretTransOrderList = this.repository.findByAddressIdAndTakeDeliveryDateBetweenAndDeliveryDateBetweenAndStatusInAndS(bo.getAddressId(), dateT, endDateT, date, endDate, statusList, ConstantEnum.S.N.getLabel());
                List<PretServiceRouteItem> pretServiceRouteItemList = pretServiceRouteItemRepository.findByCodeAndVenderTypeAndAddressIdInAndS(bo.getPickupFactoryCd(), ConstantEnum.EVenderType.三方.getLabel(), pretAddressList, ConstantEnum.S.N.getLabel());
                this.calBillingInterval(pretTransOrderList, pretTransOrder, true, pretServiceRouteItemList);
                // 统计平台
                this.pretTransOrderStatistics(ConstantEnum.ETransOrderStatisticsUserType.平台.getLabel(), null);
                if (!flag) {
                    BeanUtilsExtended.copyPropertiesIgnore(pretTransOrderGroup, pretTransOrder, "id");
                    pretTransOrderGroupRepository.save(pretTransOrderGroup);
                }
            }
        }
    }

    /* *
     * 功能描述: 查找供应商
     * 〈〉
     * @Param: [pretTransOrderList, isHeavyCargo, pretServiceRouteItemList]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/11/9  10:53 上午
     */
    public void calBillingInterval(List<PretTransOrder> pretTransOrderList, PretTransOrder transOrder, boolean isHeavyCargo, List<PretServiceRouteItem> pretServiceRouteItemList) {
        Float totalGw = 0.0f;
        String venderId = StringUtils.EMPTY;
        PretAddress address = null;
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
        }

        String serviceRouteItemId = StringUtils.EMPTY;
        AddressMatch addressMatch = new AddressMatch();

        for (PretServiceRouteItem item : pretServiceRouteItemList) {
            Float lowLimit = item.getLowerLimit() == null ? 0 : item.getLowerLimit();
            if (isHeavyCargo && totalGw >= lowLimit) {
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

        if (StringUtils.isEmpty(venderId)) {
            for (PretServiceRouteItem item : pretServiceRouteItemList) {
                Float lowLimit = item.getLowerLimit() == null ? 0 : item.getLowerLimit();

                if (isHeavyCargo && totalGw >= lowLimit) {
                    for (PretTransOrder pretTransOrder : pretTransOrderList) {
                        pretTransOrder.setVenderId(item.getVenderId());
                        pretTransOrder.setStatus(ConstantEnum.ETransOrderStatus.已分配.getLabel());
                        pretTransOrder.setServiceRouteItemId(item.getId());
                        this.pretTransOrderStatistics(ConstantEnum.ETransOrderStatisticsUserType.物流供应商.getLabel(), item.getVenderId());
                    }
                    transOrder.setVenderId(item.getVenderId());
                    transOrder.setServiceRouteItemId(serviceRouteItemId);
                    transOrder.setStatus(ConstantEnum.ETransOrderStatus.已分配.getLabel());
                    this.repository.saveAll(pretTransOrderList);
                    PretTransOrderGroup pretTransOrderGroup = pretTransOrderGroupRepository.findById(pretTransOrderList.get(0).getTransOrderGroupId()).get();
                    pretTransOrderGroup.setVenderId(item.getVenderId());
                    pretTransOrderGroup.setStatus(ConstantEnum.ETransOrderStatus.已分配.getLabel());
                    pretTransOrderGroupRepository.save(pretTransOrderGroup);
                }
            }
        } else {
            transOrder.setStatus(ConstantEnum.ETransOrderStatus.已分配.getLabel());
            transOrder.setVenderId(venderId);
            this.repository.save(transOrder);
            this.pretTransOrderStatistics(ConstantEnum.ETransOrderStatisticsUserType.物流供应商.getLabel(), venderId);

            PretTransOrderGroup pretTransOrderGroup = pretTransOrderGroupRepository.findById(pretTransOrderList.get(0).getTransOrderGroupId()).get();
            pretTransOrderGroup.setStatus(ConstantEnum.ETransOrderStatus.已分配.getLabel());
            pretTransOrderGroup.setVenderId(venderId);
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
