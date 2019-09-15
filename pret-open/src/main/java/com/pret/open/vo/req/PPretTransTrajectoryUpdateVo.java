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
public class PPretTransTrajectoryUpdateVo extends PageFormVo {
    /**
    * 
    */
    private String id;
    /**
    * 运输计划id
    */
    private String transPlanId;
    /**
    * 司机id
    */
    private String driverId;
    /**
    * 地址id
    */
    private String addressId;
    /**
    * 备注
    */
    private String remark;
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
