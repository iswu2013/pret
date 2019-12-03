package com.pret.open.vo.req;

import com.pret.api.vo.ReqBody;
import lombok.Data;

/**
 * Description: 绑定用户
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Data
public class P1000004Vo extends ReqBody {
    private String phone;

    /**
     * 用户类型
     */
    private Integer type;

    private String openId;
}
