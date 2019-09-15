package com.pret.open.service;

import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.entity.PretGoods;
import com.pret.open.entity.vo.PretGoodsVo;
import com.pret.open.vo.req.*;
import com.pret.open.repository.PretGoodsRepository;
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
public class PretGoodsService extends BaseServiceImpl<PretGoodsRepository, PretGoods, PretGoodsVo>{
    /**
    * <p>Discription:[pret数据新增]</p>
    * Created on 2019年09月15日
    * @param PPretGoodsSaveVo pret数据
    * @return PretGoods 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPretGoodsSaveVo res) {
      PretGoods entity = new PretGoods();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据批量删除]</p>
    * Created on 2019年09月15日
    * @param PPretGoodsDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPretGoodsDeleteVo res) {
      PretGoods entity = new PretGoods();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pret获取详情]</p>
    * Created on 2019年09月15日
    * @param PPretGoodsDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPretGoodsDetailVo res) {
        PretGoods entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据更新]</p>
    * Created on 2019年09月15日
    * @param PPretGoodsUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPretGoodsUpdateVo res) {
      PretGoods entity = new PretGoods();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据分页查询]</p>
    * Created on 2019年09月15日
    * @param PPretGoodsQueryVo
    * @return List<PretGoods>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPretGoodsQueryVo res) {
      PretGoodsVo vo = new PretGoodsVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PretGoods> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }
}
