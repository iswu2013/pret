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
public class PPretQuotationItemUpdateVo extends PageFormVo {
    /**
    * 
    */
    private String id;
    /**
    * 供应商id
    */
    private String venderId;
    /**
    * 报价id
    */
    private String quotationId;
    /**
    * 起运地id
    */
    private String serviceRouteOriginId;
    /**
    * 线路明细id
    */
    private String serviceRouteItemId;
    /**
    * 计费区间项id
    */
    private String billingIntervalItemId;
    /**
    * 
    */
    private java.math.BigDecimal quotation;
    /**
    * 
    */
    private Integer costType;
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
* <p>Discription:[报价id]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getQuotationId(){
return quotationId;
}
/**
* <p>Discription:[报价id]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setQuotationId(String quotationId){
this.quotationId = quotationId;
}
/**
* <p>Discription:[起运地id]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getServiceRouteOriginId(){
return serviceRouteOriginId;
}
/**
* <p>Discription:[起运地id]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setServiceRouteOriginId(String serviceRouteOriginId){
this.serviceRouteOriginId = serviceRouteOriginId;
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
* <p>Discription:[计费区间项id]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getBillingIntervalItemId(){
return billingIntervalItemId;
}
/**
* <p>Discription:[计费区间项id]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setBillingIntervalItemId(String billingIntervalItemId){
this.billingIntervalItemId = billingIntervalItemId;
}
/**
* <p>Discription:[]</p>
* Created on 2019年09月15日
* @return java.math.BigDecimal
* @author:wujinsong
*/
public java.math.BigDecimal getQuotation(){
return quotation;
}
/**
* <p>Discription:[]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setQuotation(java.math.BigDecimal quotation){
this.quotation = quotation;
}
/**
* <p>Discription:[]</p>
* Created on 2019年09月15日
* @return Integer
* @author:wujinsong
*/
public Integer getCostType(){
return costType;
}
/**
* <p>Discription:[]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setCostType(Integer costType){
this.costType = costType;
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
