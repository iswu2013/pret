package com.pret.open.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.constant.Constants;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.common.util.NoUtil;
import com.pret.common.util.StringUtil;
import com.pret.open.entity.PretPickUpPlan;
import com.pret.open.entity.PretTransOrder;
import com.pret.open.entity.bo.PretPickUpPlanBo;
import com.pret.open.entity.bo.PretTransPlanBo;
import com.pret.open.entity.vo.PretPickUpPlanVo;
import com.pret.open.repository.PretTransOrderRepository;
import com.pret.open.vo.req.*;
import com.pret.open.repository.PretPickUpPlanRepository;
import com.pret.api.service.impl.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
public class PretPickUpPlanService extends BaseServiceImpl<PretPickUpPlanRepository, PretPickUpPlan, PretPickUpPlanVo>{
    @Autowired
    private PretTransOrderRepository transOrderRepository;

    /**
    * <p>Discription:[pret数据新增]</p>
    * Created on 2019年09月15日
    * @param PPretPickUpPlanSaveVo pret数据
    * @return PretPickUpPlan 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPretPickUpPlanSaveVo res) {
      PretPickUpPlan entity = new PretPickUpPlan();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据批量删除]</p>
    * Created on 2019年09月15日
    * @param PPretPickUpPlanDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPretPickUpPlanDeleteVo res) {
      PretPickUpPlan entity = new PretPickUpPlan();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pret获取详情]</p>
    * Created on 2019年09月15日
    * @param PPretPickUpPlanDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPretPickUpPlanDetailVo res) {
        PretPickUpPlan entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据更新]</p>
    * Created on 2019年09月15日
    * @param PPretPickUpPlanUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPretPickUpPlanUpdateVo res) {
      PretPickUpPlan entity = new PretPickUpPlan();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据分页查询]</p>
    * Created on 2019年09月15日
    * @param PPretPickUpPlanQueryVo
    * @return List<PretPickUpPlan>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPretPickUpPlanQueryVo res) {
      PretPickUpPlanVo vo = new PretPickUpPlanVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PretPickUpPlan> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }

    public PretPickUpPlan genDefaultPretPickUpPlan(String no, String tail) {
        Date date = DateUtils.truncate(new Date(), Calendar.DATE);
        Date endDate = DateUtils.addDays(date, 1);
        PretPickUpPlan pretPickUpPlan = new PretPickUpPlan();

        if (!StringUtils.isEmpty(no)) {
            pretPickUpPlan.setNo(no);
        } else {
            if (StringUtils.isEmpty(tail)) {
                PretPickUpPlan firstOrder = this.repository.findTop1ByCreateTimeLongBetweenOrderByCreateTimeLongDesc(date.getTime(), endDate.getTime());
                if (firstOrder != null) {
                    String str = StringUtil.disposeFrontZero(firstOrder.getNo().substring(19));
                    int intStr = Integer.parseInt(str) + 1;
                    tail = StringUtil.addFrontZero(String.valueOf(intStr), 6);
                } else {
                    tail = Constants.TAIL;
                }
                pretPickUpPlan.setNo(NoUtil.genNo(ConstantEnum.NoTypeEnum.TH.name()) + tail);
            }
        }

        return pretPickUpPlan;
    }

    /* *
     * 功能描述: 生成提货计划
     * 〈〉
     * @Param: [bo]
            * @Return: void
            * @Author: wujingsong
            * @Date: 2019/10/4  2:03 下午
     */
    public void genPickUpPlan(PretPickUpPlanBo bo) {
        String[] idArr = bo.getIds().split(",");
        PretPickUpPlan pretPickUpPlan = this.genDefaultPretPickUpPlan(null,null);
        BeanUtilsExtended.copyProperties(pretPickUpPlan,bo);
        this.repository.save(pretPickUpPlan);
        String venderId=StringUtils.EMPTY;
        for(String id:idArr) {
            PretTransOrder pretTransOrder = transOrderRepository.findById(id).get();
            pretTransOrder.setPickUpPlanId(pretPickUpPlan.getId());
            transOrderRepository.save(pretTransOrder);
            if(StringUtils.isEmpty(venderId)) {
                venderId = pretTransOrder.getVenderId();
            }
        }
        pretPickUpPlan.setVenderId(venderId);
        this.repository.save(pretPickUpPlan);
    }
}
