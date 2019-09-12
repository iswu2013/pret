package com.pret.service;

import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.entity.PertServiceLineItem;
import com.pret.entity.vo.PertServiceLineItemVo;
import com.pret.vo.req.*;
import com.pret.repository.PertServiceLineItemRepository;
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
public class PertServiceLineItemService extends BaseServiceImpl<PertServiceLineItemRepository, PertServiceLineItem, PertServiceLineItemVo>{
    /**
    * <p>Discription:[pert数据新增]</p>
    * Created on 2019年08月29日
    * @param PPertServiceLineItemSaveVo pert数据
    * @return PertServiceLineItem 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPertServiceLineItemSaveVo res) {
      PertServiceLineItem entity = new PertServiceLineItem();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据批量删除]</p>
    * Created on 2019年08月29日
    * @param PPertServiceLineItemDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPertServiceLineItemDeleteVo res) {
      PertServiceLineItem entity = new PertServiceLineItem();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pert获取详情]</p>
    * Created on 2019年08月29日
    * @param PPertServiceLineItemDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPertServiceLineItemDetailVo res) {
        PertServiceLineItem entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据更新]</p>
    * Created on 2019年08月29日
    * @param PPertServiceLineItemUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPertServiceLineItemUpdateVo res) {
      PertServiceLineItem entity = new PertServiceLineItem();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据分页查询]</p>
    * Created on 2019年08月29日
    * @param PPertServiceLineItemQueryVo
    * @return List<PertServiceLineItem>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPertServiceLineItemQueryVo res) {
      PertServiceLineItemVo vo = new PertServiceLineItemVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PertServiceLineItem> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }
}
