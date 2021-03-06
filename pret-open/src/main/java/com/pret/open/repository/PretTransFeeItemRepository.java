package com.pret.open.repository;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretTransFeeItem;

import java.util.List;

/**
 * <p>Description: [pretRepository]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public interface PretTransFeeItemRepository extends BaseRepository<PretTransFeeItem> {
    /* *
     * 功能描述: 根据transFeeId和状态查找
     * 〈〉
     * @Param: [transFeeId, s]
     * @Return: java.util.List<com.pret.open.entity.PretTransFeeItem>
     * @Author: wujingsong
     * @Date: 2019/11/28  8:54 下午
     */
    List<PretTransFeeItem> findByTransFeeIdAndS(String transFeeId, Integer s);

    /* *
     * 功能描述: <br>
     * 〈〉
     * @Param: [transFeeId, feeTypeId, s]
     * @Return: java.util.List<com.pret.open.entity.PretTransFeeItem>
     * @Author: wujingsong
     * @Date: 2019/12/16  7:18 下午
     */
    List<PretTransFeeItem> findByTransFeeIdAndFeeTypeIdAndS(String transFeeId, String feeTypeId, Integer s);

    /* *
     * 功能描述: <br>
     * 〈〉
     * @Param: [transFeeId, feeTypeId, s]
            * @Return: java.util.List<com.pret.open.entity.PretTransFeeItem>
            * @Author: wujingsong
            * @Date: 2019/12/16  7:40 下午
     */
    List<PretTransFeeItem> findByTransFeeIdAndFeeTypeIdNotAndS(String transFeeId, String feeTypeId, Integer s);

    /* *
     * 功能描述: <br>
     * 〈〉
     * @Param: [calType, idList, s]
     * @Return: java.util.List<com.pret.open.entity.PretTransFeeItem>
     * @Author: wujingsong
     * @Date: 2019/11/29  5:47 上午
     */
    List<PretTransFeeItem> findByCalTypeAndIdNotInAndS(Integer calType, List<String> idList, Integer s);

    List<PretTransFeeItem> findByCalTypeAndIdInAndS(Integer calType, List<String> idList, Integer s);

    List<PretTransFeeItem> findByCalTypeAndS(Integer calType, Integer s);

    /* *
     * 功能描述: <br>
     * 〈〉
     * @Param: [exceptionFee, idList, s]
     * @Return: java.util.List<com.pret.open.entity.PretTransFeeItem>
     * @Author: wujingsong
     * @Date: 2019/12/13  7:29 上午
     */
    List<PretTransFeeItem> findByExceptionFeeAndIdNotInAndS(Integer exceptionFee, List<String> idList, Integer s);

    List<PretTransFeeItem> findByExceptionFeeAndS(Integer exceptionFee, Integer s);
}
