package com.pret.open.service;

import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.entity.PretTransPlan;
import com.pret.open.entity.vo.PretTransPlanVo;
import com.pret.open.vo.req.*;
import com.pret.open.repository.PretTransPlanRepository;
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
public class PretTransPlanService extends BaseServiceImpl<PretTransPlanRepository, PretTransPlan, PretTransPlanVo>{
    /**
    * <p>Discription:[pret数据新增]</p>
    * Created on 2019年09月15日
    * @param PPretTransPlanSaveVo pret数据
    * @return PretTransPlan 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPretTransPlanSaveVo res) {
      PretTransPlan entity = new PretTransPlan();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据批量删除]</p>
    * Created on 2019年09月15日
    * @param PPretTransPlanDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPretTransPlanDeleteVo res) {
      PretTransPlan entity = new PretTransPlan();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pret获取详情]</p>
    * Created on 2019年09月15日
    * @param PPretTransPlanDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPretTransPlanDetailVo res) {
        PretTransPlan entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据更新]</p>
    * Created on 2019年09月15日
    * @param PPretTransPlanUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPretTransPlanUpdateVo res) {
      PretTransPlan entity = new PretTransPlan();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据分页查询]</p>
    * Created on 2019年09月15日
    * @param PPretTransPlanQueryVo
    * @return List<PretTransPlan>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPretTransPlanQueryVo res) {
      PretTransPlanVo vo = new PretTransPlanVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PretTransPlan> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }
}
