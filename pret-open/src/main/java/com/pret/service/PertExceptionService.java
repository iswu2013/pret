package com.pret.service;

import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.entity.PertException;
import com.pret.entity.vo.PertExceptionVo;
import com.pret.vo.req.*;
import com.pret.repository.PertExceptionRepository;
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
public class PertExceptionService extends BaseServiceImpl<PertExceptionRepository, PertException, PertExceptionVo>{
    /**
    * <p>Discription:[pert数据新增]</p>
    * Created on 2019年08月29日
    * @param PPertExceptionSaveVo pert数据
    * @return PertException 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPertExceptionSaveVo res) {
      PertException entity = new PertException();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据批量删除]</p>
    * Created on 2019年08月29日
    * @param PPertExceptionDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPertExceptionDeleteVo res) {
      PertException entity = new PertException();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pert获取详情]</p>
    * Created on 2019年08月29日
    * @param PPertExceptionDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPertExceptionDetailVo res) {
        PertException entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据更新]</p>
    * Created on 2019年08月29日
    * @param PPertExceptionUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPertExceptionUpdateVo res) {
      PertException entity = new PertException();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据分页查询]</p>
    * Created on 2019年08月29日
    * @param PPertExceptionQueryVo
    * @return List<PertException>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPertExceptionQueryVo res) {
      PertExceptionVo vo = new PertExceptionVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PertException> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }
}
