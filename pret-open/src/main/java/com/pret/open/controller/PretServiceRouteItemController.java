package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.PretAddress;
import com.pret.open.entity.PretServiceRouteItem;
import com.pret.open.entity.PretServiceRouteOrigin;
import com.pret.open.entity.PretVender;
import com.pret.open.entity.bo.AreaBo;
import com.pret.open.entity.vo.PretServiceRouteItemVo;
import com.pret.open.repository.PretAddressRepository;
import com.pret.open.repository.PretServiceRouteItemRepository;
import com.pret.open.repository.PretServiceRouteOriginRepository;
import com.pret.open.repository.PretVenderRepository;
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
        for (PretServiceRouteItem item : serviceRouteItemList) {
            if (!StringUtils.isEmpty(item.getVenderId())) {
                PretVender pretVender = pretVenderRepository.findById(item.getVenderId()).get();
                if (pretVender.getType() > 0) {
                    if (pretVender.getType() == request.getType()) {
                        pretVenderList.add(pretVender);
                    }
                } else {
                    pretVenderList.add(pretVender);
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
    @GetMapping(value = "/getByVenderIsNull/{venderId}")
    public List<PretServiceRouteItem> getByVenderIsNull(@PathVariable String venderId) {
        String where = " where 1=1 and (a.vender_id is NULL or a.vender_id = '" + venderId + "') and a.s = 1 order by service_route_origin_id Desc ";
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
        return serviceRouteItemList;
    }
}