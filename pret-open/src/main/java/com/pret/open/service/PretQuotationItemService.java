package com.pret.open.service;

import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.entity.PretQuotationItem;
import com.pret.open.entity.vo.PretQuotationItemVo;
import com.pret.open.vo.req.*;
import com.pret.open.repository.PretQuotationItemRepository;
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
public class PretQuotationItemService extends BaseServiceImpl<PretQuotationItemRepository, PretQuotationItem, PretQuotationItemVo>{
    /**
    * <p>Discription:[pret数据新增]</p>
    * Created on 2019年09月15日
    * @param PPretQuotationItemSaveVo pret数据
    * @return PretQuotationItem 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPretQuotationItemSaveVo res) {
      PretQuotationItem entity = new PretQuotationItem();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据批量删除]</p>
    * Created on 2019年09月15日
    * @param PPretQuotationItemDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPretQuotationItemDeleteVo res) {
      PretQuotationItem entity = new PretQuotationItem();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pret获取详情]</p>
    * Created on 2019年09月15日
    * @param PPretQuotationItemDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPretQuotationItemDetailVo res) {
        PretQuotationItem entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据更新]</p>
    * Created on 2019年09月15日
    * @param PPretQuotationItemUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPretQuotationItemUpdateVo res) {
      PretQuotationItem entity = new PretQuotationItem();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据分页查询]</p>
    * Created on 2019年09月15日
    * @param PPretQuotationItemQueryVo
    * @return List<PretQuotationItem>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPretQuotationItemQueryVo res) {
      PretQuotationItemVo vo = new PretQuotationItemVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PretQuotationItem> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }
}
