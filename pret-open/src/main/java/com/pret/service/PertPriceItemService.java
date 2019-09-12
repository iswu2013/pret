package com.pret.service;

import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.entity.PertPriceItem;
import com.pret.entity.vo.PertPriceItemVo;
import com.pret.vo.req.*;
import com.pret.repository.PertPriceItemRepository;
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
public class PertPriceItemService extends BaseServiceImpl<PertPriceItemRepository, PertPriceItem, PertPriceItemVo>{
    /**
    * <p>Discription:[pert数据新增]</p>
    * Created on 2019年08月29日
    * @param PPertPriceItemSaveVo pert数据
    * @return PertPriceItem 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPertPriceItemSaveVo res) {
      PertPriceItem entity = new PertPriceItem();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据批量删除]</p>
    * Created on 2019年08月29日
    * @param PPertPriceItemDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPertPriceItemDeleteVo res) {
      PertPriceItem entity = new PertPriceItem();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pert获取详情]</p>
    * Created on 2019年08月29日
    * @param PPertPriceItemDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPertPriceItemDetailVo res) {
        PertPriceItem entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据更新]</p>
    * Created on 2019年08月29日
    * @param PPertPriceItemUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPertPriceItemUpdateVo res) {
      PertPriceItem entity = new PertPriceItem();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据分页查询]</p>
    * Created on 2019年08月29日
    * @param PPertPriceItemQueryVo
    * @return List<PertPriceItem>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPertPriceItemQueryVo res) {
      PertPriceItemVo vo = new PertPriceItemVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PertPriceItem> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }
}
