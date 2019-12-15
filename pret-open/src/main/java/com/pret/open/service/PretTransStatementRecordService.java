package com.pret.open.service;

import com.pret.api.service.impl.BaseServiceImpl;
import com.pret.open.entity.PretTransStatement;
import com.pret.open.entity.PretTransStatementRecord;
import com.pret.open.entity.vo.PretTransStatementRecordVo;
import com.pret.open.repository.PretTransStatementRecordRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Description: [pret服务]
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class PretTransStatementRecordService extends BaseServiceImpl<PretTransStatementRecordRepository, PretTransStatementRecord, PretTransStatementRecordVo> {
}
