package com.pret.open.repository.user;


import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.user.User;

/**
 * <p>Description: [tRepository]</p>
 * Created on 2019年10月19日
 * @author  <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0 
 * Copyright (c) 2019年 极客城堡
 */
public interface UserRepository extends BaseRepository<User> {
    /* *
     * 功能描述: 根据手机号码查找
     * 〈〉
     * @Param: [mobile]
            * @Return: com.pret.open.entity.user.User
            * @Author: wujingsong
            * @Date: 2019/10/19  9:46 下午
     */
    User findByMobile(String mobile);

    /* *
     * 功能描述: 根据openid查找
     * 〈〉
     * @Param: [openid]
            * @Return: com.pret.open.entity.user.User
            * @Author: wujingsong
            * @Date: 2019/10/20  7:54 上午
     */
    User findByOpenid(String openid);
}
