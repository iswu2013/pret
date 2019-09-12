package com.pret.service;

import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.entity.PertGoods;
import com.pret.entity.vo.PertGoodsVo;
import com.pret.vo.req.*;
import com.pret.repository.PertGoodsRepository;
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
public class PertGoodsService extends BaseServiceImpl<PertGoodsRepository, PertGoods, PertGoodsVo>{
    /**
    * <p>Discription:[pert数据新增]</p>
    * Created on 2019年08月29日
    * @param PPertGoodsSaveVo pert数据
    * @return PertGoods 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPertGoodsSaveVo res) {
      PertGoods entity = new PertGoods();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据批量删除]</p>
    * Created on 2019年08月29日
    * @param PPertGoodsDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPertGoodsDeleteVo res) {
      PertGoods entity = new PertGoods();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pert获取详情]</p>
    * Created on 2019年08月29日
    * @param PPertGoodsDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPertGoodsDetailVo res) {
        PertGoods entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据更新]</p>
    * Created on 2019年08月29日
    * @param PPertGoodsUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPertGoodsUpdateVo res) {
      PertGoods entity = new PertGoods();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据分页查询]</p>
    * Created on 2019年08月29日
    * @param PPertGoodsQueryVo
    * @return List<PertGoods>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPertGoodsQueryVo res) {
      PertGoodsVo vo = new PertGoodsVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PertGoods> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }
}
