package com.pret.open.controller;

import com.pret.open.repository.PretAddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 统计管理
 */
@Slf4j
@Validated
@RestController
@RequestMapping("statistics")
public class PretStatisticsController {
    @Autowired
    private PretAddressRepository pretAddressRepository;
}