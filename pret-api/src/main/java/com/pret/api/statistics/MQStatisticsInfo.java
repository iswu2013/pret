package com.pret.api.statistics;

/**
 * 标识和标识引用统计信息
 */
public class MQStatisticsInfo {
    /**
     * 对象
     */
    private Long id;

    /**
     * 用户Id
     */
    private Long userId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
