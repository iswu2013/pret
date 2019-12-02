package com.pret.open.repository.user;


import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.user.User;

import java.util.List;

/**
 * <p>Description: [tRepository]</p>
 * Created on 2019年10月19日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
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

    /* *
     * 功能描述: 根据openid和状态s查询
     * 〈〉
     * @Param: [openid, s]
     * @Return: com.pret.open.entity.user.User
     * @Author: wujingsong
     * @Date: 2019/12/1  11:13 下午
     */
    User findByOpenidAndS(String openid, Integer s);

    /* *
     * 功能描述: <br>
     * 〈〉
     * @Param: [userType, s]
     * @Return: com.pret.open.entity.user.User
     * @Author: wujingsong
     * @Date: 2019/12/2  5:44 上午
     */
    List<User> findByUserTypeAndS(Integer userType, Integer s);

    /* *
     * 功能描述: <br>
     * 〈〉
     * @Param: [mobile, userType, s]
     * @Return: com.pret.open.entity.user.User
     * @Author: wujingsong
     * @Date: 2019/12/2  7:00 上午
     */
    User findByMobileAndUserTypeAndS(String mobile, Integer userType, Integer s);


    /* *
     * 功能描述: 根据openid用户类别状态查询
     * 〈〉
     * @Param: [openid, userType, s]
     * @Return: com.pret.open.entity.user.User
     * @Author: wujingsong
     * @Date: 2019/12/2  7:02 上午
     */
    User findByOpenidAndUserTypeAndS(String openid, Integer userType, Integer s);

    User findByMobileAndS(String mobile, Integer s);
}
