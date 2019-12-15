package com.pret.open.service;

import com.pret.api.service.impl.BaseServiceImpl;
import com.pret.open.entity.PretTransFeeRecord;
import com.pret.open.entity.vo.PretTransFeeRecordVo;
import com.pret.open.repository.PretTransFeeRecordRepository;
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
public class PretTransFeeRecordService extends BaseServiceImpl<PretTransFeeRecordRepository, PretTransFeeRecord, PretTransFeeRecordVo> {
}
