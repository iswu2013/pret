package com.pret.open.service.user;


import com.pret.api.service.impl.BaseServiceImpl;
import com.pret.api.vo.ResBody;
import com.pret.common.constant.ConstantEnum;
import com.pret.open.entity.user.Dept;
import com.pret.open.entity.user.Role;
import com.pret.open.entity.vo.user.DeptVo;
import com.pret.open.entity.vo.user.RoleVo;
import com.pret.open.repository.user.DeptRepository;
import com.pret.open.repository.user.RoleRepository;
import com.pret.open.vo.req.P8000010Vo;
import com.pret.open.vo.res.PR8000010ItemVo;
import com.pret.open.vo.res.PR8000010Vo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Description: [t服务]
 * Created on 2019年10月19日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class DeptService extends BaseServiceImpl<DeptRepository, Dept, DeptVo> {

    /* *
     * 功能描述: 获取部门
     * 〈〉
     * @Param: [res]
     * @Return: com.pret.api.vo.ResBody
     * @Author: wujingsong
     * @Date: 2019/12/11  2:06 下午
     */
    public ResBody getDeptList(P8000010Vo res) {
        List<Dept> deptList = this.repository.findByParentIdAndS("0", ConstantEnum.S.N.getLabel());
        PR8000010Vo retVo = new PR8000010Vo();

        if (deptList != null && deptList.size() > 0) {
            for (Dept dept : deptList) {
                PR8000010ItemVo itemVo = new PR8000010ItemVo();
                itemVo.setId(dept.getId());
                itemVo.setDisplayName(dept.getDeptName());
                retVo.getItemVoList().add(itemVo);
                retVo.getItemList().add(dept.getDeptName());
                List<Dept> list = this.repository.findByParentIdAndS(dept.getId(), ConstantEnum.S.N.getLabel());
                if (list != null && list.size() > 0) {
                    for (Dept d : list) {
                        itemVo = new PR8000010ItemVo();
                        itemVo.setId(d.getId());
                        itemVo.setDisplayName(dept.getDeptName() + "-" + d.getDeptName());
                        retVo.getItemVoList().add(itemVo);
                        retVo.getItemList().add(itemVo.getDisplayName());
                    }
                }
            }
        }

        return retVo;
    }
}
