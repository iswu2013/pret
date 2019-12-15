package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.PretTransFeeRecord;
import com.pret.open.entity.vo.PretTransFeeRecordVo;
import com.pret.open.repository.PretTransFeeRecordRepository;
import com.pret.open.service.PretTransFeeRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("pretTransFeeRecord")
public class PretTransFeeRecordController extends BaseManageController<PretTransFeeRecordService, PretTransFeeRecord, PretTransFeeRecordVo> {
    @Autowired
    private PretTransFeeRecordRepository pretTransFeeRecordRepository;

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
    public PretTransFeeRecord view(@PathVariable String id) throws FebsException {
        try {
            PretTransFeeRecord item = this.service.findById(id).get();
            return item;
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
    }

    @Log("查看")
    @PostMapping("/viewByTransFeeId/{id}")
    public List<PretTransFeeRecord> viewByTransFeeId(@PathVariable String id) throws FebsException {
        try {
            List<PretTransFeeRecord> item = pretTransFeeRecordRepository.findByTransFeeIdAndSOrderByLastModifiedDateDesc(id, ConstantEnum.S.N.getLabel());
            return item;
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
    }
}