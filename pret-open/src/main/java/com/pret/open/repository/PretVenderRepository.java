package com.pret.open.repository;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretVender;

/**
 * <p>Description: [pretRepository]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public interface PretVenderRepository extends BaseRepository<PretVender> {
    /* *
     * 功能描述: 查找最前面的10个供应商
     * 〈〉
     * @Param: []
     * @Return: com.pret.open.entity.PretVender
     * @Author: wujingsong
     * @Date: 2019/11/14  1:08 下午
     */
    PretVender findTop1ByOrderByCreateTimeLongDesc();

    /**
     * 根据code查询供应商
     *
     * @param code
     * @param s
     * @return
     */
    PretVender findByCodeAndS(String code, Integer s);

    /* *
     * 功能描述: 根据联系号码和状态查询
     * 〈〉
     * @Param: [linkPhone, s]
     * @Return: com.pret.open.entity.PretVender
     * @Author: wujingsong
     * @Date: 2019/11/14  5:03 下午
     */
    PretVender findByLinkPhoneAndS(String linkPhone, Integer s);
}
