package com.pret.service;

import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.entity.PertTransTrajectory;
import com.pret.entity.vo.PertTransTrajectoryVo;
import com.pret.vo.req.*;
import com.pret.repository.PertTransTrajectoryRepository;
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
public class PertTransTrajectoryService extends BaseServiceImpl<PertTransTrajectoryRepository, PertTransTrajectory, PertTransTrajectoryVo>{
    /**
    * <p>Discription:[pert数据新增]</p>
    * Created on 2019年08月29日
    * @param PPertTransTrajectorySaveVo pert数据
    * @return PertTransTrajectory 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPertTransTrajectorySaveVo res) {
      PertTransTrajectory entity = new PertTransTrajectory();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据批量删除]</p>
    * Created on 2019年08月29日
    * @param PPertTransTrajectoryDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPertTransTrajectoryDeleteVo res) {
      PertTransTrajectory entity = new PertTransTrajectory();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pert获取详情]</p>
    * Created on 2019年08月29日
    * @param PPertTransTrajectoryDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPertTransTrajectoryDetailVo res) {
        PertTransTrajectory entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据更新]</p>
    * Created on 2019年08月29日
    * @param PPertTransTrajectoryUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPertTransTrajectoryUpdateVo res) {
      PertTransTrajectory entity = new PertTransTrajectory();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pert数据分页查询]</p>
    * Created on 2019年08月29日
    * @param PPertTransTrajectoryQueryVo
    * @return List<PertTransTrajectory>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPertTransTrajectoryQueryVo res) {
      PertTransTrajectoryVo vo = new PertTransTrajectoryVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PertTransTrajectory> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }
}
