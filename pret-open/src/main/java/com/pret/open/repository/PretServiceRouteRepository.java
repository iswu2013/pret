package com.pret.open.repository;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretServiceRoute;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * <p>Description: [pretRepository]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public interface PretServiceRouteRepository extends BaseRepository<PretServiceRoute> {
    /* *
     * 功能描述: <br>
     * 〈〉
     * @Param: [venderId]
     * @Return: java.util.List<com.pret.open.entity.PretServiceRoute>
     * @Author: wujingsong
     * @Date: 2019/11/21  1:44 下午
     */
    @Query(value = "select * from pret_service_route where (vender_id=:venderId OR vender_id IS NULL) AND s=1 ", nativeQuery = true)
    List<PretServiceRoute> findByVenderIdOrVenderIdIsNull(String venderId);
}
