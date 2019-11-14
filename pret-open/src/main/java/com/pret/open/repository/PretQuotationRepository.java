package com.pret.open.repository;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretQuotation;

/**
 * <p>Description: [pretRepository]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public interface PretQuotationRepository extends BaseRepository<PretQuotation> {
    /* *
     * 功能描述: 根据供应商和状态查找
     * 〈〉
     * @Param: [venderId, s]
     * @Return: com.pret.open.entity.PretQuotation
     * @Author: wujingsong
     * @Date: 2019/11/14  1:50 上午
     */
    PretQuotation findByVenderIdAndS(String venderId, Integer s);
}
