package com.pret.open.vo.res;

import com.pret.api.vo.ResBody;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 获取销售员运输计划
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Data
public class PR8000009Vo extends ResBody {
    private List<PR8000009ItemVo> itemVoList = new ArrayList<>();
}
