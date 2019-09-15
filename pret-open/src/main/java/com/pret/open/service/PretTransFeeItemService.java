package com.pret.open.service;

import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.entity.PretTransFeeItem;
import com.pret.open.entity.vo.PretTransFeeItemVo;
import com.pret.open.vo.req.*;
import com.pret.open.repository.PretTransFeeItemRepository;
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
public class PretTransFeeItemService extends BaseServiceImpl<PretTransFeeItemRepository, PretTransFeeItem, PretTransFeeItemVo>{
    /**
    * <p>Discription:[pret数据新增]</p>
    * Created on 2019年09月15日
    * @param PPretTransFeeItemSaveVo pret数据
    * @return PretTransFeeItem 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPretTransFeeItemSaveVo res) {
      PretTransFeeItem entity = new PretTransFeeItem();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据批量删除]</p>
    * Created on 2019年09月15日
    * @param PPretTransFeeItemDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPretTransFeeItemDeleteVo res) {
      PretTransFeeItem entity = new PretTransFeeItem();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pret获取详情]</p>
    * Created on 2019年09月15日
    * @param PPretTransFeeItemDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPretTransFeeItemDetailVo res) {
        PretTransFeeItem entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据更新]</p>
    * Created on 2019年09月15日
    * @param PPretTransFeeItemUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPretTransFeeItemUpdateVo res) {
      PretTransFeeItem entity = new PretTransFeeItem();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据分页查询]</p>
    * Created on 2019年09月15日
    * @param PPretTransFeeItemQueryVo
    * @return List<PretTransFeeItem>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPretTransFeeItemQueryVo res) {
      PretTransFeeItemVo vo = new PretTransFeeItemVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PretTransFeeItem> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }
}
