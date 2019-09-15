package com.pret.open.service;

import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.entity.PretTransStatement;
import com.pret.open.entity.vo.PretTransStatementVo;
import com.pret.open.vo.req.*;
import com.pret.open.repository.PretTransStatementRepository;
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
public class PretTransStatementService extends BaseServiceImpl<PretTransStatementRepository, PretTransStatement, PretTransStatementVo>{
    /**
    * <p>Discription:[pret数据新增]</p>
    * Created on 2019年09月15日
    * @param PPretTransStatementSaveVo pret数据
    * @return PretTransStatement 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPretTransStatementSaveVo res) {
      PretTransStatement entity = new PretTransStatement();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据批量删除]</p>
    * Created on 2019年09月15日
    * @param PPretTransStatementDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPretTransStatementDeleteVo res) {
      PretTransStatement entity = new PretTransStatement();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pret获取详情]</p>
    * Created on 2019年09月15日
    * @param PPretTransStatementDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPretTransStatementDetailVo res) {
        PretTransStatement entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据更新]</p>
    * Created on 2019年09月15日
    * @param PPretTransStatementUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPretTransStatementUpdateVo res) {
      PretTransStatement entity = new PretTransStatement();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据分页查询]</p>
    * Created on 2019年09月15日
    * @param PPretTransStatementQueryVo
    * @return List<PretTransStatement>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPretTransStatementQueryVo res) {
      PretTransStatementVo vo = new PretTransStatementVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PretTransStatement> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }
}
