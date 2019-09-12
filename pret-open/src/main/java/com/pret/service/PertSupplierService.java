package com.pret.service;

import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.entity.PertSupplier;
import com.pret.entity.vo.PertSupplierVo;
import com.pret.vo.req.*;
import com.pret.repository.PertSupplierRepository;
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
public class PertSupplierService extends BaseServiceImpl<PertSupplierRepository, PertSupplier, PertSupplierVo>{
    /**
    * <p>Discription:[pert数据新增]</p>
    * Created on 2019年08月29日
    * @param PPertSupplierSaveVo pert数据
    * @return PertSupplier 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPertSupplierSaveVo res) {
      PertSupplier entity = new PertSupplier();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据批量删除]</p>
    * Created on 2019年08月29日
    * @param PPertSupplierDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPertSupplierDeleteVo res) {
      PertSupplier entity = new PertSupplier();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pert获取详情]</p>
    * Created on 2019年08月29日
    * @param PPertSupplierDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPertSupplierDetailVo res) {
        PertSupplier entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据更新]</p>
    * Created on 2019年08月29日
    * @param PPertSupplierUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPertSupplierUpdateVo res) {
      PertSupplier entity = new PertSupplier();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据分页查询]</p>
    * Created on 2019年08月29日
    * @param PPertSupplierQueryVo
    * @return List<PertSupplier>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPertSupplierQueryVo res) {
      PertSupplierVo vo = new PertSupplierVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PertSupplier> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }
}
