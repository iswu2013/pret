package com.pret.service;

import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.entity.PertPickUpPlan;
import com.pret.entity.vo.PertPickUpPlanVo;
import com.pret.vo.req.*;
import com.pret.repository.PertPickUpPlanRepository;
import com.pret.api.service.impl.BaseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

/**
 * Description: [pert服务]
 * Created on 2019年08月29日
 * @author  <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0 
 * Copyright (c) 2019年 极客城堡
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class PertPickUpPlanService extends BaseServiceImpl<PertPickUpPlanRepository, PertPickUpPlan, PertPickUpPlanVo>{
    /**
    * <p>Discription:[pert数据新增]</p>
    * Created on 2019年08月29日
    * @param PPertPickUpPlanSaveVo pert数据
    * @return PertPickUpPlan 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPertPickUpPlanSaveVo res) {
      PertPickUpPlan entity = new PertPickUpPlan();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据批量删除]</p>
    * Created on 2019年08月29日
    * @param PPertPickUpPlanDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPertPickUpPlanDeleteVo res) {
      PertPickUpPlan entity = new PertPickUpPlan();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pert获取详情]</p>
    * Created on 2019年08月29日
    * @param PPertPickUpPlanDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPertPickUpPlanDetailVo res) {
        PertPickUpPlan entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据更新]</p>
    * Created on 2019年08月29日
    * @param PPertPickUpPlanUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPertPickUpPlanUpdateVo res) {
      PertPickUpPlan entity = new PertPickUpPlan();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据分页查询]</p>
    * Created on 2019年08月29日
    * @param PPertPickUpPlanQueryVo
    * @return List<PertPickUpPlan>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPertPickUpPlanQueryVo res) {
      PertPickUpPlanVo vo = new PertPickUpPlanVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PertPickUpPlan> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }
}
