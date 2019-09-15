package com.pret.open.service;

import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.entity.PretTransOrderItem;
import com.pret.open.entity.vo.PretTransOrderItemVo;
import com.pret.open.vo.req.*;
import com.pret.open.repository.PretTransOrderItemRepository;
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
public class PretTransOrderItemService extends BaseServiceImpl<PretTransOrderItemRepository, PretTransOrderItem, PretTransOrderItemVo>{
    /**
    * <p>Discription:[pret数据新增]</p>
    * Created on 2019年09月15日
    * @param PPretTransOrderItemSaveVo pret数据
    * @return PretTransOrderItem 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPretTransOrderItemSaveVo res) {
      PretTransOrderItem entity = new PretTransOrderItem();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据批量删除]</p>
    * Created on 2019年09月15日
    * @param PPretTransOrderItemDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPretTransOrderItemDeleteVo res) {
      PretTransOrderItem entity = new PretTransOrderItem();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pret获取详情]</p>
    * Created on 2019年09月15日
    * @param PPretTransOrderItemDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPretTransOrderItemDetailVo res) {
        PretTransOrderItem entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据更新]</p>
    * Created on 2019年09月15日
    * @param PPretTransOrderItemUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPretTransOrderItemUpdateVo res) {
      PretTransOrderItem entity = new PretTransOrderItem();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据分页查询]</p>
    * Created on 2019年09月15日
    * @param PPretTransOrderItemQueryVo
    * @return List<PretTransOrderItem>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPretTransOrderItemQueryVo res) {
      PretTransOrderItemVo vo = new PretTransOrderItemVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PretTransOrderItem> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }
}
