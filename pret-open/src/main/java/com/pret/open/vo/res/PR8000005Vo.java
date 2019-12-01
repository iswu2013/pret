package com.pret.open.vo.res;

import com.pret.api.vo.ResBody;
import lombok.Data;

/**
 * Description: 获取司机详情
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Data
public class PR8000005Vo extends ResBody {
    private String openId;
    private String sessionKey;
    private String unionId;
}
