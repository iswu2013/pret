package com.pret.open.controller;

import com.google.common.reflect.TypeToken;
import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.constant.CommonConstants;
import com.pret.common.exception.FebsException;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.entity.PretTableItem;
import com.pret.open.entity.PretUserTableConfig;
import com.pret.open.entity.bo.PretTableItemBo;
import com.pret.open.entity.bo.PretUserTableConfigBo;
import com.pret.open.entity.bo.PretUserTableConfigWithItems;
import com.pret.open.entity.vo.PretUserTableConfigVo;
import com.pret.open.repository.PretTableItemRepository;
import com.pret.open.repository.PretUserTableConfigRepository;
import com.pret.open.service.PretUserTableConfigService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("userTableConfig")
public class PretUserTableConfigController extends BaseManageController<PretUserTableConfigService, PretUserTableConfig, PretUserTableConfigVo> {
    @Autowired
    private PretUserTableConfigRepository userTableConfigRepository;
    @Autowired
    private PretTableItemRepository tableItemRepository;

    /* *
     * 功能描述: 获取用户配置
     * 〈〉
     * @Param: [userId, module]
     * @Return: com.pluto.api.entity.UserTableConfig
     * @Author: wujingsong
     * @Date: 2019/10/30  7:50 下午
     */
    @GetMapping(value = "/getByUserAndModule/{userId}/{module}")
    public List<PretTableItemBo> getByModule(@PathVariable String userId, @PathVariable String module) {
        PretUserTableConfig userTableConfig = userTableConfigRepository.findByUserIdAndModule(userId, module);
        List<PretTableItemBo> list = CommonConstants.GSON.fromJson(userTableConfig.getConfigInfo(),
                new TypeToken<List<PretTableItemBo>>() {
                }.getType());

        return list;
    }


    /* *
     * 功能描述: 设置用户配置
     * 〈〉
     * @Param: [bo]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/10/30  7:50 下午
     */
    @Log("设置用户表格配置")
    @PostMapping("/userTableConfigAdd")
    public void tableItemAdd(PretUserTableConfigBo bo) throws FebsException {
        try {
            this.service.userTableConfigAdd(bo);
        } catch (Exception e) {
            message = "设置用户表格配置失败";
            throw new FebsException(message);
        }
    }

    @GetMapping(value = "/getByUserAndModuleWithItems/{userId}/{module}")
    public PretUserTableConfigWithItems getByUserAndModuleWithItems(@PathVariable String userId, @PathVariable String module) {
        PretUserTableConfigWithItems userTableConfigWithItems = new PretUserTableConfigWithItems();

        List<PretTableItemBo> tableItemBoList = new ArrayList<>();

        List<PretTableItem> tableItemList = tableItemRepository.findByModule(module);
        if (tableItemList != null && tableItemList.size() > 0) {
            for (PretTableItem tableItem : tableItemList) {
                PretTableItemBo itemBo = new PretTableItemBo();
                BeanUtilsExtended.copyProperties(itemBo, tableItem);
                itemBo.setValue(tableItem.getId());
                itemBo.setLabel(tableItem.getTitle());
                itemBo.setDataIndex(tableItem.getDataIndex());
                itemBo.setTitle(tableItem.getTitle());
                tableItemBoList.add(itemBo);
            }
        }

        userTableConfigWithItems.setItems(tableItemBoList);

        PretUserTableConfig userTableConfig = userTableConfigRepository.findByUserIdAndModule(userId, module);
        if (userTableConfig != null && !StringUtils.isEmpty(userTableConfig.getConfigInfo())) {
            List<String> list = CommonConstants.GSON.fromJson(userTableConfig.getConfigInfo(),
                    new TypeToken<List<String>>() {
                    }.getType());
            if (tableItemBoList.size() == list.size()) {
                userTableConfigWithItems.setCheckAll(true);
            }
            if (list.size() > 0) {
                userTableConfigWithItems.setIndeterminate(true);
            }
            userTableConfigWithItems.setSelectItems(list);
        }

        return userTableConfigWithItems;
    }
}