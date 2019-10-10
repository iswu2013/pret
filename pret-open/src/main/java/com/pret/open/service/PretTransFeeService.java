package com.pret.open.service;

import java.math.BigDecimal;
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
import com.pret.open.entity.PretTransFee;
import com.pret.open.entity.PretTransPlan;
import com.pret.open.entity.vo.PretTransFeeVo;
import com.pret.open.vo.req.*;
import com.pret.open.repository.PretTransFeeRepository;
import com.pret.api.service.impl.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
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
public class PretTransFeeService extends BaseServiceImpl<PretTransFeeRepository, PretTransFee, PretTransFeeVo>{
    /**
    * <p>Discription:[pret数据新增]</p>
    * Created on 2019年09月15日
    * @param PPretTransFeeSaveVo pret数据
    * @return PretTransFee 添加成功的对象
    * @author:wujinsong
    */
    public ResBody save(PPretTransFeeSaveVo res) {
      PretTransFee entity = new PretTransFee();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据批量删除]</p>
    * Created on 2019年09月15日
    * @param PPretTransFeeDeleteVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody delete(PPretTransFeeDeleteVo res) {
      PretTransFee entity = new PretTransFee();
      this.repository.save(entity);
      return new ResBody();
    }

    /**
    * <p>Discription:[pret获取详情]</p>
    * Created on 2019年09月15日
    * @param PPretTransFeeDetailVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody detail(PPretTransFeeDetailVo res) {
        PretTransFee entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据更新]</p>
    * Created on 2019年09月15日
    * @param PPretTransFeeUpdateVo
    * @return ResBody
    *
    * @author:wujinsong
    */
    public ResBody update(PPretTransFeeUpdateVo res) {
      PretTransFee entity = new PretTransFee();
      BeanUtilsExtended.copyProperties(entity,res);
      this.repository.save(entity);
      return new ResBody().setData(entity);
    }

    /**
    * <p>Discription:[pret数据分页查询]</p>
    * Created on 2019年09月15日
    * @param PPretTransFeeQueryVo
    * @return List<PretTransFee>数据
     *
     * @author:wujinsong
     */
    public ResBody query(PPretTransFeeQueryVo res) {
      PretTransFeeVo vo = new PretTransFeeVo();
      vo.setPage(res.getPage());
      vo.setRows(res.getRows());
      Page<PretTransFee> page = this.page(vo);
      return new ResBody().setData(page.getContent());
     }

    public PretTransFee genDefaultPretTransFee(String no, String tail) {
        Date date = DateUtils.truncate(new Date(), Calendar.DATE);
        Date endDate = DateUtils.addDays(date, 1);
        PretTransFee transFee = new PretTransFee();

        if (!StringUtils.isEmpty(no)) {
            transFee.setNo(no);
        } else {
            if (StringUtils.isEmpty(tail)) {
                PretTransFee firstOrder = this.repository.findTop1ByCreateTimeLongBetweenOrderByCreateTimeLongDesc(date.getTime(), endDate.getTime());
                if (firstOrder != null) {
                    String str = StringUtil.disposeFrontZero(firstOrder.getNo().substring(19));
                    int intStr = Integer.parseInt(str) + 1;
                    tail = StringUtil.addFrontZero(String.valueOf(intStr), 6);
                } else {
                    tail = Constants.TAIL;
                }
                transFee.setNo(NoUtil.genNo(ConstantEnum.NoTypeEnum.TF.name()) + tail);
            }
        }

        return transFee;
    }



    /* *
     * 功能描述: 费用申报
     * 〈〉
     * @Param: [ids]
            * @Return: void
            * @Author: wujingsong
            * @Date: 2019/10/4  5:29 下午
     */
    public void transFeeAppl(String ids) {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            PretTransFee transFee = this.repository.findById(id).get();
            transFee.setStatus(ConstantEnum.EPretTransFeeStatus.已申报.getLabel());
            this.repository.save(transFee);
        }
    }
}
