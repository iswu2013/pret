package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.*;
import com.pret.open.entity.bo.AreaBo;
import com.pret.open.entity.vo.PretQuotationItemRVo;
import com.pret.open.entity.vo.PretServiceRouteItemVo;
import com.pret.open.repository.*;
import com.pret.open.service.PretServiceRouteItemService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Validated
@RestController
@RequestMapping("pretServiceRouteItem")
public class PretServiceRouteItemController extends BaseManageController<PretServiceRouteItemService, PretServiceRouteItem, PretServiceRouteItemVo> {
    @Autowired
    private PretServiceRouteItemRepository pretServiceRouteItemRepository;
    @Autowired
    private PretServiceRouteOriginRepository pretServiceRouteOrginRepository;
    @Autowired
    private PretAddressRepository pretAddressRepository;
    @Autowired
    private PretVenderRepository pretVenderRepository;
    @Autowired
    private PretServiceRouteRepository pretServiceRouteRepository;
    @Autowired
    private PretQuotationItemRepository pretQuotationItemRepository;
    @Autowired
    private PretBillingIntervalItemRepository pretBillingIntervalItemRepository;
    @PersistenceContext
    private EntityManager em;

    @Log("查看")
    @PostMapping("/view/{id}")
    public PretServiceRouteItem view(@PathVariable String id) throws FebsException {
        try {
            PretServiceRouteItem item = this.service.findById(id).get();
            return item;
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
    }

    /* *
     * 功能描述: 根据serviceLineId查找
     * 〈〉
     * @Param: [id]
     * @Return: java.util.List<com.pret.open.entity.PretServiceRouteItem>
     * @Author: wujingsong
     * @Date: 2019/10/24  9:33 上午
     */
    @GetMapping(value = "/getByServiceLineId/{id}")
    public List<PretServiceRouteItem> getByServiceLineId(@PathVariable String id) {
        List<PretServiceRouteItem> serviceRouteItemList = pretServiceRouteItemRepository.findByServiceRouteIdAndS(id, ConstantEnum.S.N.getLabel());

        return serviceRouteItemList;
    }

    @GetMapping(value = "/getByServiceLineIdDisplayByArea/{id}")
    public List<AreaBo> getByServiceLineIdDisplayByArea(@PathVariable String id) {
        List<AreaBo> list = new ArrayList<>();

        List<PretServiceRouteItem> serviceRouteItemList = pretServiceRouteItemRepository.findByServiceRouteIdAndS(id, ConstantEnum.S.N.getLabel());
        if (serviceRouteItemList != null && serviceRouteItemList.size() > 0) {
            for (PretServiceRouteItem item : serviceRouteItemList) {
                AreaBo areaBo = new AreaBo();
                if (!StringUtils.isEmpty(item.getAddressId())) {
                    PretAddress pretAddress = pretAddressRepository.findById(item.getAddressId()).get();
                    if (pretAddress.getLevels() == ConstantEnum.AreaLevelEnum.区县.getLabel()) {
                        areaBo.setArea(pretAddress.getName());
                        PretAddress city = pretAddressRepository.findById(pretAddress.getParentId()).get();
                        areaBo.setCity(city.getName());
                        PretAddress province = pretAddressRepository.findById(city.getParentId()).get();
                        areaBo.setProvince(province.getName());
                    } else if (pretAddress.getLevels() == ConstantEnum.AreaLevelEnum.市.getLabel()) {
                        areaBo.setCity(pretAddress.getName());
                        PretAddress province = pretAddressRepository.findById(pretAddress.getParentId()).get();
                        areaBo.setProvince(province.getName());
                    } else if (pretAddress.getLevels() == ConstantEnum.AreaLevelEnum.省.getLabel()) {
                        areaBo.setProvince(pretAddress.getName());
                    }
                    areaBo.setLabel(pretAddress.getName());
                    areaBo.setValue(pretAddress.getId());
                    areaBo.setServiceRouteOriginId(item.getServiceRouteOriginId());
                    areaBo.setPrescription(item.getPrescription());
                    areaBo.setLowerLimit(item.getLowerLimit());
                    areaBo.setMileage(item.getMileage());
                    list.add(areaBo);
                }
            }
        }

        return list;
    }

    @GetMapping
    @Override()
    public Map<String, Object> list(PretServiceRouteItemVo request, PretServiceRouteItem t) {
        Page<PretServiceRouteItem> page = this.service.page(request);
        for (PretServiceRouteItem route : page.getContent()) {
            String startEndName = StringUtils.EMPTY;
            PretServiceRouteOrigin pretServiceRouteOrgin = pretServiceRouteOrginRepository.findById(route.getServiceRouteOriginId()).get();
            startEndName += pretServiceRouteOrgin.getName() + "-";
            PretAddress pretAddress = pretAddressRepository.findById(route.getAddressId()).get();
            if (pretAddress.getLevels() == ConstantEnum.AreaLevelEnum.区县.getLabel()) {
                PretAddress address = pretAddressRepository.findById(pretAddress.getParentId()).get();
                PretAddress a = pretAddressRepository.findById(address.getParentId()).get();
                startEndName += a.getName() + address.getName() + pretAddress.getName();
            } else if (pretAddress.getLevels() == ConstantEnum.AreaLevelEnum.市.getLabel()) {
                PretAddress address = pretAddressRepository.findById(pretAddress.getParentId()).get();
                startEndName += address.getName() + pretAddress.getName();
            } else {
                startEndName += pretAddress.getName();
            }
            route.setStartEndName(startEndName);
        }
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", page.getContent());
        rspData.put("total", page.getTotalElements());

        return rspData;
    }

    /* *
     * 功能描述: 获取线路明细
     * 〈〉
     * @Param: []
     * @Return: java.lang.Iterable<com.pret.open.entity.PretServiceRouteItem>
     * @Author: wujingsong
     * @Date: 2019/11/6  4:48 下午
     */
    @GetMapping(value = "/getItemList")
    public List<PretVender> getItemList(PretServiceRouteItemVo request) {
        List<PretVender> pretVenderList = new ArrayList<>();
        Iterable<PretServiceRouteItem> serviceRouteItemList = this.service.page(request).getContent();
        List<String> idList = new ArrayList<>();
        for (PretServiceRouteItem item : serviceRouteItemList) {
            if (!StringUtils.isEmpty(item.getVenderId())) {
                PretVender pretVender = pretVenderRepository.findById(item.getVenderId()).get();
                if (!idList.contains(item.getId())) {
                    List<PretQuotationItem> pretQuotationItemList = pretQuotationItemRepository.findByVenderIdAndS(item.getVenderId(), ConstantEnum.S.N.getLabel());
                    PretQuotationItem quotationItem = null;
                    for (PretQuotationItem pretQuotationItem : pretQuotationItemList) {
                        PretBillingIntervalItem pretBillingIntervalItem = pretBillingIntervalItemRepository.findById(pretQuotationItem.getBillingIntervalItemId()).get();
                        if (request.getGw() > pretBillingIntervalItem.getKstart() && request.getGw() < pretBillingIntervalItem.getKend()) {
                            quotationItem = pretQuotationItem;
                            break;
                        }
                    }
                    if (quotationItem != null) {
                        PretServiceRouteItem pretServiceRouteItem = pretServiceRouteItemRepository.findById(quotationItem.getServiceRouteItemId()).get();
                        pretVender.setPrescription(pretServiceRouteItem.getPrescription());
                        pretVender.setFeight(quotationItem.getQuotation().multiply(new BigDecimal(request.getGw())));
                        pretVender.setUnitPrice(quotationItem.getQuotation());
                    }

                    pretVenderList.add(pretVender);
                    idList.add(item.getId());
                }
            }
        }

        return pretVenderList;
    }

    /* *
     * 功能描述: 查找没有关联供应商的线路明细
     * 〈〉
     * @Param: []
     * @Return: java.util.List<com.pret.open.entity.PretServiceRouteItem>
     * @Author: wujingsong
     * @Date: 2019/11/11  10:06 下午
     */
    @GetMapping(value = "/getByVenderIsNull/{venderId}/{serviceRouteId}")
    public PretQuotationItemRVo getByVenderIsNull(@PathVariable String venderId, @PathVariable String serviceRouteId) {
        PretQuotationItemRVo retVo = new PretQuotationItemRVo();

        String where = " where 1=1 and (a.vender_id is NULL or a.vender_id = '" + venderId + "') and a.service_route_id = '" + serviceRouteId + "' and a.s = 1 order by service_route_origin_id Desc ";
        String con = "SELECT a.id,a.code FROM pret_service_route_item a  " + where;
        StringBuffer querySql = new StringBuffer(con);
        Query query = em.createNativeQuery(querySql.toString());
        query.setFirstResult(0);
        query.setMaxResults(Integer.MAX_VALUE);
        List<String> idList = new ArrayList<>();
        List<Object[]> objectList = query.getResultList();
        if (objectList.size() > 0) {
            for (Object object[] : objectList) {
                String id = object[0].toString();
                idList.add(id);
            }
        }
        List<PretServiceRouteItem> serviceRouteItemList = pretServiceRouteItemRepository.findByIdIn(idList);
        for (PretServiceRouteItem route : serviceRouteItemList) {
            String startEndName = StringUtils.EMPTY;
            PretServiceRouteOrigin pretServiceRouteOrgin = pretServiceRouteOrginRepository.findById(route.getServiceRouteOriginId()).get();
            startEndName += pretServiceRouteOrgin.getName() + "-";
            PretAddress pretAddress = pretAddressRepository.findById(route.getAddressId()).get();
            if (pretAddress.getLevels() == ConstantEnum.AreaLevelEnum.区县.getLabel()) {
                PretAddress address = pretAddressRepository.findById(pretAddress.getParentId()).get();
                PretAddress a = pretAddressRepository.findById(address.getParentId()).get();
                startEndName += a.getName() + address.getName() + pretAddress.getName();
            } else if (pretAddress.getLevels() == ConstantEnum.AreaLevelEnum.市.getLabel()) {
                PretAddress address = pretAddressRepository.findById(pretAddress.getParentId()).get();
                startEndName += address.getName() + pretAddress.getName();
            } else {
                startEndName += pretAddress.getName();
            }
            route.setStartEndName(startEndName);
        }

        retVo.setPretServiceRouteItemList(serviceRouteItemList);
        retVo.setPretVender(pretVenderRepository.findById(venderId).get());
        return retVo;
    }

    /* *
     * 功能描述: 根据线路查询明细
     * 〈〉
     * @Param: [serviceRouteId, venderId]
     * @Return: com.pret.open.entity.vo.PretQuotationItemRVo
     * @Author: wujingsong
     * @Date: 2019/11/21  1:30 下午
     */
    @GetMapping(value = "/getByServiceRouteId/{serviceRouteId}/{venderId}")
    public PretQuotationItemRVo getByServiceRouteId(@PathVariable String serviceRouteId, @PathVariable String venderId) throws FebsException {
        PretQuotationItemRVo retVo = new PretQuotationItemRVo();
        PretServiceRoute pretServiceRoute = pretServiceRouteRepository.findById(serviceRouteId).get();
        if (!StringUtils.isEmpty(pretServiceRoute.getVenderId()) && !pretServiceRoute.getVenderId().equals(venderId)) {
            message = "该线路已经被其他供应商绑定";
            throw new FebsException(message);
        }

        List<PretServiceRouteItem> serviceRouteItemList = pretServiceRouteItemRepository.findByServiceRouteIdAndS(serviceRouteId, ConstantEnum.S.N.getLabel());

        for (PretServiceRouteItem route : serviceRouteItemList) {
            String startEndName = StringUtils.EMPTY;
            PretServiceRouteOrigin pretServiceRouteOrgin = pretServiceRouteOrginRepository.findById(route.getServiceRouteOriginId()).get();
            startEndName += pretServiceRouteOrgin.getName() + "-";
            PretAddress pretAddress = pretAddressRepository.findById(route.getAddressId()).get();
            if (pretAddress.getLevels() == ConstantEnum.AreaLevelEnum.区县.getLabel()) {
                PretAddress address = pretAddressRepository.findById(pretAddress.getParentId()).get();
                PretAddress a = pretAddressRepository.findById(address.getParentId()).get();
                startEndName += a.getName() + address.getName() + pretAddress.getName();
            } else if (pretAddress.getLevels() == ConstantEnum.AreaLevelEnum.市.getLabel()) {
                PretAddress address = pretAddressRepository.findById(pretAddress.getParentId()).get();
                startEndName += address.getName() + pretAddress.getName();
            } else {
                startEndName += pretAddress.getName();
            }
            route.setStartEndName(startEndName);
        }

        retVo.setPretServiceRouteItemList(serviceRouteItemList);
        retVo.setPretVender(pretVenderRepository.findById(venderId).get());
        return retVo;
    }
}