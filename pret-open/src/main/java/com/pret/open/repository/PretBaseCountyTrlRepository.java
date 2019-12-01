package com.pret.open.repository;


import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretBaseCountyTrl;

/**
 * <p>Description: [pretRepository]</p>
 * Created on 2019年11月30日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public interface PretBaseCountyTrlRepository extends BaseRepository<PretBaseCountyTrl> {
    PretBaseCountyTrl findByIdAndSysmiflag(String id, String s);
}
