package com.pret.service;

import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.entity.PertDeliveryOrder;
import com.pret.entity.vo.PertDeliveryOrderVo;
import com.pret.vo.req.*;
import com.pret.repository.PertDeliveryOrderRepository;
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
public class PertDeliveryOrderService extends BaseServiceImpl<PertDeliveryOrderRepository, PertDeliveryOrder, PertDeliveryOrderVo>{
    /**
    * <p>Discription:[pert数据新增]</p>
    * Created on 2019年08月29日
    * @param PPertDeliveryOrderSaveVo pert数据
    * @return PertDeliveryOrder 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPertDeliveryOrderSaveVo res) {
      PertDeliveryOrder entity = new PertDeliveryOrder();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据批量删除]</p>
    * Created on 2019年08月29日
    * @param PPertDeliveryOrderDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPertDeliveryOrderDeleteVo res) {
      PertDeliveryOrder entity = new PertDeliveryOrder();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pert获取详情]</p>
    * Created on 2019年08月29日
    * @param PPertDeliveryOrderDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPertDeliveryOrderDetailVo res) {
        PertDeliveryOrder entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据更新]</p>
    * Created on 2019年08月29日
    * @param PPertDeliveryOrderUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPertDeliveryOrderUpdateVo res) {
      PertDeliveryOrder entity = new PertDeliveryOrder();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据分页查询]</p>
    * Created on 2019年08月29日
    * @param PPertDeliveryOrderQueryVo
    * @return List<PertDeliveryOrder>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPertDeliveryOrderQueryVo res) {
      PertDeliveryOrderVo vo = new PertDeliveryOrderVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PertDeliveryOrder> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }
}
