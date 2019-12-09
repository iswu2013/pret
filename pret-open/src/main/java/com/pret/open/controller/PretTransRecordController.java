package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.PretTransFeeItem;
import com.pret.open.entity.PretTransRecord;
import com.pret.open.entity.vo.PretTransFeeItemVo;
import com.pret.open.entity.vo.PretTransRecordVo;
import com.pret.open.service.PretTransFeeItemService;
import com.pret.open.service.PretTransRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequestMapping("pretTransRecord")
public class PretTransRecordController extends BaseManageController<PretTransRecordService, PretTransRecord, PretTransRecordVo> {

    /* *
     * 功能描述: 查看
     * 〈〉
     * @Param: [id]
     * @Return: com.pret.open.entity.PretTransRecord
     * @Author: wujingsong
     * @Date: 2019/12/9  2:05 下午
     */
    @Log("查看")
    @PostMapping("/view/{id}")
    public PretTransRecord view(@PathVariable String id) throws FebsException {
        try {
            PretTransRecord item = this.service.findById(id).get();
            return item;
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
    }
}