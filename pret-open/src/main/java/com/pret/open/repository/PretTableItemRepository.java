package com.pret.open.repository;


import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretTableItem;

import java.util.List;

/**
 * <p>Description: [plutoRepository]</p>
 * Created on 2019年10月03日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public interface PretTableItemRepository extends BaseRepository<PretTableItem> {
    /* *
     * 功能描述: <br>
     * 〈〉
     * @Param: [module]
     * @Return: java.util.List<com.pluto.api.entity.TableItem>
     * @Author: wujingsong
     * @Date: 2019/10/30  2:01 下午
     */
    List<PretTableItem> findByModule(String module);
}
