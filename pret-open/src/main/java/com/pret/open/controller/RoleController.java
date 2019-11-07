package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.PretBillingInterval;
import com.pret.open.entity.PretBillingIntervalItem;
import com.pret.open.entity.PretFeeType;
import com.pret.open.entity.user.Role;
import com.pret.open.entity.vo.PretFeeTypeVo;
import com.pret.open.entity.vo.user.RoleVo;
import com.pret.open.repository.user.RoleRepository;
import com.pret.open.service.PretFeeTypeService;
import com.pret.open.service.user.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("role")
public class RoleController extends BaseManageController<RoleService, Role, RoleVo> {
    @Autowired
    private RoleRepository roleRepository;

    @Log("根据code获取")
    @GetMapping("/getByCode/{code}")
    public Role getByCode(@PathVariable String code) throws FebsException {
        try {
            Role role = roleRepository.findByCode(code);
            return role;
        } catch (Exception e) {
            message = "获取失败";
            throw new FebsException(message);
        }
    }
}