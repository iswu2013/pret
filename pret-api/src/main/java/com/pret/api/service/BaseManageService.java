package com.pret.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.Optional;

/**
 * 基础Service
 *
 * @param <T>
 */
public interface BaseManageService<T, D> {

    /**
     * 单个增加
     *
     * @param entity
     * @return
     */
    T save(T entity);


    /**
     * 批量增加
     */
    Iterable<T> save(Iterable<T> entities);

    /**
     * 单个删除
     *
     * @param id
     */
    void delete(String id);

    /**
     * 逻辑删除
     *
     * @param id
     */
    void lDelete(String id);

    /**
     * 单个删除
     *
     * @param entity
     */
    void delete(T entity);

    /**
     * 批量删除
     *
     * @param entities
     */
    void delete(Iterable<T> entities);

    /**
     * 删除全部
     */
    void deleteAll();

    /**
     * @param id
     * @return
     */
    Optional<T> findById(String id);

    /**
     * 查询全部
     *
     * @return
     */
    Iterable<T> findAll();

    /**
     * 根据s查询
     *
     * @param s
     * @return
     */
    Iterable<T> findByS(String s);

    /**
     * 查询全部
     *
     * @param ids
     * @return
     */
    Iterable<T> findAll(Iterable<String> ids);

    /**
     * 查询全部
     *
     * @param sort
     * @return
     */
    Iterable<T> findAll(Sort sort);

    /**
     * 分页查询
     *
     * @param D
     * @return
     */
    Page<T> page(final D vo);

}
