package com.pret.open.service;

import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.entity.PretQuotationItemPrice;
import com.pret.open.entity.vo.PretQuotationItemPriceVo;
import com.pret.open.vo.req.*;
import com.pret.open.repository.PretQuotationItemPriceRepository;
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
public class PretQuotationItemPriceService extends BaseServiceImpl<PretQuotationItemPriceRepository, PretQuotationItemPrice, PretQuotationItemPriceVo>{
    /**
    * <p>Discription:[pret数据新增]</p>
    * Created on 2019年09月15日
    * @param PPretQuotationItemPriceSaveVo pret数据
    * @return PretQuotationItemPrice 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPretQuotationItemPriceSaveVo res) {
      PretQuotationItemPrice entity = new PretQuotationItemPrice();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据批量删除]</p>
    * Created on 2019年09月15日
    * @param PPretQuotationItemPriceDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPretQuotationItemPriceDeleteVo res) {
      PretQuotationItemPrice entity = new PretQuotationItemPrice();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pret获取详情]</p>
    * Created on 2019年09月15日
    * @param PPretQuotationItemPriceDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPretQuotationItemPriceDetailVo res) {
        PretQuotationItemPrice entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据更新]</p>
    * Created on 2019年09月15日
    * @param PPretQuotationItemPriceUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPretQuotationItemPriceUpdateVo res) {
      PretQuotationItemPrice entity = new PretQuotationItemPrice();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据分页查询]</p>
    * Created on 2019年09月15日
    * @param PPretQuotationItemPriceQueryVo
    * @return List<PretQuotationItemPrice>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPretQuotationItemPriceQueryVo res) {
      PretQuotationItemPriceVo vo = new PretQuotationItemPriceVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PretQuotationItemPrice> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }
}
