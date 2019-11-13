package com.pret.open.entity.vo;

import com.pret.api.vo.PageFormVo;
import lombok.Data;

import java.io.Serializable;

/**
 * @author wujingsong
 * @title: PretTransOrderStatisticsVo
 * @projectName pret
 * @description: TODO
 * @date 2019/10/247:35 下午
 */
@Data
public class PretTransOrderStatisticsVo extends PageFormVo implements Serializable {
    private long bw$createTimeLong;
    private long createTimeLongEnd;
}
