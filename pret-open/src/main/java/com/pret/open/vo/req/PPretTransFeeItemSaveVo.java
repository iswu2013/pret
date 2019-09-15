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
public class PPretTransFeeItemSaveVo extends PageFormVo {
    /**
    * 
    */
    private String id;
    /**
    * 供应商id
    */
    private String venderId;
    /**
    * 运输单费用id
    */
    private String transFeeId;
    /**
    * 1运费2罚款3赔款
    */
    private Integer type;
    /**
    * 运输计划id
    */
    private String transPlanId;
    /**
    * 计费数量
    */
    private Integer quotationCount;
    /**
    * 单价
    */
    private java.math.BigDecimal unitPrice;
    /**
    * 金额
    */
    private java.math.BigDecimal quotation;
    /**
    * 备注
    */
    private String remark;
    /**
    * 
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
* <p>Discription:[运输单费用id]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getTransFeeId(){
return transFeeId;
}
/**
* <p>Discription:[运输单费用id]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setTransFeeId(String transFeeId){
this.transFeeId = transFeeId;
}
/**
* <p>Discription:[1运费2罚款3赔款]</p>
* Created on 2019年09月15日
* @return Integer
* @author:wujinsong
*/
public Integer getType(){
return type;
}
/**
* <p>Discription:[1运费2罚款3赔款]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setType(Integer type){
this.type = type;
}
/**
* <p>Discription:[运输计划id]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getTransPlanId(){
return transPlanId;
}
/**
* <p>Discription:[运输计划id]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setTransPlanId(String transPlanId){
this.transPlanId = transPlanId;
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
* <p>Discription:[金额]</p>
* Created on 2019年09月15日
* @return java.math.BigDecimal
* @author:wujinsong
*/
public java.math.BigDecimal getQuotation(){
return quotation;
}
/**
* <p>Discription:[金额]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setQuotation(java.math.BigDecimal quotation){
this.quotation = quotation;
}
/**
* <p>Discription:[备注]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getRemark(){
return remark;
}
/**
* <p>Discription:[备注]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setRemark(String remark){
this.remark = remark;
}
/**
* <p>Discription:[]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getCreateBy(){
return createBy;
}
/**
* <p>Discription:[]</p>
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
