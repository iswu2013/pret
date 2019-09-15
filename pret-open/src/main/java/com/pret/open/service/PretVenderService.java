package com.pret.open.service;

import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.entity.PretVender;
import com.pret.open.entity.vo.PretVenderVo;
import com.pret.open.vo.req.*;
import com.pret.open.repository.PretVenderRepository;
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
public class PretVenderService extends BaseServiceImpl<PretVenderRepository, PretVender, PretVenderVo>{
    /**
    * <p>Discription:[pret数据新增]</p>
    * Created on 2019年09月15日
    * @param PPretVenderSaveVo pret数据
    * @return PretVender 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPretVenderSaveVo res) {
      PretVender entity = new PretVender();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据批量删除]</p>
    * Created on 2019年09月15日
    * @param PPretVenderDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPretVenderDeleteVo res) {
      PretVender entity = new PretVender();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pret获取详情]</p>
    * Created on 2019年09月15日
    * @param PPretVenderDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPretVenderDetailVo res) {
        PretVender entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据更新]</p>
    * Created on 2019年09月15日
    * @param PPretVenderUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPretVenderUpdateVo res) {
      PretVender entity = new PretVender();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据分页查询]</p>
    * Created on 2019年09月15日
    * @param PPretVenderQueryVo
    * @return List<PretVender>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPretVenderQueryVo res) {
      PretVenderVo vo = new PretVenderVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PretVender> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }
}
