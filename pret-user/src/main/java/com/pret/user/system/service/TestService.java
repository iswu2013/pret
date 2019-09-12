package com.pret.user.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pret.user.system.domain.Test;

import java.util.List;

public interface TestService extends IService<Test> {

    List<Test> findTests();

    /**
     * 批量插入
     * @param list List<Test>
     */
    void batchInsert(List<Test> list);
}
