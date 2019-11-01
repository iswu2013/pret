package com.pret.open.repository;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretPickUpAddress;

import java.util.List;

/** 
 * <p>Description: [pretRepository]</p>
 * Created on 2019年09月15日
 * @author  <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0 
 * Copyright (c) 2019年 极客城堡
 */
public interface PretPickUpAddressRepository extends BaseRepository<PretPickUpAddress>{
    /* *
     * 功能描述: 根据idList查找
     * 〈〉
     * @Param: [idList]
            * @Return: java.util.List<com.pret.open.entity.PretPickUpAddress>
            * @Author: wujingsong
            * @Date: 2019/11/1  5:42 下午
     */
    List<PretPickUpAddress> findByIdIn(List<String> idList);
}
