package com.pret.open.controller;

import com.google.common.reflect.TypeToken;
import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.constant.CommonConstants;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.exception.FebsException;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.common.util.StringUtil;
import com.pret.common.utils.MD5Util;
import com.pret.open.entity.*;
import com.pret.open.entity.bo.PretMTransOrderItemBo;
import com.pret.open.entity.bo.PretServiceRouteBo;
import com.pret.open.entity.user.Role;
import com.pret.open.entity.user.User;
import com.pret.open.entity.user.UserConfig;
import com.pret.open.entity.user.UserRole;
import com.pret.open.entity.vo.PretVenderVo;
import com.pret.open.repository.*;
import com.pret.open.repository.user.RoleRepository;
import com.pret.open.repository.user.UserConfigRepository;
import com.pret.open.repository.user.UserRepository;
import com.pret.open.repository.user.UserRoleRepository;
import com.pret.open.service.PretServiceRouteOriginUserService;
import com.pret.open.service.PretTransOrderService;
import com.pret.open.service.PretVenderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.management.remote.rmi._RMIConnection_Stub;
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
    @Autowired
    private PretServiceRouteOriginUserRepository pretServiceRouteOriginUserRepository;
    @Autowired
    private PretTransOrderGroupRepository pretTransOrderGroupRepository;
    @Autowired
    private PretTransOrderService pretTransOrderService;
    @Autowired
    private PretServiceRouteOriginRepository pretServiceRouteOriginRepository;
    @Autowired
    private PretServiceRouteOriginUserService pretServiceRouteOriginUserService;
    @PersistenceContext
    private EntityManager em;


    @Log("查看")
    @PostMapping("/view/{id}")
    public PretVender view(@PathVariable String id) throws FebsException {
        try {
            PretVender item = this.service.findById(id).get();
            List<User> userList = new ArrayList<>();
            List<PretServiceRouteOrigin> pretServiceRouteOriginList = new ArrayList<>();
            List<PretServiceRouteOriginUser> pretServiceRouteOriginUserList = pretServiceRouteOriginUserRepository.findByVenderIdAndS(item.getId(), ConstantEnum.S.N.getLabel());
            if (pretServiceRouteOriginUserList != null && pretServiceRouteOriginUserList.size() > 0) {
                for (PretServiceRouteOriginUser pretServiceRouteOriginUser : pretServiceRouteOriginUserList) {
                    User user = userRepository.findById(pretServiceRouteOriginUser.getUserId()).get();
                    pretServiceRouteOriginUser.setUser(user);
                    PretVender pretVender = pretVenderRepository.findById(pretServiceRouteOriginUser.getVenderId()).get();
                    pretServiceRouteOriginUser.setPretVender(pretVender);
                    PretServiceRouteOrigin pretServiceRouteOrigin = pretServiceRouteOriginRepository.findById(pretServiceRouteOriginUser.getServiceRouteOriginId()).get();
                    pretServiceRouteOriginUser.setPretServiceRouteOrigin(pretServiceRouteOrigin);
                    userList.add(user);
                    pretServiceRouteOriginList.add(pretServiceRouteOrigin);
                }
            }
            item.setUserList(userList);
            item.setPretServiceRouteOriginList(pretServiceRouteOriginList);
            item.setServiceRouteOriginUserDataSource(pretServiceRouteOriginUserList);
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
        String where = " where 1=1 and id not in (select distinct vender_id from pret_service_route b where b.vender_id is not null and b.s=1 ) and a.s=1 ";
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
                PretTransOrderGroup pretTransOrderGroup = pretTransOrderGroupRepository.findById(item).get();
                pretTransOrderGroup.setVenderId(id);
                pretTransOrderGroup.setStatus(ConstantEnum.ETransOrderStatus.已分配.getLabel());
                pretTransOrderGroupRepository.save(pretTransOrderGroup);
                List<PretTransOrder> pretTransOrderList = pretTransOrderRepository.findByTransOrderGroupIdAndS(item, ConstantEnum.S.N.getLabel());
                if (pretTransOrderList != null && pretTransOrderList.size() > 0) {
                    for (PretTransOrder pretTransOrder : pretTransOrderList) {
                        pretTransOrder.setTransOrderGroupId(item);
                        pretTransOrder.setVenderId(id);
                        pretTransOrder.setStatus(ConstantEnum.ETransOrderStatus.已分配.getLabel());
                        pretTransOrderRepository.save(pretTransOrder);

                        pretTransOrderService.pretTransOrderStatistics(ConstantEnum.ETransOrderStatisticsUserType.物流供应商.getLabel(), pretTransOrder.getVenderId());
                    }
                }
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
    @Transactional()
    public void pretVenderAdd(PretVender vender) throws FebsException {
        try {
            PretVender pretVender = pretVenderRepository.findByCodeAndS(vender.getCode(), ConstantEnum.S.N.getLabel());
            if (pretVender != null) {
                message = "已存在相同的供应商code";
                throw new FebsException(message);
            }
            pretVender = pretVenderRepository.findByLinkPhoneAndS(vender.getLinkPhone(), ConstantEnum.S.N.getLabel());
            if (pretVender != null) {
                message = "已存在相同的手机号码供应商";
                throw new FebsException(message);
            }
            this.pretVenderRepository.save(vender);

            if (!StringUtils.isEmpty(vender.getTallyClerkStr())) {
                List<PretServiceRouteOriginUser> list = CommonConstants.GSON.fromJson(vender.getTallyClerkStr(),
                        new TypeToken<List<PretServiceRouteOriginUser>>() {
                        }.getType());
                if (list != null && list.size() > 0) {
                    for (PretServiceRouteOriginUser pretServiceRouteOriginUser : list) {
                        pretServiceRouteOriginUser.setVenderId(vender.getId());
                        pretServiceRouteOriginUserRepository.save(pretServiceRouteOriginUser);
                    }
                }
            }


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
            throw new FebsException(e.getMessage());
        }
    }

    @Log("编辑物流供应商")
    @PostMapping("/pretVenderEdit")
    public void pretVenderEdit(PretVender vender) throws FebsException {
        try {
            PretVender pretVender = pretVenderRepository.findById(vender.getId()).get();
            BeanUtilsExtended.copyProperties(pretVender, vender);
            this.pretVenderRepository.save(pretVender);

            List<PretServiceRouteOriginUser> pretServiceRouteOriginUserList = pretServiceRouteOriginUserRepository.findByVenderIdAndS(vender.getId(), ConstantEnum.S.N.getLabel());
            if (pretServiceRouteOriginUserList != null && pretServiceRouteOriginUserList.size() > 0) {
                for (PretServiceRouteOriginUser pretServiceRouteOriginUser : pretServiceRouteOriginUserList) {
                    pretServiceRouteOriginUserService.lDelete(pretServiceRouteOriginUser.getId());
                }
            }

            if (!StringUtils.isEmpty(vender.getTallyClerkStr())) {
                List<PretServiceRouteOriginUser> list = CommonConstants.GSON.fromJson(vender.getTallyClerkStr(),
                        new TypeToken<List<PretServiceRouteOriginUser>>() {
                        }.getType());
                if (list != null && list.size() > 0) {
                    for (PretServiceRouteOriginUser pretServiceRouteOriginUser : list) {
                        pretServiceRouteOriginUser.setVenderId(vender.getId());
                        pretServiceRouteOriginUserRepository.save(pretServiceRouteOriginUser);
                    }
                }
            }

        } catch (Exception e) {
            throw new FebsException(e.getMessage());
        }
    }
}