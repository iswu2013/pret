package com.pret.service;

import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.entity.PertDriver;
import com.pret.entity.vo.PertDriverVo;
import com.pret.vo.req.*;
import com.pret.repository.PertDriverRepository;
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
public class PertDriverService extends BaseServiceImpl<PertDriverRepository, PertDriver, PertDriverVo>{
    /**
    * <p>Discription:[pert数据新增]</p>
    * Created on 2019年08月29日
    * @param PPertDriverSaveVo pert数据
    * @return PertDriver 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPertDriverSaveVo res) {
      PertDriver entity = new PertDriver();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据批量删除]</p>
    * Created on 2019年08月29日
    * @param PPertDriverDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPertDriverDeleteVo res) {
      PertDriver entity = new PertDriver();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pert获取详情]</p>
    * Created on 2019年08月29日
    * @param PPertDriverDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPertDriverDetailVo res) {
        PertDriver entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据更新]</p>
    * Created on 2019年08月29日
    * @param PPertDriverUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPertDriverUpdateVo res) {
      PertDriver entity = new PertDriver();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据分页查询]</p>
    * Created on 2019年08月29日
    * @param PPertDriverQueryVo
    * @return List<PertDriver>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPertDriverQueryVo res) {
      PertDriverVo vo = new PertDriverVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PertDriver> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }
}
