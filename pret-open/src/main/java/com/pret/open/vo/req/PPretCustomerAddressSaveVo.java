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
public class PPretCustomerAddressSaveVo extends PageFormVo {
    /**
    * 主键id
    */
    private String id;
    /**
    * 供应商id
    */
    private String customerId;
    /**
    * 地址id
    */
    private String addressId;
    /**
    * 详细地址
    */
    private String detail;
    /**
    * 联系人
    */
    private String linkName;
    /**
    * 联系电话
    */
    private String linkPhone;
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
    * 状态0删除1正常
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
public String getCustomerId(){
return customerId;
}
/**
* <p>Discription:[供应商id]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setCustomerId(String customerId){
this.customerId = customerId;
}
/**
* <p>Discription:[地址id]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getAddressId(){
return addressId;
}
/**
* <p>Discription:[地址id]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setAddressId(String addressId){
this.addressId = addressId;
}
/**
* <p>Discription:[详细地址]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getDetail(){
return detail;
}
/**
* <p>Discription:[详细地址]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setDetail(String detail){
this.detail = detail;
}
/**
* <p>Discription:[联系人]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getLinkName(){
return linkName;
}
/**
* <p>Discription:[联系人]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setLinkName(String linkName){
this.linkName = linkName;
}
/**
* <p>Discription:[联系电话]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getLinkPhone(){
return linkPhone;
}
/**
* <p>Discription:[联系电话]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setLinkPhone(String linkPhone){
this.linkPhone = linkPhone;
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
* <p>Discription:[状态0删除1正常]</p>
* Created on 2019年09月15日
* @return Integer
* @author:wujinsong
*/
public Integer getS(){
return s;
}
/**
* <p>Discription:[状态0删除1正常]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setS(Integer s){
this.s = s;
}
}
