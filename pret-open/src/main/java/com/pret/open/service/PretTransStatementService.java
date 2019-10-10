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
import com.pret.open.entity.PretTransFee;
import com.pret.open.entity.PretTransOrder;
import com.pret.open.entity.PretTransStatement;
import com.pret.open.entity.bo.PretTransStatementBo;
import com.pret.open.entity.vo.PretTransStatementVo;
import com.pret.open.repository.PretTransFeeRepository;
import com.pret.open.vo.req.*;
import com.pret.open.repository.PretTransStatementRepository;
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
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class PretTransStatementService extends BaseServiceImpl<PretTransStatementRepository, PretTransStatement, PretTransStatementVo> {
    @Autowired
    private PretTransFeeRepository transFeeRepository;
    @Autowired
    private PretTransStatementRepository transStatementRepository;

    /**
     * <p>Discription:[pret数据新增]</p>
     * Created on 2019年09月15日
     *
     * @param PPretTransStatementSaveVo pret数据
     * @return PretTransStatement 添加成功的对象
     * @author:wujinsong
     */
    public ResBody save(PPretTransStatementSaveVo res) {
        PretTransStatement entity = new PretTransStatement();
        BeanUtilsExtended.copyProperties(entity, res);
        this.repository.save(entity);
        return new ResBody().setData(entity);
    }

    /**
     * <p>Discription:[pret数据批量删除]</p>
     * Created on 2019年09月15日
     *
     * @param PPretTransStatementDeleteVo
     * @return ResBody
     * @author:wujinsong
     */
    public ResBody delete(PPretTransStatementDeleteVo res) {
        PretTransStatement entity = new PretTransStatement();
        this.repository.save(entity);
        return new ResBody();
    }

    /**
     * <p>Discription:[pret获取详情]</p>
     * Created on 2019年09月15日
     *
     * @param PPretTransStatementDetailVo
     * @return ResBody
     * @author:wujinsong
     */
    public ResBody detail(PPretTransStatementDetailVo res) {
        PretTransStatement entity = this.repository.findById(res.getId()).get();
        return new ResBody().setData(entity);
    }

    /**
     * <p>Discription:[pret数据更新]</p>
     * Created on 2019年09月15日
     *
     * @param PPretTransStatementUpdateVo
     * @return ResBody
     * @author:wujinsong
     */
    public ResBody update(PPretTransStatementUpdateVo res) {
        PretTransStatement entity = new PretTransStatement();
        BeanUtilsExtended.copyProperties(entity, res);
        this.repository.save(entity);
        return new ResBody().setData(entity);
    }

    /**
     * <p>Discription:[pret数据分页查询]</p>
     * Created on 2019年09月15日
     *
     * @param PPretTransStatementQueryVo
     * @return List<PretTransStatement>数据
     * @author:wujinsong
     */
    public ResBody query(PPretTransStatementQueryVo res) {
        PretTransStatementVo vo = new PretTransStatementVo();
        vo.setPage(res.getPage());
        vo.setRows(res.getRows());
        Page<PretTransStatement> page = this.page(vo);
        return new ResBody().setData(page.getContent());
    }

    public PretTransStatement genDefaultPretPickUpPlan(String no, String tail) {
        Date date = DateUtils.truncate(new Date(), Calendar.DATE);
        Date endDate = DateUtils.addDays(date, 1);
        PretTransStatement transStatement = new PretTransStatement();

        if (!StringUtils.isEmpty(no)) {
            transStatement.setNo(no);
        } else {
            if (StringUtils.isEmpty(tail)) {
                PretTransStatement firstOrder = this.repository.findTop1ByCreateTimeLongBetweenOrderByCreateTimeLongDesc(date.getTime(), endDate.getTime());
                if (firstOrder != null) {
                    String str = StringUtil.disposeFrontZero(firstOrder.getNo().substring(19));
                    int intStr = Integer.parseInt(str) + 1;
                    tail = StringUtil.addFrontZero(String.valueOf(intStr), 6);
                } else {
                    tail = Constants.TAIL;
                }
                transStatement.setNo(NoUtil.genNo(ConstantEnum.NoTypeEnum.TH.name()) + tail);
            }
        }

        return transStatement;
    }

    /* *
     * 功能描述: 生成对账作业
     * 〈〉
     * @Param: [bo]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/10/4  5:43 下午
     */
    public void genTransStatement(PretTransStatementBo bo) {
        String[] idArr = bo.getIds().split(",");
        PretTransStatement transStatement = this.genDefaultPretPickUpPlan(null, null);
        BeanUtilsExtended.copyProperties(transStatement, bo);
        transStatement.setStatus(ConstantEnum.ETransStatementStatus.待确认.getLabel());
        this.repository.save(transStatement);

        for (String id : idArr) {
            PretTransFee transFee = transFeeRepository.findById(id).get();
            transFee.setTransStatementId(transStatement.getId());
            transFeeRepository.save(transFee);
        }
    }

    /* *
     * 功能描述: 对账确认
     * 〈〉
     * @Param: [ids]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/10/4  5:48 下午
     */
    public void confirmStatement(String ids) {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            PretTransStatement transStatement = transStatementRepository.findById(id).get();
            transStatement.setStatus(ConstantEnum.ETransStatementStatus.已转U9.getLabel());
            transStatementRepository.save(transStatement);
        }
    }
}
