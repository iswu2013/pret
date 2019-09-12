package com.pret.vo.req;

import java.util.List;

import com.pret.api.vo.PageFormVo;

/**
 * Description: [pert服务]
 * Created on 2019年08月29日
 * @author  <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0 
 * Copyright (c) 2019年 极客城堡
 */
public class PPertTransPlanSaveVo extends PageFormVo {
    /**
    * 
    */
    private String id;
    /**
    * 
    */
    private Integer supplierId;
    /**
    * 类型
    */
    private String type;
    /**
    * 客户id
    */
    private String customerId;
    /**
    * 预计提货日期
    */
    private java.util.Date pickUpDate;
    /**
    * 司机id
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
    * 状态(运输中,已签收)
    */
    private Integer status;
    /**
    * 是否已签收1是0否
    */
    private Integer signs;

// setter and getter
/**
* <p>Discription:[]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getId(){
return id;
}
/**
* <p>Discription:[]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setId(String id){
this.id = id;
}
/**
* <p>Discription:[]</p>
* Created on 2019年08月29日
* @return Integer
* @author:wujinsong
*/
public Integer getSupplierId(){
return supplierId;
}
/**
* <p>Discription:[]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setSupplierId(Integer supplierId){
this.supplierId = supplierId;
}
/**
* <p>Discription:[类型]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getType(){
return type;
}
/**
* <p>Discription:[类型]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setType(String type){
this.type = type;
}
/**
* <p>Discription:[客户id]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getCustomerId(){
return customerId;
}
/**
* <p>Discription:[客户id]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setCustomerId(String customerId){
this.customerId = customerId;
}
/**
* <p>Discription:[预计提货日期]</p>
* Created on 2019年08月29日
* @return java.util.Date
* @author:wujinsong
*/
public java.util.Date getPickUpDate(){
return pickUpDate;
}
/**
* <p>Discription:[预计提货日期]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setPickUpDate(java.util.Date pickUpDate){
this.pickUpDate = pickUpDate;
}
/**
* <p>Discription:[司机id]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getDriverId(){
return driverId;
}
/**
* <p>Discription:[司机id]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setDriverId(String driverId){
this.driverId = driverId;
}
/**
* <p>Discription:[提货数量]</p>
* Created on 2019年08月29日
* @return Integer
* @author:wujinsong
*/
public Integer getCount(){
return count;
}
/**
* <p>Discription:[提货数量]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setCount(Integer count){
this.count = count;
}
/**
* <p>Discription:[提货重量]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getWeight(){
return weight;
}
/**
* <p>Discription:[提货重量]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setWeight(String weight){
this.weight = weight;
}
/**
* <p>Discription:[状态(运输中,已签收)]</p>
* Created on 2019年08月29日
* @return Integer
* @author:wujinsong
*/
public Integer getStatus(){
return status;
}
/**
* <p>Discription:[状态(运输中,已签收)]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setStatus(Integer status){
this.status = status;
}
/**
* <p>Discription:[是否已签收1是0否]</p>
* Created on 2019年08月29日
* @return Integer
* @author:wujinsong
*/
public Integer getSigns(){
return signs;
}
/**
* <p>Discription:[是否已签收1是0否]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setSigns(Integer signs){
this.signs = signs;
}
}
