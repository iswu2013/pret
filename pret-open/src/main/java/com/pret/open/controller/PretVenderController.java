package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.exception.FebsException;
import com.pret.common.utils.MD5Util;
import com.pret.open.entity.PretVender;
import com.pret.open.entity.user.Role;
import com.pret.open.entity.user.User;
import com.pret.open.entity.user.UserConfig;
import com.pret.open.entity.user.UserRole;
import com.pret.open.entity.vo.PretVenderVo;
import com.pret.open.repository.PretVenderRepository;
import com.pret.open.repository.user.RoleRepository;
import com.pret.open.repository.user.UserConfigRepository;
import com.pret.open.repository.user.UserRepository;
import com.pret.open.repository.user.UserRoleRepository;
import com.pret.open.service.PretVenderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequestMapping("pretVender")
public class PretVenderController extends BaseManageController<PretVenderService, PretVender, PretVenderVo> {
    @Autowired
    private PretVenderRepository pretVenderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserConfigRepository userConfigRepository;


    @Log("查看")
    @PostMapping("/view/{id}")
    public PretVender view(@PathVariable String id) throws FebsException {
        try {
            PretVender item = this.service.findById(id).get();
            return item;
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
    }

    /* *
     * 功能描述: 新建物流供应商
     * 〈〉
     * @Param: [vender]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/11/4  10:21 上午
     */
    @Log("新建物流供应商")
    @PostMapping("/pretVenderAdd")
    public void pretVenderAdd(PretVender vender) throws FebsException {
        try {
            this.pretVenderRepository.save(vender);

            User user = new User();
            user.setUsername(vender.getLinkPhone());
            user.setMobile(vender.getLinkPhone());
            user.setPassword(MD5Util.encrypt(user.getUsername(), User.DEFAULT_PASSWORD));
            userRepository.save(user);
            user = userRepository.findById(user.getId()).get();

            Role role = roleRepository.findByCode(ConstantEnum.ERoleCode.Vender.name());
            UserRole userRole = new UserRole();
            userRole.setRoleId(role.getRoleId());
            userRole.setUserId(user.getUserId());
            userRoleRepository.save(userRole);

            UserConfig userConfig = new UserConfig();
            userConfig.setUserId(user.getUserId());
            userConfig.setColor(UserConfig.DEFAULT_COLOR);
            userConfig.setFixHeader(UserConfig.DEFAULT_FIX_HEADER);
            userConfig.setFixSiderbar(UserConfig.DEFAULT_FIX_SIDERBAR);
            userConfig.setLayout(UserConfig.DEFAULT_LAYOUT);
            userConfig.setTheme(UserConfig.DEFAULT_THEME);
            userConfig.setMultiPage(UserConfig.DEFAULT_MULTIPAGE);
            userConfigRepository.save(userConfig);

        } catch (Exception e) {
            message = "新建物流供应商失败";
            throw new FebsException(message);
        }
    }
}