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
public class PPretServiceRouteItemUpdateVo extends PageFormVo {
    /**
    * 
    */
    private String id;
    /**
    * 服务线路id
    */
    private String serviceLineId;
    /**
    * 起运地id
    */
    private String serviceRouteOrginId;
    /**
    * 地址id
    */
    private String addressId;
    /**
    * 时效(天)
    */
    private Integer prescription;
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
* <p>Discription:[服务线路id]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getServiceLineId(){
return serviceLineId;
}
/**
* <p>Discription:[服务线路id]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setServiceLineId(String serviceLineId){
this.serviceLineId = serviceLineId;
}
/**
* <p>Discription:[起运地id]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getServiceRouteOrginId(){
return serviceRouteOrginId;
}
/**
* <p>Discription:[起运地id]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setServiceRouteOrginId(String serviceRouteOrginId){
this.serviceRouteOrginId = serviceRouteOrginId;
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
* <p>Discription:[时效(天)]</p>
* Created on 2019年09月15日
* @return Integer
* @author:wujinsong
*/
public Integer getPrescription(){
return prescription;
}
/**
* <p>Discription:[时效(天)]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setPrescription(Integer prescription){
this.prescription = prescription;
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
