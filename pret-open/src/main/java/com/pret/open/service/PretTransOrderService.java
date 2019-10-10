package com.pret.open.service;

import java.util.List;
import java.util.Optional;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.entity.PretPickUpPlan;
import com.pret.open.entity.PretTransOrder;
import com.pret.open.entity.bo.PretPickUpPlanBo;
import com.pret.open.entity.vo.PretTransOrderVo;
import com.pret.open.repository.PretPickUpPlanRepository;
import com.pret.open.vo.req.*;
import com.pret.open.repository.PretTransOrderRepository;
import com.pret.api.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class PretTransOrderService extends BaseServiceImpl<PretTransOrderRepository, PretTransOrder, PretTransOrderVo>{
    @Autowired
    private PretPickUpPlanRepository pretPickUpPlanRepository;
    @Autowired
    private PretPickUpPlanService pretPickUpPlanService;

    /**
    * <p>Discription:[pret数据新增]</p>
    * Created on 2019年09月15日
    * @param PPretTransOrderSaveVo pret数据
    * @return PretTransOrder 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPretTransOrderSaveVo res) {
      PretTransOrder entity = new PretTransOrder();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据批量删除]</p>
    * Created on 2019年09月15日
    * @param PPretTransOrderDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPretTransOrderDeleteVo res) {
      PretTransOrder entity = new PretTransOrder();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pret获取详情]</p>
    * Created on 2019年09月15日
    * @param PPretTransOrderDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPretTransOrderDetailVo res) {
        PretTransOrder entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据更新]</p>
    * Created on 2019年09月15日
    * @param PPretTransOrderUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPretTransOrderUpdateVo res) {
      PretTransOrder entity = new PretTransOrder();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据分页查询]</p>
    * Created on 2019年09月15日
    * @param PPretTransOrderQueryVo
    * @return List<PretTransOrder>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPretTransOrderQueryVo res) {
      PretTransOrderVo vo = new PretTransOrderVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PretTransOrder> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }
}
