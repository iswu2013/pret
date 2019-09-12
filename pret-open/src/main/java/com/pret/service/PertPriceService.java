package com.pret.service;

import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.entity.PertPrice;
import com.pret.entity.vo.PertPriceVo;
import com.pret.vo.req.*;
import com.pret.repository.PertPriceRepository;
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
public class PertPriceService extends BaseServiceImpl<PertPriceRepository, PertPrice, PertPriceVo>{
    /**
    * <p>Discription:[pert数据新增]</p>
    * Created on 2019年08月29日
    * @param PPertPriceSaveVo pert数据
    * @return PertPrice 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPertPriceSaveVo res) {
      PertPrice entity = new PertPrice();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据批量删除]</p>
    * Created on 2019年08月29日
    * @param PPertPriceDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPertPriceDeleteVo res) {
      PertPrice entity = new PertPrice();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pert获取详情]</p>
    * Created on 2019年08月29日
    * @param PPertPriceDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPertPriceDetailVo res) {
        PertPrice entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据更新]</p>
    * Created on 2019年08月29日
    * @param PPertPriceUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPertPriceUpdateVo res) {
      PertPrice entity = new PertPrice();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据分页查询]</p>
    * Created on 2019年08月29日
    * @param PPertPriceQueryVo
    * @return List<PertPrice>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPertPriceQueryVo res) {
      PertPriceVo vo = new PertPriceVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PertPrice> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }
}
