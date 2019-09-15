package com.pret.open.vo.req;

import java.util.List;

import com.pret.api.vo.PageFormVo;

/**
 * Description: [pret服务]
 * Created on 2019年09月15日
 * @author  <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0 
 * Copyright (c) 2019年 极客城堡
 */
public class PPretTransPlanSaveVo extends PageFormVo {
    /**
    * 
    */
    private String id;
    /**
    * 单号
    */
    private String no;
    /**
    * 供应商id
    */
    private String venderId;
    /**
    * 客户id
    */
    private String customerId;
    /**
    * 预计提货日期
    */
    private java.util.Date transDatetime;
    /**
    * 原始运输计划id,针对异常退货
    */
    private String orginId;
    /**
    * 起运地id
    */
    private String orgId;
    /**
    * 起运地
    */
    private String orgAddress;
    /**
    * 目的地id
    */
    private String destId;
    /**
    * 目的地
    */
    private String destAddress;
    /**
    * 司机id
    */
    private String driverId;
    /**
    * 提货数量
    */
    private Integer count;
    /**
    * 重物数量
    */
    private Integer gw;
    /**
    * 重物单位重
    */
    private String cbm;
    /**
    * 泡物数量
    */
    private Integer cw;
    /**
    * 泡物单位立方
    */
    private String unit;
    /**
    * 线路明细id
    */
    private String serviceRouteItemId;
    /**
    * 报价明细id
    */
    private String quotationItemId;
    /**
    * 运输费用id
    */
    private String transFeeId;
    /**
    * 异常id
    */
    private String transExceptionId;
    /**
    * 状态(运输中,已签收)
    */
    private Integer status;
    /**
    * 费用创建人
    */
    private String feeConfirmBy;
    /**
    * 费用创建日期
    */
    private java.util.Date feeConfirmDate;
    /**
    * 创建人
    */
    private String createBy;
    /**
    * 
    */
    private Long createTimeLong;
    /**
    * 
    */
    private String createTimeStr;
    /**
    * 
    */
    private java.util.Date lastModifiedDate;
    /**
    * 
    */
    private Long version;
    /**
    * 0删除1正常
    */
    private Integer s;

// setter and getter
/**
* <p>Discription:[]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getId(){
return id;
}
/**
* <p>Discription:[]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setId(String id){
this.id = id;
}
/**
* <p>Discription:[单号]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getNo(){
return no;
}
/**
* <p>Discription:[单号]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setNo(String no){
this.no = no;
}
/**
* <p>Discription:[供应商id]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getVenderId(){
return venderId;
}
/**
* <p>Discription:[供应商id]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setVenderId(String venderId){
this.venderId = venderId;
}
/**
* <p>Discription:[客户id]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getCustomerId(){
return customerId;
}
/**
* <p>Discription:[客户id]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setCustomerId(String customerId){
this.customerId = customerId;
}
/**
* <p>Discription:[预计提货日期]</p>
* Created on 2019年09月15日
* @return java.util.Date
* @author:wujinsong
*/
public java.util.Date getTransDatetime(){
return transDatetime;
}
/**
* <p>Discription:[预计提货日期]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setTransDatetime(java.util.Date transDatetime){
this.transDatetime = transDatetime;
}
/**
* <p>Discription:[原始运输计划id,针对异常退货]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getOrginId(){
return orginId;
}
/**
* <p>Discription:[原始运输计划id,针对异常退货]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setOrginId(String orginId){
this.orginId = orginId;
}
/**
* <p>Discription:[起运地id]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getOrgId(){
return orgId;
}
/**
* <p>Discription:[起运地id]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setOrgId(String orgId){
this.orgId = orgId;
}
/**
* <p>Discription:[起运地]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getOrgAddress(){
return orgAddress;
}
/**
* <p>Discription:[起运地]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setOrgAddress(String orgAddress){
this.orgAddress = orgAddress;
}
/**
* <p>Discription:[目的地id]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getDestId(){
return destId;
}
/**
* <p>Discription:[目的地id]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setDestId(String destId){
this.destId = destId;
}
/**
* <p>Discription:[目的地]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getDestAddress(){
return destAddress;
}
/**
* <p>Discription:[目的地]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setDestAddress(String destAddress){
this.destAddress = destAddress;
}
/**
* <p>Discription:[司机id]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getDriverId(){
return driverId;
}
/**
* <p>Discription:[司机id]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setDriverId(String driverId){
this.driverId = driverId;
}
/**
* <p>Discription:[提货数量]</p>
* Created on 2019年09月15日
* @return Integer
* @author:wujinsong
*/
public Integer getCount(){
return count;
}
/**
* <p>Discription:[提货数量]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setCount(Integer count){
this.count = count;
}
/**
* <p>Discription:[重物数量]</p>
* Created on 2019年09月15日
* @return Integer
* @author:wujinsong
*/
public Integer getGw(){
return gw;
}
/**
* <p>Discription:[重物数量]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setGw(Integer gw){
this.gw = gw;
}
/**
* <p>Discription:[重物单位重]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getCbm(){
return cbm;
}
/**
* <p>Discription:[重物单位重]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setCbm(String cbm){
this.cbm = cbm;
}
/**
* <p>Discription:[泡物数量]</p>
* Created on 2019年09月15日
* @return Integer
* @author:wujinsong
*/
public Integer getCw(){
return cw;
}
/**
* <p>Discription:[泡物数量]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setCw(Integer cw){
this.cw = cw;
}
/**
* <p>Discription:[泡物单位立方]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getUnit(){
return unit;
}
/**
* <p>Discription:[泡物单位立方]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setUnit(String unit){
this.unit = unit;
}
/**
* <p>Discription:[线路明细id]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getServiceRouteItemId(){
return serviceRouteItemId;
}
/**
* <p>Discription:[线路明细id]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setServiceRouteItemId(String serviceRouteItemId){
this.serviceRouteItemId = serviceRouteItemId;
}
/**
* <p>Discription:[报价明细id]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getQuotationItemId(){
return quotationItemId;
}
/**
* <p>Discription:[报价明细id]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setQuotationItemId(String quotationItemId){
this.quotationItemId = quotationItemId;
}
/**
* <p>Discription:[运输费用id]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getTransFeeId(){
return transFeeId;
}
/**
* <p>Discription:[运输费用id]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setTransFeeId(String transFeeId){
this.transFeeId = transFeeId;
}
/**
* <p>Discription:[异常id]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getTransExceptionId(){
return transExceptionId;
}
/**
* <p>Discription:[异常id]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setTransExceptionId(String transExceptionId){
this.transExceptionId = transExceptionId;
}
/**
* <p>Discription:[状态(运输中,已签收)]</p>
* Created on 2019年09月15日
* @return Integer
* @author:wujinsong
*/
public Integer getStatus(){
return status;
}
/**
* <p>Discription:[状态(运输中,已签收)]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setStatus(Integer status){
this.status = status;
}
/**
* <p>Discription:[费用创建人]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getFeeConfirmBy(){
return feeConfirmBy;
}
/**
* <p>Discription:[费用创建人]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setFeeConfirmBy(String feeConfirmBy){
this.feeConfirmBy = feeConfirmBy;
}
/**
* <p>Discription:[费用创建日期]</p>
* Created on 2019年09月15日
* @return java.util.Date
* @author:wujinsong
*/
public java.util.Date getFeeConfirmDate(){
return feeConfirmDate;
}
/**
* <p>Discription:[费用创建日期]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setFeeConfirmDate(java.util.Date feeConfirmDate){
this.feeConfirmDate = feeConfirmDate;
}
/**
* <p>Discription:[创建人]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getCreateBy(){
return createBy;
}
/**
* <p>Discription:[创建人]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setCreateBy(String createBy){
this.createBy = createBy;
}
/**
* <p>Discription:[]</p>
* Created on 2019年09月15日
* @return Long
* @author:wujinsong
*/
public Long getCreateTimeLong(){
return createTimeLong;
}
/**
* <p>Discription:[]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setCreateTimeLong(Long createTimeLong){
this.createTimeLong = createTimeLong;
}
/**
* <p>Discription:[]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getCreateTimeStr(){
return createTimeStr;
}
/**
* <p>Discription:[]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setCreateTimeStr(String createTimeStr){
this.createTimeStr = createTimeStr;
}
/**
* <p>Discription:[]</p>
* Created on 2019年09月15日
* @return java.util.Date
* @author:wujinsong
*/
public java.util.Date getLastModifiedDate(){
return lastModifiedDate;
}
/**
* <p>Discription:[]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setLastModifiedDate(java.util.Date lastModifiedDate){
this.lastModifiedDate = lastModifiedDate;
}
/**
* <p>Discription:[]</p>
* Created on 2019年09月15日
* @return Long
* @author:wujinsong
*/
public Long getVersion(){
return version;
}
/**
* <p>Discription:[]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setVersion(Long version){
this.version = version;
}
/**
* <p>Discription:[0删除1正常]</p>
* Created on 2019年09月15日
* @return Integer
* @author:wujinsong
*/
public Integer getS(){
return s;
}
/**
* <p>Discription:[0删除1正常]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setS(Integer s){
this.s = s;
}
}
