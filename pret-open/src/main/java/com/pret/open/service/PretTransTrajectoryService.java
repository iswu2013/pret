package com.pret.open.service;

import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.entity.PretTransTrajectory;
import com.pret.open.entity.vo.PretTransTrajectoryVo;
import com.pret.open.vo.req.*;
import com.pret.open.repository.PretTransTrajectoryRepository;
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
public class PretTransTrajectoryService extends BaseServiceImpl<PretTransTrajectoryRepository, PretTransTrajectory, PretTransTrajectoryVo>{
    /**
    * <p>Discription:[pret数据新增]</p>
    * Created on 2019年09月15日
    * @param PPretTransTrajectorySaveVo pret数据
    * @return PretTransTrajectory 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPretTransTrajectorySaveVo res) {
      PretTransTrajectory entity = new PretTransTrajectory();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据批量删除]</p>
    * Created on 2019年09月15日
    * @param PPretTransTrajectoryDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPretTransTrajectoryDeleteVo res) {
      PretTransTrajectory entity = new PretTransTrajectory();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pret获取详情]</p>
    * Created on 2019年09月15日
    * @param PPretTransTrajectoryDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPretTransTrajectoryDetailVo res) {
        PretTransTrajectory entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据更新]</p>
    * Created on 2019年09月15日
    * @param PPretTransTrajectoryUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPretTransTrajectoryUpdateVo res) {
      PretTransTrajectory entity = new PretTransTrajectory();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据分页查询]</p>
    * Created on 2019年09月15日
    * @param PPretTransTrajectoryQueryVo
    * @return List<PretTransTrajectory>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPretTransTrajectoryQueryVo res) {
      PretTransTrajectoryVo vo = new PretTransTrajectoryVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PretTransTrajectory> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }
}
