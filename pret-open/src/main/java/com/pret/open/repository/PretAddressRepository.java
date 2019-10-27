package com.pret.open.repository;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretAddress;

import java.util.List;

/** 
 * <p>Description: [pretRepository]</p>
 * Created on 2019年09月15日
 * @author  <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0 
 * Copyright (c) 2019年 极客城堡
 */
public interface PretAddressRepository extends BaseRepository<PretAddress>{
    /* *
     * 功能描述: 根据级别查找
     * 〈〉
     * @Param: [levels]
            * @Return: java.util.List<com.pret.open.entity.PretAddress>
            * @Author: wujingsong
            * @Date: 2019/10/13  11:59 下午
     */
    List<PretAddress> findByLevels(Integer levels);

    /* *
     * 功能描述: 根据父id查找
     * 〈〉
     * @Param: [parentId]
            * @Return: java.util.List<com.pret.open.entity.PretAddress>
            * @Author: wujingsong
            * @Date: 2019/10/14  12:00 上午
     */
    List<PretAddress> findByParentId(String parentId);

    /* *
     * 功能描述: 根据级别和状态查询
     * 〈〉
     * @Param: [label, name]
            * @Return: java.util.List<com.pret.open.entity.PretAddress>
            * @Author: wujingsong
            * @Date: 2019/10/17  4:51 下午
     */
    List<PretAddress> findByLevelsAndS(int label, Integer s);

    /* *
     * 功能描述: 根据父id和状态查询
     * 〈〉
     * @Param: [id, name]
            * @Return: java.util.List<com.pret.open.entity.PretAddress>
            * @Author: wujingsong
            * @Date: 2019/10/17  4:53 下午
     */
    List<PretAddress> findByParentIdAndS(String id, Integer s);

    /* *
     * 功能描述: 根据levels和是否添加查找
     * 〈〉
     * @Param: [levels, add]
            * @Return: java.util.List<com.pret.open.entity.PretAddress>
            * @Author: wujingsong
            * @Date: 2019/10/23  6:39 下午
     */
    List<PretAddress> findByLevelsAndAdds(int levels,int adds);

    /* *
     * 功能描述: 根据父id，是否添加和状态查找
     * 〈〉
     * @Param: [id, adds, s]
            * @Return: java.util.List<com.pret.open.entity.PretAddress>
            * @Author: wujingsong
            * @Date: 2019/10/26  11:50 下午
     */
    List<PretAddress> findByParentIdAndAddsAndS(String id,Integer adds, Integer s);
}
