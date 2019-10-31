package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.exception.FebsException;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.entity.PretTableItem;
import com.pret.open.entity.bo.PretTableBo;
import com.pret.open.entity.bo.PretTableItemBo;
import com.pret.open.entity.vo.PretTableItemVo;
import com.pret.open.repository.PretTableItemRepository;
import com.pret.open.service.PretTableItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("tableItem")
public class PretTableItemController extends BaseManageController<PretTableItemService, PretTableItem, PretTableItemVo> {
    @Autowired
    private PretTableItemRepository tableItemRepository;

    @Log("生成表格配置项")
    @PostMapping("/tableItemAdd")
    public void tableItemAdd(PretTableBo bo) throws FebsException {
        try {
            this.service.tableItemAdd(bo);
        } catch (Exception e) {
            message = "生成表格配置项失败";
            throw new FebsException(message);
        }
    }

    @GetMapping(value = "/getByModule/{module}")
    public List<PretTableItemBo> getByModule(@PathVariable String module) {
        List<PretTableItemBo> pretAddressBoList = new ArrayList<>();

        List<PretTableItem> tableItemList = tableItemRepository.findByModule(module);
        if (tableItemList != null && tableItemList.size() > 0) {
            for (PretTableItem tableItem : tableItemList) {
                PretTableItemBo itemBo = new PretTableItemBo();
                BeanUtilsExtended.copyProperties(itemBo, tableItem);
                pretAddressBoList.add(itemBo);
            }
        }


        return pretAddressBoList;
    }
}