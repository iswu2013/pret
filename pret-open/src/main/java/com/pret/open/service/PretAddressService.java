package com.pret.open.service;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.entity.PretAddress;
import com.pret.open.entity.vo.PretAddressVo;
import com.pret.open.vo.req.*;
import com.pret.open.repository.PretAddressRepository;
import com.pret.api.service.impl.BaseServiceImpl;
import org.springframework.data.domain.Page;
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
public class PretAddressService extends BaseServiceImpl<PretAddressRepository, PretAddress, PretAddressVo>{
}
