package com.pret.service;

import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.entity.PertOrderAdditionalCosts;
import com.pret.entity.vo.PertOrderAdditionalCostsVo;
import com.pret.vo.req.*;
import com.pret.repository.PertOrderAdditionalCostsRepository;
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
public class PertOrderAdditionalCostsService extends BaseServiceImpl<PertOrderAdditionalCostsRepository, PertOrderAdditionalCosts, PertOrderAdditionalCostsVo>{
    /**
    * <p>Discription:[pert数据新增]</p>
    * Created on 2019年08月29日
    * @param PPertOrderAdditionalCostsSaveVo pert数据
    * @return PertOrderAdditionalCosts 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPertOrderAdditionalCostsSaveVo res) {
      PertOrderAdditionalCosts entity = new PertOrderAdditionalCosts();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据批量删除]</p>
    * Created on 2019年08月29日
    * @param PPertOrderAdditionalCostsDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPertOrderAdditionalCostsDeleteVo res) {
      PertOrderAdditionalCosts entity = new PertOrderAdditionalCosts();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pert获取详情]</p>
    * Created on 2019年08月29日
    * @param PPertOrderAdditionalCostsDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPertOrderAdditionalCostsDetailVo res) {
        PertOrderAdditionalCosts entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据更新]</p>
    * Created on 2019年08月29日
    * @param PPertOrderAdditionalCostsUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPertOrderAdditionalCostsUpdateVo res) {
      PertOrderAdditionalCosts entity = new PertOrderAdditionalCosts();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据分页查询]</p>
    * Created on 2019年08月29日
    * @param PPertOrderAdditionalCostsQueryVo
    * @return List<PertOrderAdditionalCosts>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPertOrderAdditionalCostsQueryVo res) {
      PertOrderAdditionalCostsVo vo = new PertOrderAdditionalCostsVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PertOrderAdditionalCosts> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }
}
