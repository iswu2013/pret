package com.pret.open.repository;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretMemberAuth;
import com.pret.open.entity.PretRoute;

import java.util.List;

/**
 * <p>Description: [pretRepository]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public interface PretMemberAuthRepository extends BaseRepository<PretMemberAuth> {
    PretMemberAuth findByOpenidAndS(String openid,Integer s);
}
