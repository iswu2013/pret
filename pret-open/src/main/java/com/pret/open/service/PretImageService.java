package com.pret.open.service;

import com.pret.api.service.impl.BaseServiceImpl;
import com.pret.open.entity.PretImage;
import com.pret.open.entity.vo.PretImageVo;
import com.pret.open.repository.PretImageRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Description: [pluto服务]
 * Created on 2019年10月03日
 * @author  <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0 
 * Copyright (c) 2019年 极客城堡
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class PretImageService extends BaseServiceImpl<PretImageRepository, PretImage, PretImageVo> {
}
