package com.pret.service;

import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.entity.PertArea;
import com.pret.entity.vo.PertAreaVo;
import com.pret.vo.req.*;
import com.pret.repository.PertAreaRepository;
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
public class PertAreaService extends BaseServiceImpl<PertAreaRepository, PertArea, PertAreaVo>{
    /**
    * <p>Discription:[pert数据新增]</p>
    * Created on 2019年08月29日
    * @param PPertAreaSaveVo pert数据
    * @return PertArea 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPertAreaSaveVo res) {
      PertArea entity = new PertArea();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据批量删除]</p>
    * Created on 2019年08月29日
    * @param PPertAreaDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPertAreaDeleteVo res) {
      PertArea entity = new PertArea();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pert获取详情]</p>
    * Created on 2019年08月29日
    * @param PPertAreaDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPertAreaDetailVo res) {
        PertArea entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据更新]</p>
    * Created on 2019年08月29日
    * @param PPertAreaUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPertAreaUpdateVo res) {
      PertArea entity = new PertArea();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据分页查询]</p>
    * Created on 2019年08月29日
    * @param PPertAreaQueryVo
    * @return List<PertArea>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPertAreaQueryVo res) {
      PertAreaVo vo = new PertAreaVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PertArea> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }
}
