package com.pret.open.service;

import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.entity.PretServiceRoute;
import com.pret.open.entity.vo.PretServiceRouteVo;
import com.pret.open.vo.req.*;
import com.pret.open.repository.PretServiceRouteRepository;
import com.pret.api.service.impl.BaseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

/**
 * Description: [pret服务]
 * Created on 2019年09月15日
 * @author  <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0 
 * Copyright (c) 2019年 极客城堡
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class PretServiceRouteService extends BaseServiceImpl<PretServiceRouteRepository, PretServiceRoute, PretServiceRouteVo>{
    /**
    * <p>Discription:[pret数据新增]</p>
    * Created on 2019年09月15日
    * @param PPretServiceRouteSaveVo pret数据
    * @return PretServiceRoute 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPretServiceRouteSaveVo res) {
      PretServiceRoute entity = new PretServiceRoute();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据批量删除]</p>
    * Created on 2019年09月15日
    * @param PPretServiceRouteDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPretServiceRouteDeleteVo res) {
      PretServiceRoute entity = new PretServiceRoute();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pret获取详情]</p>
    * Created on 2019年09月15日
    * @param PPretServiceRouteDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPretServiceRouteDetailVo res) {
        PretServiceRoute entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据更新]</p>
    * Created on 2019年09月15日
    * @param PPretServiceRouteUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPretServiceRouteUpdateVo res) {
      PretServiceRoute entity = new PretServiceRoute();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据分页查询]</p>
    * Created on 2019年09月15日
    * @param PPretServiceRouteQueryVo
    * @return List<PretServiceRoute>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPretServiceRouteQueryVo res) {
      PretServiceRouteVo vo = new PretServiceRouteVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PretServiceRoute> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }
}
