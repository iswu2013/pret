package com.pret.open.repository;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretDriver;

/**
 * <p>Description: [pretRepository]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public interface PretDriverRepository extends BaseRepository<PretDriver> {
    /* *
     * 功能描述: 根据openid查找
     * 〈〉
     * @Param: [openid]
     * @Return: com.pret.open.entity.PretDriver
     * @Author: wujingsong
     * @Date: 2019/10/18  9:56 下午
     */
    PretDriver findByOpenidAndS(String openid, Integer s);

    /* *
     * 功能描述: 根据车牌号和手机号码查找
     * 〈〉
     * @Param: [cardNumber, phone, s]
     * @Return: com.pret.open.entity.PretDriver
     * @Author: wujingsong
     * @Date: 2019/11/22  6:55 上午
     */
    PretDriver findByCarNumberAndPhoneAndS(String cardNumber, String phone, Integer s);

    /* *
     * 功能描述: 根据手机号码查找
     * 〈〉
     * @Param: [phone, s]
     * @Return: com.pret.open.entity.PretDriver
     * @Author: wujingsong
     * @Date: 2019/12/3  7:40 上午
     */
    PretDriver findByPhoneAndS(String phone, Integer s);
}
