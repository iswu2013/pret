package com.pret.service;

import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.entity.PertDeliveryOrderItem;
import com.pret.entity.vo.PertDeliveryOrderItemVo;
import com.pret.vo.req.*;
import com.pret.repository.PertDeliveryOrderItemRepository;
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
public class PertDeliveryOrderItemService extends BaseServiceImpl<PertDeliveryOrderItemRepository, PertDeliveryOrderItem, PertDeliveryOrderItemVo>{
    /**
    * <p>Discription:[pert数据新增]</p>
    * Created on 2019年08月29日
    * @param PPertDeliveryOrderItemSaveVo pert数据
    * @return PertDeliveryOrderItem 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPertDeliveryOrderItemSaveVo res) {
      PertDeliveryOrderItem entity = new PertDeliveryOrderItem();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据批量删除]</p>
    * Created on 2019年08月29日
    * @param PPertDeliveryOrderItemDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPertDeliveryOrderItemDeleteVo res) {
      PertDeliveryOrderItem entity = new PertDeliveryOrderItem();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pert获取详情]</p>
    * Created on 2019年08月29日
    * @param PPertDeliveryOrderItemDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPertDeliveryOrderItemDetailVo res) {
        PertDeliveryOrderItem entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据更新]</p>
    * Created on 2019年08月29日
    * @param PPertDeliveryOrderItemUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPertDeliveryOrderItemUpdateVo res) {
      PertDeliveryOrderItem entity = new PertDeliveryOrderItem();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据分页查询]</p>
    * Created on 2019年08月29日
    * @param PPertDeliveryOrderItemQueryVo
    * @return List<PertDeliveryOrderItem>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPertDeliveryOrderItemQueryVo res) {
      PertDeliveryOrderItemVo vo = new PertDeliveryOrderItemVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PertDeliveryOrderItem> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }
}
