package com.pret.open.service;

import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.entity.PretPickUpAddress;
import com.pret.open.entity.vo.PretPickUpAddressVo;
import com.pret.open.vo.req.*;
import com.pret.open.repository.PretPickUpAddressRepository;
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
public class PretPickUpAddressService extends BaseServiceImpl<PretPickUpAddressRepository, PretPickUpAddress, PretPickUpAddressVo>{
    /**
    * <p>Discription:[pret数据新增]</p>
    * Created on 2019年09月15日
    * @param PPretPickUpAddressSaveVo pret数据
    * @return PretPickUpAddress 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPretPickUpAddressSaveVo res) {
      PretPickUpAddress entity = new PretPickUpAddress();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据批量删除]</p>
    * Created on 2019年09月15日
    * @param PPretPickUpAddressDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPretPickUpAddressDeleteVo res) {
      PretPickUpAddress entity = new PretPickUpAddress();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pret获取详情]</p>
    * Created on 2019年09月15日
    * @param PPretPickUpAddressDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPretPickUpAddressDetailVo res) {
        PretPickUpAddress entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据更新]</p>
    * Created on 2019年09月15日
    * @param PPretPickUpAddressUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPretPickUpAddressUpdateVo res) {
      PretPickUpAddress entity = new PretPickUpAddress();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据分页查询]</p>
    * Created on 2019年09月15日
    * @param PPretPickUpAddressQueryVo
    * @return List<PretPickUpAddress>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPretPickUpAddressQueryVo res) {
      PretPickUpAddressVo vo = new PretPickUpAddressVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PretPickUpAddress> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }
}
