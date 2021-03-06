package com.pret.open.entity.vo.user;

import com.pret.api.vo.PageFormVo;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description: [tmodel]</p>
 * Created on 2019年10月19日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Data
public class UserVo extends PageFormVo implements Serializable {
    private String ll$namell$username;
    private int eq$userType = -1;
    private String eq$id;
}
