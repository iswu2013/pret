package com.pret.open.vo.req;

import lombok.Data;

/**
 * @author wujingsong
 * @title: IndexStatisticsVo
 * @projectName pret
 * @description: 首页统计信息
 * @date 2019/10/246:56 下午
 */
@Data
public class IndexStatisticsVo {
    /**
     * 待提货配送任务
     */
    private long waitingPickUpCount;

    /**
     * 待处理异常
     */
    private long waitingHandleExcepitonCount;

    /**
     * 在途运输业务数量
     */
    private long onTheWayTransCount;

    /**
     * 未提货完成数
     */
    private long unFinishPickUpCount;
}
