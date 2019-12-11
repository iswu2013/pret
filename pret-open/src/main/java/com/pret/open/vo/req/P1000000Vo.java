package com.pret.open.vo.req;

import com.pret.api.vo.ReqBody;
import com.pret.common.constant.ConstantEnum;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;

/**
 * Description: 下单
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Data
public class P1000000Vo extends ReqBody {

    /**
     * 发货类型0正常发货，1库间调拨，2退货
     */
    private Integer transType;

    /**
     * 运输方式Code(U9 Code)
     */
    private String transModeCd;

    /**
     * 运输方式名称
     */
    private String tranModeNm;
    /**
     * 业务部门
     */
    private String depCd;

    /**
     * 部门名称
     */
    private String depNm;

    /**
     * 要求提货时间
     */
    private String reqPickupDatetime;

    /**
     * 要求送达时间
     */
    private String reqDlvDatetime;

    /**
     * 送货单号
     */
    private String dlvOrdNo;

    /**
     * 业务员(U9 Code)
     */
    private String salesCd;

    /**
     * 业务员名称
     */
    private String salesNm;

    /**
     * PRET提货工厂Code(U9 Code)
     */
    private String pickupFactoryCd;

    /**
     * 起运地省份code(U9 Code)
     */
    private String orgProvinceCd;

    /**
     * 起运地城市code(U9 Code)
     */
    private String orgCityCd;

    /**
     * 起运地县/区code(U9 Code)
     */
    private String orgAreaCd;

    /**
     * 客户代码
     */
    private String custCd;

    /**
     * 客户名称
     */
    private String custName;
    /**
     * 客户详细地址
     */
    private String custAddr;
    /**
     * 客户联系人
     */
    private String custAttn;
    /**
     * 客户联系人电话
     */
    private String custTel;

    /**
     * 客户地址省份code(U9 Code)
     */
    private String destProvinceCd;

    /**
     * 客户地址城市code(U9 Code)
     */
    private String destCityCd;

    /**
     * 客户地址县/区code（U9 code）
     */
    private String destAreaCd;

    /**
     * 料号
     */
    private String partNo;

    /**
     * 批号
     */
    private String batchNo;

    /**
     * 产品名
     */
    private String product;

    /**
     * 重量
     */
    private Float gw;

    /**
     * 单位(1吨，2公斤)
     */
    private int unit = ConstantEnum.EUnit.公斤.getLabel();

    /**
     * 立方体积
     */
    private float cbm;

    /**
     * 货物件数
     */
    private int goodsNum;

    /**
     * U9或OA唯一码
     */
    private String sourceCode;

    /**
     * 销售备注
     */
    private String remark;

    /**
     * 来源：1U9,2OA
     */
    private int dataSource;

    /**
     * 空转单标志位 0:非空转单  1:空转单
     */
    private String preOrderFlag;

    /**
     * 起运地大区(U9 Code)
     */
    private String orgBigAreaCd;

    /**
     * 客户地址所在大区(U9 Code)
     */
    private String destBigAreaCd;

    /**
     * 总量
     */
    private Float totalGw;

    /**
     * 明细
     */
    private String itemListStr;

    /**
     * 所属工厂code
     */
    private String ownFactoryCd;

    /**
     * 总体积.(加总明细档中的CBM)
     */
    private Float totalCbm;

    /**
     * 总件数.(加总明细档中的goodsNum)
     */
    private Integer totalPkg;
}
