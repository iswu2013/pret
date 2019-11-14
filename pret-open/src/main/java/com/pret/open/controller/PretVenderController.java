package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.exception.FebsException;
import com.pret.common.util.StringUtil;
import com.pret.common.utils.MD5Util;
import com.pret.open.entity.PretTransOrder;
import com.pret.open.entity.PretVender;
import com.pret.open.entity.user.Role;
import com.pret.open.entity.user.User;
import com.pret.open.entity.user.UserConfig;
import com.pret.open.entity.user.UserRole;
import com.pret.open.entity.vo.PretVenderVo;
import com.pret.open.repository.PretTransOrderRepository;
import com.pret.open.repository.PretVenderRepository;
import com.pret.open.repository.user.RoleRepository;
import com.pret.open.repository.user.UserConfigRepository;
import com.pret.open.repository.user.UserRepository;
import com.pret.open.repository.user.UserRoleRepository;
import com.pret.open.service.PretVenderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private PretTransOrderRepository pretTransOrderRepository;
    @PersistenceContext
    private EntityManager em;


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
     * 功能描述: <br>
     * 〈〉
     * @Param: 获取没有配置过线路的供应商
     * @Return: java.util.List<com.pret.open.entity.PretTransOrder>
     * @Author: wujingsong
     * @Date: 2019/11/14  11:38 上午
     */
    @RequestMapping(value = "/getByWithoutServiceRoute", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getByWithoutServiceRoute() {
        Query query;
        StringBuffer querySql;
        String where = " where 1=1 and id not in (select distinct vender_id from pret_service_route_item b where b.vender_id is not null  ) and a.s=1 ";
        String con = "SELECT id,code FROM pret_vender a  " + where;
        querySql = new StringBuffer(con);
        query = em.createNativeQuery(querySql.toString());
        query.setFirstResult(0);
        query.setMaxResults(10);
        List<PretVender> pretVenderList = new ArrayList<>();
        List<Object[]> objectList = query.getResultList();
        if (objectList.size() > 0) {
            for (Object object[] : objectList) {
                String id = object[0].toString();
                PretVender pretVender = this.service.findById(id).get();
                pretVenderList.add(pretVender);
            }
        }
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", pretVenderList);
        rspData.put("total", 10);

        return rspData;
    }

    @Log("指派供应商")
    @PostMapping("/dispatch/{ids}/{id}")
    public void dispatch(@PathVariable String ids, @PathVariable String id) throws FebsException {
        try {
            List<String> idList = StringUtil.idsStr2ListString(ids);
            for (String item : idList) {
                PretTransOrder pretTransOrder = pretTransOrderRepository.findById(item).get();
                pretTransOrder.setVenderId(id);
                pretTransOrderRepository.save(pretTransOrder);
            }
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
            PretVender pretVender = pretVenderRepository.findByCodeAndS(vender.getCode(), ConstantEnum.S.N.getLabel());
            if (pretVender != null) {
                message = "已存在相同的供应商code";
                throw new FebsException(message);
            }
            this.pretVenderRepository.save(vender);

            User user = new User();
            user.setUsername(vender.getLinkPhone());
            user.setMobile(vender.getLinkPhone());
            user.setPassword(MD5Util.encrypt(user.getUsername(), User.DEFAULT_PASSWORD));
            user.setUserType(ConstantEnum.EUserType.供应商.getLabel());
            user.setVenderId(vender.getId());
            userRepository.save(user);
            user = userRepository.findById(user.getId()).get();
            vender.setUserId(user.getId());

            Role role = roleRepository.findByCode(ConstantEnum.ERoleCode.Vender.name());
            UserRole userRole = new UserRole();
            userRole.setRoleId(role.getId());
            userRole.setUserId(user.getId());
            userRoleRepository.save(userRole);

            UserConfig userConfig = new UserConfig();
            userConfig.setUserId(user.getId());
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