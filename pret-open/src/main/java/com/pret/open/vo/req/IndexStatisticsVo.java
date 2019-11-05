package com.pret.open.vo.req;

/**
 * @author wujingsong
 * @title: IndexStatisticsVo
 * @projectName pret
 * @description: 首页统计信息
 * @date 2019/10/246:56 下午
 */
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

    public long getWaitingPickUpCount() {
        return waitingPickUpCount;
    }

    public void setWaitingPickUpCount(long waitingPickUpCount) {
        this.waitingPickUpCount = waitingPickUpCount;
    }

    public long getWaitingHandleExcepitonCount() {
        return waitingHandleExcepitonCount;
    }

    public void setWaitingHandleExcepitonCount(long waitingHandleExcepitonCount) {
        this.waitingHandleExcepitonCount = waitingHandleExcepitonCount;
    }

    public long getOnTheWayTransCount() {
        return onTheWayTransCount;
    }

    public void setOnTheWayTransCount(long onTheWayTransCount) {
        this.onTheWayTransCount = onTheWayTransCount;
    }

    public long getUnFinishPickUpCount() {
        return unFinishPickUpCount;
    }

    public void setUnFinishPickUpCount(long unFinishPickUpCount) {
        this.unFinishPickUpCount = unFinishPickUpCount;
    }
}
