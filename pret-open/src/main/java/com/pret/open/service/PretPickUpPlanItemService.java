package com.pret.open.service;

import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.entity.PretPickUpPlanItem;
import com.pret.open.entity.vo.PretPickUpPlanItemVo;
import com.pret.open.vo.req.*;
import com.pret.open.repository.PretPickUpPlanItemRepository;
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
public class PretPickUpPlanItemService extends BaseServiceImpl<PretPickUpPlanItemRepository, PretPickUpPlanItem, PretPickUpPlanItemVo>{
    /**
    * <p>Discription:[pret数据新增]</p>
    * Created on 2019年09月15日
    * @param PPretPickUpPlanItemSaveVo pret数据
    * @return PretPickUpPlanItem 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPretPickUpPlanItemSaveVo res) {
      PretPickUpPlanItem entity = new PretPickUpPlanItem();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据批量删除]</p>
    * Created on 2019年09月15日
    * @param PPretPickUpPlanItemDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPretPickUpPlanItemDeleteVo res) {
      PretPickUpPlanItem entity = new PretPickUpPlanItem();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pret获取详情]</p>
    * Created on 2019年09月15日
    * @param PPretPickUpPlanItemDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPretPickUpPlanItemDetailVo res) {
        PretPickUpPlanItem entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据更新]</p>
    * Created on 2019年09月15日
    * @param PPretPickUpPlanItemUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPretPickUpPlanItemUpdateVo res) {
      PretPickUpPlanItem entity = new PretPickUpPlanItem();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据分页查询]</p>
    * Created on 2019年09月15日
    * @param PPretPickUpPlanItemQueryVo
    * @return List<PretPickUpPlanItem>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPretPickUpPlanItemQueryVo res) {
      PretPickUpPlanItemVo vo = new PretPickUpPlanItemVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PretPickUpPlanItem> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }
}
