package com.pret.open.vo.res;

import com.pret.api.vo.ResBody;
import com.pret.open.entity.PretTransRecord;
import com.pret.open.entity.PretTransTrajectory;
import com.pret.open.entity.bo.PretSteps;
import lombok.Data;

import java.util.List;

/**
 * Description: 获取用户运输计划详情
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Data
public class PR8000003Vo extends ResBody {
    private List<PretTransRecord> transRecordList;

    private List<PretSteps> stepsList;
}
