package com.pret.open.service;

import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.entity.PretCurrency;
import com.pret.open.entity.vo.PretCurrencyVo;
import com.pret.open.vo.req.*;
import com.pret.open.repository.PretCurrencyRepository;
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
public class PretCurrencyService extends BaseServiceImpl<PretCurrencyRepository, PretCurrency, PretCurrencyVo>{
    /**
    * <p>Discription:[pret数据新增]</p>
    * Created on 2019年09月15日
    * @param PPretCurrencySaveVo pret数据
    * @return PretCurrency 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPretCurrencySaveVo res) {
      PretCurrency entity = new PretCurrency();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据批量删除]</p>
    * Created on 2019年09月15日
    * @param PPretCurrencyDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPretCurrencyDeleteVo res) {
      PretCurrency entity = new PretCurrency();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pret获取详情]</p>
    * Created on 2019年09月15日
    * @param PPretCurrencyDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPretCurrencyDetailVo res) {
        PretCurrency entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据更新]</p>
    * Created on 2019年09月15日
    * @param PPretCurrencyUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPretCurrencyUpdateVo res) {
      PretCurrency entity = new PretCurrency();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据分页查询]</p>
    * Created on 2019年09月15日
    * @param PPretCurrencyQueryVo
    * @return List<PretCurrency>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPretCurrencyQueryVo res) {
      PretCurrencyVo vo = new PretCurrencyVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PretCurrency> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }
}
