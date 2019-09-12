package com.pret.service;

import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.entity.PertTransPlan;
import com.pret.entity.vo.PertTransPlanVo;
import com.pret.vo.req.*;
import com.pret.repository.PertTransPlanRepository;
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
public class PertTransPlanService extends BaseServiceImpl<PertTransPlanRepository, PertTransPlan, PertTransPlanVo>{
    /**
    * <p>Discription:[pert数据新增]</p>
    * Created on 2019年08月29日
    * @param PPertTransPlanSaveVo pert数据
    * @return PertTransPlan 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPertTransPlanSaveVo res) {
      PertTransPlan entity = new PertTransPlan();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据批量删除]</p>
    * Created on 2019年08月29日
    * @param PPertTransPlanDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPertTransPlanDeleteVo res) {
      PertTransPlan entity = new PertTransPlan();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pert获取详情]</p>
    * Created on 2019年08月29日
    * @param PPertTransPlanDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPertTransPlanDetailVo res) {
        PertTransPlan entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据更新]</p>
    * Created on 2019年08月29日
    * @param PPertTransPlanUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPertTransPlanUpdateVo res) {
      PertTransPlan entity = new PertTransPlan();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据分页查询]</p>
    * Created on 2019年08月29日
    * @param PPertTransPlanQueryVo
    * @return List<PertTransPlan>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPertTransPlanQueryVo res) {
      PertTransPlanVo vo = new PertTransPlanVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PertTransPlan> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }
}
