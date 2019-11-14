package com.pret.open.entity.vo;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * <p>Description: [pretmodel]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Data
public class PretQuotationItemRVo  {
    private String id;

    private List<Map> pretFeeTypeDataSource0;

    private List<Map> pretFeeTypeDataSource1;
}
