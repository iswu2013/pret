package com.pret.api.rest;

import com.pret.api.service.BaseManageService;
import com.pret.common.VersionedAuditableIdEntity;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.context.BaseContextHandler;
import com.pret.common.msg.ObjectRestResponse;
import com.pret.common.msg.TableResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * @author wujingsong
 * @title: IController
 * @projectName pret
 * @description: TODO
 * @date 2019/9/155:40 下午
 */
public class IController<Service extends BaseManageService, T extends VersionedAuditableIdEntity, D>{
    @Autowired
    private HttpServletRequest request;
    @Autowired
    protected Service service;

    /**
     * 增加或保存
     *
     * @param t
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public ObjectRestResponse<T> add(@RequestBody T t) {
        service.save(t);

        return new ObjectRestResponse<T>();
    }

    /**
     * 根据Id查找
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse<T> get(@PathVariable String id) {
        ObjectRestResponse<T> res = new ObjectRestResponse<>();

        Optional<T> t = service.findById(id);
        res.data(t.get());

        return res;
    }

    /**
     * 保存
     *
     * @param entity
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ObjectRestResponse<T> update(@RequestBody T entity) {
//        Optional<T> t = this.service.findById(entity.getId());
//        BeanUtilsExtended.copyProperties(t.get(), entity);
//        service.save(t.get());
//        return new ObjectRestResponse<T>();

        return null;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ObjectRestResponse<T> delete(@PathVariable String id) {
        service.lDelete(id);

        return new ObjectRestResponse<T>();
    }

    /**
     * 查找全部
     *
     * @return
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<T> all() {
        return service.findByS(ConstantEnum.S.N.name());
    }

    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<T> page(@RequestBody D vo) {
        Page<T> page = service.page(vo);

        return new TableResultResponse<>(page.getTotalElements(), page.getContent());
    }

    /**
     * 获取当前登录用户
     *
     * @return
     */
    public String getCurrentUserName() {
        return BaseContextHandler.getUsername();
    }
}
