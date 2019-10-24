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
    private int waitingPickUpCount;

    /**
     * 待处理异常
     */
    private int waitingHandleExcepitonCount;

    /**
     * 在途运输业务数量
     */
    private int onTheWayTransCount;

    /**
     * 未提货完成数
     */
    private int unFinishPickUpCount;

    public int getWaitingPickUpCount() {
        return waitingPickUpCount;
    }

    public void setWaitingPickUpCount(int waitingPickUpCount) {
        this.waitingPickUpCount = waitingPickUpCount;
    }

    public int getWaitingHandleExcepitonCount() {
        return waitingHandleExcepitonCount;
    }

    public void setWaitingHandleExcepitonCount(int waitingHandleExcepitonCount) {
        this.waitingHandleExcepitonCount = waitingHandleExcepitonCount;
    }

    public int getOnTheWayTransCount() {
        return onTheWayTransCount;
    }

    public void setOnTheWayTransCount(int onTheWayTransCount) {
        this.onTheWayTransCount = onTheWayTransCount;
    }

    public int getUnFinishPickUpCount() {
        return unFinishPickUpCount;
    }

    public void setUnFinishPickUpCount(int unFinishPickUpCount) {
        this.unFinishPickUpCount = unFinishPickUpCount;
    }
}
