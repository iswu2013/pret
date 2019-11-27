package com.pret.open.repository;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretCustomer;

/**
 * <p>Description: [pretRepository]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public interface PretCustomerRepository extends BaseRepository<PretCustomer> {
    /* *
     * 功能描述: 根据openid查找
     * 〈〉
     * @Param: [openid]
     * @Return: com.pret.open.entity.PretCustomer
     * @Author: wujingsong
     * @Date: 2019/10/18  10:45 下午
     */
    PretCustomer findByOpenidAndS(String openid, Integer s);

    /* *
     * 功能描述: <br>
     * 〈〉
     * @Param: [linkPhone]
     * @Return: com.pret.open.entity.PretCustomer
     * @Author: wujingsong
     * @Date: 2019/10/19  9:58 下午
     */
    PretCustomer findByLinkPhoneAndS(String linkPhone, Integer s);

    /* *
     * 功能描述: 根据Code查找
     * 〈〉
     * @Param: [code]
     * @Return: com.pret.open.entity.PretCustomer
     * @Author: wujingsong
     * @Date: 2019/11/27  11:43 上午
     */
    PretCustomer findByCodeAndS(String code, Integer s);
}
