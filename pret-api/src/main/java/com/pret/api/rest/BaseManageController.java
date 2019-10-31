package com.pret.api.rest;

import com.pret.api.service.BaseManageService;
import com.pret.common.VersionedAuditableIdEntity;
import com.pret.common.annotation.Log;
import com.pret.common.exception.FebsException;
import com.pret.common.util.BeanUtilsExtended;
import com.wuwenze.poi.ExcelKit;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 基础Controller
 *
 * @param <Service>
 * @param <T>
 */
public class BaseManageController<Service extends BaseManageService, T extends VersionedAuditableIdEntity, D> {
    public String message;

    @Autowired
    protected Service service;

    @GetMapping
    public Map<String, Object> list(D request, T t) {
        Page<T> page = this.service.page(request);
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", page.getContent());
        rspData.put("total", page.getTotalElements());

        return rspData;
    }

    @Log("新增")
    @PostMapping
    public void add(@Valid T t) throws FebsException {
        try {
            this.service.save(t);
        } catch (Exception e) {
            message = "新增失败";
            throw new FebsException(message);
        }
    }

    @Log("删除")
    @DeleteMapping("/{ids}")
    public void deleteByIds(@PathVariable String ids) throws FebsException {
        try {
            this.service.deleteByIds(ids);
        } catch (Exception e) {
            message = "删除失败";
            throw new FebsException(message);
        }
    }

    @Log("修改")
    @PutMapping
    public void update(@Valid T t) throws FebsException {
        try {
            Optional<T> old = this.service.findById(t.getId());
            if (old.isPresent()) {
                BeanUtilsExtended.copyProperties(old.get(), t);
            }
            this.service.save(old.get());
        } catch (Exception e) {
            message = "修改失败";
            throw new FebsException(message);
        }
    }

    @PostMapping("excel")
    public void export(T t, D request, HttpServletResponse response) throws FebsException {
        try {
            List<T> list = this.service.page(request).getContent();
            if (list != null && list.size() > 0) {
                ExcelKit.$Export(t.getClass(), response).downXlsx(list, false);
            }
        } catch (Exception e) {
            message = "导出Excel失败";
            throw new FebsException(message);
        }
    }
}
