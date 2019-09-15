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
public class PPretPickUpPlanSaveVo extends PageFormVo {
    /**
    * 主键id
    */
    private String id;
    /**
    * 编号
    */
    private String no;
    /**
    * 供应商id
    */
    private String venderId;
    /**
    * 类型
    */
    private String type;
    /**
    * 预计提货时间
    */
    private java.util.Date pickUpTime;
    /**
    * 
    */
    private String driverId;
    /**
    * 提货数量
    */
    private Integer count;
    /**
    * 提货重量
    */
    private String weight;
    /**
    * 0待提货1已完成
    */
    private Integer status;
    /**
    * 实际提货时间
    */
    private java.util.Date startTime;
    /**
    * 结束提货时间
    */
    private java.util.Date endTime;
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
* <p>Discription:[编号]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getNo(){
return no;
}
/**
* <p>Discription:[编号]</p>
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
* <p>Discription:[类型]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getType(){
return type;
}
/**
* <p>Discription:[类型]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setType(String type){
this.type = type;
}
/**
* <p>Discription:[预计提货时间]</p>
* Created on 2019年09月15日
* @return java.util.Date
* @author:wujinsong
*/
public java.util.Date getPickUpTime(){
return pickUpTime;
}
/**
* <p>Discription:[预计提货时间]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setPickUpTime(java.util.Date pickUpTime){
this.pickUpTime = pickUpTime;
}
/**
* <p>Discription:[]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getDriverId(){
return driverId;
}
/**
* <p>Discription:[]</p>
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
* <p>Discription:[提货重量]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getWeight(){
return weight;
}
/**
* <p>Discription:[提货重量]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setWeight(String weight){
this.weight = weight;
}
/**
* <p>Discription:[0待提货1已完成]</p>
* Created on 2019年09月15日
* @return Integer
* @author:wujinsong
*/
public Integer getStatus(){
return status;
}
/**
* <p>Discription:[0待提货1已完成]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setStatus(Integer status){
this.status = status;
}
/**
* <p>Discription:[实际提货时间]</p>
* Created on 2019年09月15日
* @return java.util.Date
* @author:wujinsong
*/
public java.util.Date getStartTime(){
return startTime;
}
/**
* <p>Discription:[实际提货时间]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setStartTime(java.util.Date startTime){
this.startTime = startTime;
}
/**
* <p>Discription:[结束提货时间]</p>
* Created on 2019年09月15日
* @return java.util.Date
* @author:wujinsong
*/
public java.util.Date getEndTime(){
return endTime;
}
/**
* <p>Discription:[结束提货时间]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setEndTime(java.util.Date endTime){
this.endTime = endTime;
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
