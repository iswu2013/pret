package com.pret.open.vo.req;

import java.util.Date;
import java.util.List;

import com.pret.api.vo.PageFormVo;
import com.pret.api.vo.ReqBody;

/**
 * Description: 下单
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public class P1000000Vo extends ReqBody {
    /**
     * 发货类型0正常发货，1库间调拨
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
    private String  custCd;

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
    private String gw;

    /**
     * 单位(1吨，2公斤)
     */
    private int unit;

    /**
     * 立方体积
     */
    private float cbm;

    /**
     * 货物件数
     */
    private int goodsNum;

    /**
     * 销售备注
     */
    private String remark;

    /**
     * 来源：0，U9,1，OA
     */
    private int dataSource;

    /**
     * 空转单标志位 0:非空转单  1:空转单
     */
    private String preOrderFlag;

    public Integer getTransType() {
        return transType;
    }

    public void setTransType(Integer transType) {
        this.transType = transType;
    }

    public String getTransModeCd() {
        return transModeCd;
    }

    public void setTransModeCd(String transModeCd) {
        this.transModeCd = transModeCd;
    }

    public String getTranModeNm() {
        return tranModeNm;
    }

    public void setTranModeNm(String tranModeNm) {
        this.tranModeNm = tranModeNm;
    }

    public String getDepCd() {
        return depCd;
    }

    public void setDepCd(String depCd) {
        this.depCd = depCd;
    }

    public String getDepNm() {
        return depNm;
    }

    public void setDepNm(String depNm) {
        this.depNm = depNm;
    }

    public String getReqPickupDatetime() {
        return reqPickupDatetime;
    }

    public void setReqPickupDatetime(String reqPickupDatetime) {
        this.reqPickupDatetime = reqPickupDatetime;
    }

    public String getReqDlvDatetime() {
        return reqDlvDatetime;
    }

    public void setReqDlvDatetime(String reqDlvDatetime) {
        this.reqDlvDatetime = reqDlvDatetime;
    }

    public String getDlvOrdNo() {
        return dlvOrdNo;
    }

    public void setDlvOrdNo(String dlvOrdNo) {
        this.dlvOrdNo = dlvOrdNo;
    }

    public String getSalesCd() {
        return salesCd;
    }

    public void setSalesCd(String salesCd) {
        this.salesCd = salesCd;
    }

    public String getSalesNm() {
        return salesNm;
    }

    public void setSalesNm(String salesNm) {
        this.salesNm = salesNm;
    }

    public String getPickupFactoryCd() {
        return pickupFactoryCd;
    }

    public void setPickupFactoryCd(String pickupFactoryCd) {
        this.pickupFactoryCd = pickupFactoryCd;
    }

    public String getOrgProvinceCd() {
        return orgProvinceCd;
    }

    public void setOrgProvinceCd(String orgProvinceCd) {
        this.orgProvinceCd = orgProvinceCd;
    }

    public String getOrgCityCd() {
        return orgCityCd;
    }

    public void setOrgCityCd(String orgCityCd) {
        this.orgCityCd = orgCityCd;
    }

    public String getOrgAreaCd() {
        return orgAreaCd;
    }

    public void setOrgAreaCd(String orgAreaCd) {
        this.orgAreaCd = orgAreaCd;
    }

    public String getCustCd() {
        return custCd;
    }

    public void setCustCd(String custCd) {
        this.custCd = custCd;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustAddr() {
        return custAddr;
    }

    public void setCustAddr(String custAddr) {
        this.custAddr = custAddr;
    }

    public String getCustAttn() {
        return custAttn;
    }

    public void setCustAttn(String custAttn) {
        this.custAttn = custAttn;
    }

    public String getCustTel() {
        return custTel;
    }

    public void setCustTel(String custTel) {
        this.custTel = custTel;
    }

    public String getDestProvinceCd() {
        return destProvinceCd;
    }

    public void setDestProvinceCd(String destProvinceCd) {
        this.destProvinceCd = destProvinceCd;
    }

    public String getDestCityCd() {
        return destCityCd;
    }

    public void setDestCityCd(String destCityCd) {
        this.destCityCd = destCityCd;
    }

    public String getDestAreaCd() {
        return destAreaCd;
    }

    public void setDestAreaCd(String destAreaCd) {
        this.destAreaCd = destAreaCd;
    }

    public String getPartNo() {
        return partNo;
    }

    public void setPartNo(String partNo) {
        this.partNo = partNo;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getGw() {
        return gw;
    }

    public void setGw(String gw) {
        this.gw = gw;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public float getCbm() {
        return cbm;
    }

    public void setCbm(float cbm) {
        this.cbm = cbm;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getDataSource() {
        return dataSource;
    }

    public void setDataSource(int dataSource) {
        this.dataSource = dataSource;
    }

    public String getPreOrderFlag() {
        return preOrderFlag;
    }

    public void setPreOrderFlag(String preOrderFlag) {
        this.preOrderFlag = preOrderFlag;
    }
}
