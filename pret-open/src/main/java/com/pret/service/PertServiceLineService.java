package com.pret.service;

import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.entity.PertServiceLine;
import com.pret.entity.vo.PertServiceLineVo;
import com.pret.vo.req.*;
import com.pret.repository.PertServiceLineRepository;
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
public class PertServiceLineService extends BaseServiceImpl<PertServiceLineRepository, PertServiceLine, PertServiceLineVo>{
    /**
    * <p>Discription:[pert数据新增]</p>
    * Created on 2019年08月29日
    * @param PPertServiceLineSaveVo pert数据
    * @return PertServiceLine 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPertServiceLineSaveVo res) {
      PertServiceLine entity = new PertServiceLine();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据批量删除]</p>
    * Created on 2019年08月29日
    * @param PPertServiceLineDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPertServiceLineDeleteVo res) {
      PertServiceLine entity = new PertServiceLine();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pert获取详情]</p>
    * Created on 2019年08月29日
    * @param PPertServiceLineDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPertServiceLineDetailVo res) {
        PertServiceLine entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据更新]</p>
    * Created on 2019年08月29日
    * @param PPertServiceLineUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPertServiceLineUpdateVo res) {
      PertServiceLine entity = new PertServiceLine();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据分页查询]</p>
    * Created on 2019年08月29日
    * @param PPertServiceLineQueryVo
    * @return List<PertServiceLine>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPertServiceLineQueryVo res) {
      PertServiceLineVo vo = new PertServiceLineVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PertServiceLine> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }
}
