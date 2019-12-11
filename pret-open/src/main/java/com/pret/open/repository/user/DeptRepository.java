package com.pret.open.repository.user;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.user.Dept;
import com.pret.open.entity.user.Role;

import java.util.List;

/**
 * <p>Description: [tRepository]</p>
 * Created on 2019年10月19日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public interface DeptRepository extends BaseRepository<Dept> {
    Dept findByU9codeAndS(String u9code,Integer s);

    List<Dept> findByParentIdAndS(String parendId,Integer s);

    List<Dept> findByS(Integer s);
}
