package com.pret.open.service;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.entity.PretAddress;
import com.pret.open.entity.vo.PretAddressVo;
import com.pret.open.vo.req.*;
import com.pret.open.repository.PretAddressRepository;
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
public class PretAddressService extends BaseServiceImpl<PretAddressRepository, PretAddress, PretAddressVo>{
    /**
    * <p>Discription:[pret数据新增]</p>
    * Created on 2019年09月15日
    * @param PPretAdressSaveVo pret数据
    * @return PretAdress 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPretAdressSaveVo res) {
      PretAddress entity = new PretAddress();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据批量删除]</p>
    * Created on 2019年09月15日
    * @param PPretAdressDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPretAdressDeleteVo res) {
      PretAddress entity = new PretAddress();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pret获取详情]</p>
    * Created on 2019年09月15日
    * @param PPretAdressDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPretAdressDetailVo res) {
        PretAddress entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据更新]</p>
    * Created on 2019年09月15日
    * @param PPretAdressUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPretAdressUpdateVo res) {
      PretAddress entity = new PretAddress();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据分页查询]</p>
    * Created on 2019年09月15日
    * @param PPretAdressQueryVo
    * @return List<PretAdress>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPretAdressQueryVo res) {
      PretAddressVo vo = new PretAddressVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PretAddress> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }
}
