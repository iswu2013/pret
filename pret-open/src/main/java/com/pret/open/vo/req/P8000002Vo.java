package com.pret.open.vo.req;

import com.pret.api.vo.PageFormVo;
import com.pret.api.vo.ReqBody;
import lombok.Data;

import java.util.List;

/**
 * Description: 获取用户运输计划
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Data
public class P8000002Vo extends ReqBody {
    private String openid;
    private Integer page;
    private Integer rows = 10;
    private int eq$status = -1;
    private int searchType = -1;
}
