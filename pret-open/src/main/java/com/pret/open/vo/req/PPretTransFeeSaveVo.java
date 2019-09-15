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
public class PPretTransFeeSaveVo extends PageFormVo {
    /**
    * 主键id
    */
    private String id;
    /**
    * 供应商id
    */
    private String venderId;
    /**
    * 运输计划id
    */
    private String transPanId;
    /**
    * 客户id
    */
    private String customerId;
    /**
    * 对账单id
    */
    private String transStatementId;
    /**
    * 送货单数量
    */
    private Integer tOrderCount;
    /**
    * 计费数量
    */
    private Integer quotationCount;
    /**
    * 单价
    */
    private java.math.BigDecimal unitPrice;
    /**
    * 总金额
    */
    private java.math.BigDecimal quotation;
    /**
    * 状态(待审核,通过,不通过)
    */
    private Integer status;
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
* <p>Discription:[主键id]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getId(){
return id;
}
/**
* <p>Discription:[主键id]</p>
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
* <p>Discription:[运输计划id]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getTransPanId(){
return transPanId;
}
/**
* <p>Discription:[运输计划id]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setTransPanId(String transPanId){
this.transPanId = transPanId;
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
* <p>Discription:[对账单id]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getTransStatementId(){
return transStatementId;
}
/**
* <p>Discription:[对账单id]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setTransStatementId(String transStatementId){
this.transStatementId = transStatementId;
}
/**
* <p>Discription:[送货单数量]</p>
* Created on 2019年09月15日
* @return Integer
* @author:wujinsong
*/
public Integer getTOrderCount(){
return tOrderCount;
}
/**
* <p>Discription:[送货单数量]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setTOrderCount(Integer tOrderCount){
this.tOrderCount = tOrderCount;
}
/**
* <p>Discription:[计费数量]</p>
* Created on 2019年09月15日
* @return Integer
* @author:wujinsong
*/
public Integer getQuotationCount(){
return quotationCount;
}
/**
* <p>Discription:[计费数量]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setQuotationCount(Integer quotationCount){
this.quotationCount = quotationCount;
}
/**
* <p>Discription:[单价]</p>
* Created on 2019年09月15日
* @return java.math.BigDecimal
* @author:wujinsong
*/
public java.math.BigDecimal getUnitPrice(){
return unitPrice;
}
/**
* <p>Discription:[单价]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setUnitPrice(java.math.BigDecimal unitPrice){
this.unitPrice = unitPrice;
}
/**
* <p>Discription:[总金额]</p>
* Created on 2019年09月15日
* @return java.math.BigDecimal
* @author:wujinsong
*/
public java.math.BigDecimal getQuotation(){
return quotation;
}
/**
* <p>Discription:[总金额]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setQuotation(java.math.BigDecimal quotation){
this.quotation = quotation;
}
/**
* <p>Discription:[状态(待审核,通过,不通过)]</p>
* Created on 2019年09月15日
* @return Integer
* @author:wujinsong
*/
public Integer getStatus(){
return status;
}
/**
* <p>Discription:[状态(待审核,通过,不通过)]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setStatus(Integer status){
this.status = status;
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
