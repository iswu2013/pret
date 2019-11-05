package com.pret.open.entity.bo;

import com.pret.open.entity.PretPickUpPlan;
import com.pret.open.entity.PretTransException;
import com.pret.open.entity.PretTransOrder;
import com.pret.open.entity.PretTransPlan;
import com.pret.open.vo.req.IndexStatisticsVo;

import java.util.List;

/**
 * @author wujingsong
 * @title: PretStatisticsBo
 * @projectName pret
 * @description: TODO
 * @date 2019/11/47:09 上午
 */
public class PretStatisticsBo {
    private IndexStatisticsVo indexStatisticsVo;

    /* *
     * 功能描述: 待提货配送任务
     * 〈〉
     * @Param:
            * @Return:
            * @Author: wujingsong
            * @Date: 2019/11/4  7:12 上午
     */
    private List<PretTransOrder> waitingPickUpList;

    /* *
     * 功能描述: 待处理异常
     * 〈〉
     * @Param:
            * @Return:
            * @Author: wujingsong
            * @Date: 2019/11/4  7:12 上午
     */
    private List<PretTransException> waitingHandleExcepitonList;

    /* *
     * 功能描述: 在途运输业务
     * 〈〉
     * @Param:
            * @Return:
            * @Author: wujingsong
            * @Date: 2019/11/4  7:13 上午
     */
    private List<PretTransPlan> onTheWayTransList;

    /* *
     * 功能描述: 未提货完成数
     * 〈〉
     * @Param:
            * @Return:
            * @Author: wujingsong
            * @Date: 2019/11/4  7:14 上午
     */
    private List<PretPickUpPlan> unFinishPickUpList;

    public IndexStatisticsVo getIndexStatisticsVo() {
        return indexStatisticsVo;
    }

    public void setIndexStatisticsVo(IndexStatisticsVo indexStatisticsVo) {
        this.indexStatisticsVo = indexStatisticsVo;
    }

    public List<PretTransOrder> getWaitingPickUpList() {
        return waitingPickUpList;
    }

    public void setWaitingPickUpList(List<PretTransOrder> waitingPickUpList) {
        this.waitingPickUpList = waitingPickUpList;
    }

    public List<PretTransException> getWaitingHandleExcepitonList() {
        return waitingHandleExcepitonList;
    }

    public void setWaitingHandleExcepitonList(List<PretTransException> waitingHandleExcepitonList) {
        this.waitingHandleExcepitonList = waitingHandleExcepitonList;
    }

    public List<PretTransPlan> getOnTheWayTransList() {
        return onTheWayTransList;
    }

    public void setOnTheWayTransList(List<PretTransPlan> onTheWayTransList) {
        this.onTheWayTransList = onTheWayTransList;
    }

    public List<PretPickUpPlan> getUnFinishPickUpList() {
        return unFinishPickUpList;
    }

    public void setUnFinishPickUpList(List<PretPickUpPlan> unFinishPickUpList) {
        this.unFinishPickUpList = unFinishPickUpList;
    }
}
