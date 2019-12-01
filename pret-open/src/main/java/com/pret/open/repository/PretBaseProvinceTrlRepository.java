package com.pret.open.repository;


import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretBaseCountyTrl;
import com.pret.open.entity.PretBaseProvince;
import com.pret.open.entity.PretBaseProvinceTrl;

/**
 * <p>Description: [pretRepository]</p>
 * Created on 2019年11月30日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public interface PretBaseProvinceTrlRepository extends BaseRepository<PretBaseProvinceTrl> {
    /* *
     * 功能描述: <br>
     * 〈〉
     * @Param: [id, flag]
            * @Return: com.pret.open.entity.PretBaseCountyTrl
            * @Author: wujingsong
            * @Date: 2019/11/30  7:30 下午
     */
    PretBaseProvinceTrl findByIdAndSysmiflag(String id,String flag);
}
