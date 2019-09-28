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
public class PPretBillingIntervalItemUpdateVo extends PageFormVo {
    /**
    * 
    */
    private String id;
    /**
    * 供应商id
    */
    private String venderId;
    /**
    * 1重货
2泡货
    */
    private Integer type;
    /**
    * 计费区间id
    */
    private String billingIntervalId;
    /**
    * 计费结束量
    */
    private String end;
    /**
    * 描述
    */
    private String description;
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
* <p>Discription:[1重货
2泡货]</p>
* Created on 2019年09月15日
* @return Integer
* @author:wujinsong
*/
public Integer getType(){
return type;
}
/**
* <p>Discription:[1重货
2泡货]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setType(Integer type){
this.type = type;
}
/**
* <p>Discription:[计费区间id]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getBillingIntervalId(){
return billingIntervalId;
}
/**
* <p>Discription:[计费区间id]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setBillingIntervalId(String billingIntervalId){
this.billingIntervalId = billingIntervalId;
}
/**
* <p>Discription:[计费结束量]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getEnd(){
return end;
}
/**
* <p>Discription:[计费结束量]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setEnd(String end){
this.end = end;
}
/**
* <p>Discription:[描述]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getDescription(){
return description;
}
/**
* <p>Discription:[描述]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setDescription(String description){
this.description = description;
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