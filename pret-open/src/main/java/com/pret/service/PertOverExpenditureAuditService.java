package com.pret.service;

import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.entity.PertOverExpenditureAudit;
import com.pret.entity.vo.PertOverExpenditureAuditVo;
import com.pret.vo.req.*;
import com.pret.repository.PertOverExpenditureAuditRepository;
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
public class PertOverExpenditureAuditService extends BaseServiceImpl<PertOverExpenditureAuditRepository, PertOverExpenditureAudit, PertOverExpenditureAuditVo>{
    /**
    * <p>Discription:[pert数据新增]</p>
    * Created on 2019年08月29日
    * @param PPertOverExpenditureAuditSaveVo pert数据
    * @return PertOverExpenditureAudit 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPertOverExpenditureAuditSaveVo res) {
      PertOverExpenditureAudit entity = new PertOverExpenditureAudit();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据批量删除]</p>
    * Created on 2019年08月29日
    * @param PPertOverExpenditureAuditDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPertOverExpenditureAuditDeleteVo res) {
      PertOverExpenditureAudit entity = new PertOverExpenditureAudit();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pert获取详情]</p>
    * Created on 2019年08月29日
    * @param PPertOverExpenditureAuditDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPertOverExpenditureAuditDetailVo res) {
        PertOverExpenditureAudit entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据更新]</p>
    * Created on 2019年08月29日
    * @param PPertOverExpenditureAuditUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPertOverExpenditureAuditUpdateVo res) {
      PertOverExpenditureAudit entity = new PertOverExpenditureAudit();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据分页查询]</p>
    * Created on 2019年08月29日
    * @param PPertOverExpenditureAuditQueryVo
    * @return List<PertOverExpenditureAudit>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPertOverExpenditureAuditQueryVo res) {
      PertOverExpenditureAuditVo vo = new PertOverExpenditureAuditVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PertOverExpenditureAudit> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }
}
