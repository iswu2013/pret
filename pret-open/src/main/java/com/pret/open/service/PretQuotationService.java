package com.pret.open.service;

import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.entity.PretQuotation;
import com.pret.open.entity.vo.PretQuotationVo;
import com.pret.open.vo.req.*;
import com.pret.open.repository.PretQuotationRepository;
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
public class PretQuotationService extends BaseServiceImpl<PretQuotationRepository, PretQuotation, PretQuotationVo>{
    /**
    * <p>Discription:[pret数据新增]</p>
    * Created on 2019年09月15日
    * @param PPretQuotationSaveVo pret数据
    * @return PretQuotation 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPretQuotationSaveVo res) {
      PretQuotation entity = new PretQuotation();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据批量删除]</p>
    * Created on 2019年09月15日
    * @param PPretQuotationDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPretQuotationDeleteVo res) {
      PretQuotation entity = new PretQuotation();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pret获取详情]</p>
    * Created on 2019年09月15日
    * @param PPretQuotationDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPretQuotationDetailVo res) {
        PretQuotation entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据更新]</p>
    * Created on 2019年09月15日
    * @param PPretQuotationUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPretQuotationUpdateVo res) {
      PretQuotation entity = new PretQuotation();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据分页查询]</p>
    * Created on 2019年09月15日
    * @param PPretQuotationQueryVo
    * @return List<PretQuotation>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPretQuotationQueryVo res) {
      PretQuotationVo vo = new PretQuotationVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PretQuotation> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }
}
