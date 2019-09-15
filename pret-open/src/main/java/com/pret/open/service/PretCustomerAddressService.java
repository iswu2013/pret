package com.pret.open.service;

import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.entity.PretCustomerAddress;
import com.pret.open.entity.vo.PretCustomerAddressVo;
import com.pret.open.vo.req.*;
import com.pret.open.repository.PretCustomerAddressRepository;
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
public class PretCustomerAddressService extends BaseServiceImpl<PretCustomerAddressRepository, PretCustomerAddress, PretCustomerAddressVo>{
    /**
    * <p>Discription:[pret数据新增]</p>
    * Created on 2019年09月15日
    * @param PPretCustomerAddressSaveVo pret数据
    * @return PretCustomerAddress 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPretCustomerAddressSaveVo res) {
      PretCustomerAddress entity = new PretCustomerAddress();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据批量删除]</p>
    * Created on 2019年09月15日
    * @param PPretCustomerAddressDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPretCustomerAddressDeleteVo res) {
      PretCustomerAddress entity = new PretCustomerAddress();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pret获取详情]</p>
    * Created on 2019年09月15日
    * @param PPretCustomerAddressDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPretCustomerAddressDetailVo res) {
        PretCustomerAddress entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据更新]</p>
    * Created on 2019年09月15日
    * @param PPretCustomerAddressUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPretCustomerAddressUpdateVo res) {
      PretCustomerAddress entity = new PretCustomerAddress();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据分页查询]</p>
    * Created on 2019年09月15日
    * @param PPretCustomerAddressQueryVo
    * @return List<PretCustomerAddress>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPretCustomerAddressQueryVo res) {
      PretCustomerAddressVo vo = new PretCustomerAddressVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PretCustomerAddress> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }
}
