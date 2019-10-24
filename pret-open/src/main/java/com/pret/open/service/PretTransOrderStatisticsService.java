package com.pret.open.service;

import com.pret.api.service.impl.BaseServiceImpl;
import com.pret.open.entity.PretTransOrderStatistics;
import com.pret.open.entity.vo.PretTransOrderStatisticsVo;
import com.pret.open.repository.PretTransOrderStatisticsRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Description: [pret服务]
 * Created on 2019年09月15日
 * @author  <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0 
 * Copyright (c) 2019年 极客城堡
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class PretTransOrderStatisticsService extends BaseServiceImpl<PretTransOrderStatisticsRepository, PretTransOrderStatistics, PretTransOrderStatisticsVo>{
}
