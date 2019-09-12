package com.pret.service;

import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.entity.PertCustomerUpdate;
import com.pret.entity.vo.PertCustomerUpdateVo;
import com.pret.vo.req.*;
import com.pret.repository.PertCustomerUpdateRepository;
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
public class PertCustomerUpdateService extends BaseServiceImpl<PertCustomerUpdateRepository, PertCustomerUpdate, PertCustomerUpdateVo>{
    /**
    * <p>Discription:[pert数据新增]</p>
    * Created on 2019年08月29日
    * @param PPertCustomerUpdateSaveVo pert数据
    * @return PertCustomerUpdate 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPertCustomerUpdateSaveVo res) {
      PertCustomerUpdate entity = new PertCustomerUpdate();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据批量删除]</p>
    * Created on 2019年08月29日
    * @param PPertCustomerUpdateDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPertCustomerUpdateDeleteVo res) {
      PertCustomerUpdate entity = new PertCustomerUpdate();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pert获取详情]</p>
    * Created on 2019年08月29日
    * @param PPertCustomerUpdateDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPertCustomerUpdateDetailVo res) {
        PertCustomerUpdate entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据更新]</p>
    * Created on 2019年08月29日
    * @param PPertCustomerUpdateUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPertCustomerUpdateUpdateVo res) {
      PertCustomerUpdate entity = new PertCustomerUpdate();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据分页查询]</p>
    * Created on 2019年08月29日
    * @param PPertCustomerUpdateQueryVo
    * @return List<PertCustomerUpdate>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPertCustomerUpdateQueryVo res) {
      PertCustomerUpdateVo vo = new PertCustomerUpdateVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PertCustomerUpdate> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }
}
