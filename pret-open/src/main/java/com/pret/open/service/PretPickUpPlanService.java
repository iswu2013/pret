package com.pret.open.service;

import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.entity.PretPickUpPlan;
import com.pret.open.entity.vo.PretPickUpPlanVo;
import com.pret.open.vo.req.*;
import com.pret.open.repository.PretPickUpPlanRepository;
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
public class PretPickUpPlanService extends BaseServiceImpl<PretPickUpPlanRepository, PretPickUpPlan, PretPickUpPlanVo>{
    /**
    * <p>Discription:[pret数据新增]</p>
    * Created on 2019年09月15日
    * @param PPretPickUpPlanSaveVo pret数据
    * @return PretPickUpPlan 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPretPickUpPlanSaveVo res) {
      PretPickUpPlan entity = new PretPickUpPlan();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据批量删除]</p>
    * Created on 2019年09月15日
    * @param PPretPickUpPlanDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPretPickUpPlanDeleteVo res) {
      PretPickUpPlan entity = new PretPickUpPlan();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pret获取详情]</p>
    * Created on 2019年09月15日
    * @param PPretPickUpPlanDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPretPickUpPlanDetailVo res) {
        PretPickUpPlan entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据更新]</p>
    * Created on 2019年09月15日
    * @param PPretPickUpPlanUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPretPickUpPlanUpdateVo res) {
      PretPickUpPlan entity = new PretPickUpPlan();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据分页查询]</p>
    * Created on 2019年09月15日
    * @param PPretPickUpPlanQueryVo
    * @return List<PretPickUpPlan>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPretPickUpPlanQueryVo res) {
      PretPickUpPlanVo vo = new PretPickUpPlanVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PretPickUpPlan> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }
}
