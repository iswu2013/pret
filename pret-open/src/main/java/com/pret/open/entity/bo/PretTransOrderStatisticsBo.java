package com.pret.open.entity.bo;

import com.pret.common.VersionedAuditableIdEntity;
import com.pret.common.constant.ConstantEnum;
import com.pret.open.entity.PretTransOrderStatistics;
import com.wuwenze.poi.annotation.Excel;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * <p>Description: 订单统计</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Data
public class PretTransOrderStatisticsBo {
    private int todayCount;
    private int thisMonthCount;
    private int totalCount;
    List<PretTransOrderStatistics> pretTransOrderStatisticsList;
}
