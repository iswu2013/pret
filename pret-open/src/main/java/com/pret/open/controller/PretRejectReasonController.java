package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.open.entity.PretRejectReason;
import com.pret.open.entity.vo.PretRejectReasonVo;
import com.pret.open.service.PretRejectReasonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 拒绝原因
 */
@Slf4j
@Validated
@RestController
@RequestMapping("pretRejectReason")
public class PretRejectReasonController extends BaseManageController<PretRejectReasonService, PretRejectReason, PretRejectReasonVo> {
}