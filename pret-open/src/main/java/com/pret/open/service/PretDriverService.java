package com.pret.open.service;

import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.entity.PretDriver;
import com.pret.open.entity.vo.PretDriverVo;
import com.pret.open.vo.req.*;
import com.pret.open.repository.PretDriverRepository;
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
public class PretDriverService extends BaseServiceImpl<PretDriverRepository, PretDriver, PretDriverVo>{
    /**
    * <p>Discription:[pret数据新增]</p>
    * Created on 2019年09月15日
    * @param PPretDriverSaveVo pret数据
    * @return PretDriver 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPretDriverSaveVo res) {
      PretDriver entity = new PretDriver();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据批量删除]</p>
    * Created on 2019年09月15日
    * @param PPretDriverDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPretDriverDeleteVo res) {
      PretDriver entity = new PretDriver();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pret获取详情]</p>
    * Created on 2019年09月15日
    * @param PPretDriverDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPretDriverDetailVo res) {
        PretDriver entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据更新]</p>
    * Created on 2019年09月15日
    * @param PPretDriverUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPretDriverUpdateVo res) {
      PretDriver entity = new PretDriver();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据分页查询]</p>
    * Created on 2019年09月15日
    * @param PPretDriverQueryVo
    * @return List<PretDriver>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPretDriverQueryVo res) {
      PretDriverVo vo = new PretDriverVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PretDriver> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }
}
