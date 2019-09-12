package com.pret.service;

import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.entity.PertPickUpPlanItem;
import com.pret.entity.vo.PertPickUpPlanItemVo;
import com.pret.vo.req.*;
import com.pret.repository.PertPickUpPlanItemRepository;
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
public class PertPickUpPlanItemService extends BaseServiceImpl<PertPickUpPlanItemRepository, PertPickUpPlanItem, PertPickUpPlanItemVo>{
    /**
    * <p>Discription:[pert数据新增]</p>
    * Created on 2019年08月29日
    * @param PPertPickUpPlanItemSaveVo pert数据
    * @return PertPickUpPlanItem 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPertPickUpPlanItemSaveVo res) {
      PertPickUpPlanItem entity = new PertPickUpPlanItem();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据批量删除]</p>
    * Created on 2019年08月29日
    * @param PPertPickUpPlanItemDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPertPickUpPlanItemDeleteVo res) {
      PertPickUpPlanItem entity = new PertPickUpPlanItem();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pert获取详情]</p>
    * Created on 2019年08月29日
    * @param PPertPickUpPlanItemDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPertPickUpPlanItemDetailVo res) {
        PertPickUpPlanItem entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据更新]</p>
    * Created on 2019年08月29日
    * @param PPertPickUpPlanItemUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPertPickUpPlanItemUpdateVo res) {
      PertPickUpPlanItem entity = new PertPickUpPlanItem();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据分页查询]</p>
    * Created on 2019年08月29日
    * @param PPertPickUpPlanItemQueryVo
    * @return List<PertPickUpPlanItem>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPertPickUpPlanItemQueryVo res) {
      PertPickUpPlanItemVo vo = new PertPickUpPlanItemVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PertPickUpPlanItem> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }
}
