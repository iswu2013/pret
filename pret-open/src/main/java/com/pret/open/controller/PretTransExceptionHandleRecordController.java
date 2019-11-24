package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.open.entity.PretTransExceptionHandleRecord;
import com.pret.open.entity.vo.PretTransExceptionHandleRecordVo;
import com.pret.open.service.PretTransExceptionHandleRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequestMapping("pretTransExceptionHandleRecord")
public class PretTransExceptionHandleRecordController extends BaseManageController<PretTransExceptionHandleRecordService, PretTransExceptionHandleRecord, PretTransExceptionHandleRecordVo> {
}