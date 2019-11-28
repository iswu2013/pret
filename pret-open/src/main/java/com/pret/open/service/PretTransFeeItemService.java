package com.pret.open.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.constant.Constants;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.common.util.NoUtil;
import com.pret.common.util.StringUtil;
import com.pret.open.entity.PretTransFee;
import com.pret.open.entity.PretTransFeeItem;
import com.pret.open.entity.vo.PretTransFeeItemVo;
import com.pret.open.vo.req.*;
import com.pret.open.repository.PretTransFeeItemRepository;
import com.pret.api.service.impl.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.data.domain.Page;
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
public class PretTransFeeItemService extends BaseServiceImpl<PretTransFeeItemRepository, PretTransFeeItem, PretTransFeeItemVo> {
}
