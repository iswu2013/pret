package com.pret.open.service;

import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.entity.PretServiceRouteOrgin;
import com.pret.open.entity.vo.PretServiceRouteOrginVo;
import com.pret.open.vo.req.*;
import com.pret.open.repository.PretServiceRouteOrginRepository;
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
public class PretServiceRouteOrginService extends BaseServiceImpl<PretServiceRouteOrginRepository, PretServiceRouteOrgin, PretServiceRouteOrginVo>{
    /**
    * <p>Discription:[pret数据新增]</p>
    * Created on 2019年09月15日
    * @param PPretServiceRouteOrginSaveVo pret数据
    * @return PretServiceRouteOrgin 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPretServiceRouteOrginSaveVo res) {
      PretServiceRouteOrgin entity = new PretServiceRouteOrgin();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据批量删除]</p>
    * Created on 2019年09月15日
    * @param PPretServiceRouteOrginDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPretServiceRouteOrginDeleteVo res) {
      PretServiceRouteOrgin entity = new PretServiceRouteOrgin();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pret获取详情]</p>
    * Created on 2019年09月15日
    * @param PPretServiceRouteOrginDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPretServiceRouteOrginDetailVo res) {
        PretServiceRouteOrgin entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据更新]</p>
    * Created on 2019年09月15日
    * @param PPretServiceRouteOrginUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPretServiceRouteOrginUpdateVo res) {
      PretServiceRouteOrgin entity = new PretServiceRouteOrgin();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据分页查询]</p>
    * Created on 2019年09月15日
    * @param PPretServiceRouteOrginQueryVo
    * @return List<PretServiceRouteOrgin>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPretServiceRouteOrginQueryVo res) {
      PretServiceRouteOrginVo vo = new PretServiceRouteOrginVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PretServiceRouteOrgin> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }
}
