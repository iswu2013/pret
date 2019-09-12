package com.pret.api.statistics;

/**
 * 标识和标识引用统计信息
 */
public class MQStatisticsInfoRes {
    /**
     * 是否收藏
     */
    private boolean isLikes;

    /**
     * 是否投诉
     */
    private boolean isComplaint;

    public boolean isLikes() {
        return isLikes;
    }

    public void setLikes(boolean likes) {
        isLikes = likes;
    }

    public boolean isComplaint() {
        return isComplaint;
    }

    public void setComplaint(boolean complaint) {
        isComplaint = complaint;
    }
}