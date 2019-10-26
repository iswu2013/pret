package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.PretServiceRouteItem;
import com.pret.open.entity.vo.PretServiceRouteItemVo;
import com.pret.open.repository.PretServiceRouteItemRepository;
import com.pret.open.service.PretServiceRouteItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("pretServiceRouteItem")
public class PretServiceRouteItemController extends BaseManageController<PretServiceRouteItemService, PretServiceRouteItem, PretServiceRouteItemVo> {
    @Autowired
    private PretServiceRouteItemRepository pretServiceRouteItemRepository;

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
        List<PretServiceRouteItem> serviceRouteItemList = pretServiceRouteItemRepository.findByServiceLineId(id);

        return serviceRouteItemList;
    }
}