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
public class PPretTransOrderUpdateVo extends PageFormVo {
    /**
    * 主键id
    */
    private String id;
    /**
    * 订单号
    */
    private String orderNo;
    /**
    * 供应商id
    */
    private String venderId;
    /**
    * 运输方式
    */
    private String transMode;
    /**
    * 提货日期
    */
    private java.util.Date takeDeliveryDate;
    /**
    * 送达日期
    */
    private java.util.Date deliveryDate;
    /**
    * 送货单号
    */
    private String deliveryBillNumber;
    /**
    * 起运地
    */
    private String serviceRouteOrginId;
    /**
    * 送达客户id
    */
    private String customerId;
    /**
    * 客户名称
    */
    private String customerName;
    /**
    * 客户地址
    */
    private String customerAddress;
    /**
    * 客户联系人
    */
    private String customerLinkName;
    /**
    * 客户联系人电话
    */
    private String customerLinkPhone;
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
* <p>Discription:[订单号]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getOrderNo(){
return orderNo;
}
/**
* <p>Discription:[订单号]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setOrderNo(String orderNo){
this.orderNo = orderNo;
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
* <p>Discription:[运输方式]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getTransMode(){
return transMode;
}
/**
* <p>Discription:[运输方式]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setTransMode(String transMode){
this.transMode = transMode;
}
/**
* <p>Discription:[提货日期]</p>
* Created on 2019年09月15日
* @return java.util.Date
* @author:wujinsong
*/
public java.util.Date getTakeDeliveryDate(){
return takeDeliveryDate;
}
/**
* <p>Discription:[提货日期]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setTakeDeliveryDate(java.util.Date takeDeliveryDate){
this.takeDeliveryDate = takeDeliveryDate;
}
/**
* <p>Discription:[送达日期]</p>
* Created on 2019年09月15日
* @return java.util.Date
* @author:wujinsong
*/
public java.util.Date getDeliveryDate(){
return deliveryDate;
}
/**
* <p>Discription:[送达日期]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setDeliveryDate(java.util.Date deliveryDate){
this.deliveryDate = deliveryDate;
}
/**
* <p>Discription:[送货单号]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getDeliveryBillNumber(){
return deliveryBillNumber;
}
/**
* <p>Discription:[送货单号]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setDeliveryBillNumber(String deliveryBillNumber){
this.deliveryBillNumber = deliveryBillNumber;
}
/**
* <p>Discription:[起运地]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getServiceRouteOrginId(){
return serviceRouteOrginId;
}
/**
* <p>Discription:[起运地]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setServiceRouteOrginId(String serviceRouteOrginId){
this.serviceRouteOrginId = serviceRouteOrginId;
}
/**
* <p>Discription:[送达客户id]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getCustomerId(){
return customerId;
}
/**
* <p>Discription:[送达客户id]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setCustomerId(String customerId){
this.customerId = customerId;
}
/**
* <p>Discription:[客户名称]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getCustomerName(){
return customerName;
}
/**
* <p>Discription:[客户名称]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setCustomerName(String customerName){
this.customerName = customerName;
}
/**
* <p>Discription:[客户地址]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getCustomerAddress(){
return customerAddress;
}
/**
* <p>Discription:[客户地址]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setCustomerAddress(String customerAddress){
this.customerAddress = customerAddress;
}
/**
* <p>Discription:[客户联系人]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getCustomerLinkName(){
return customerLinkName;
}
/**
* <p>Discription:[客户联系人]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setCustomerLinkName(String customerLinkName){
this.customerLinkName = customerLinkName;
}
/**
* <p>Discription:[客户联系人电话]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getCustomerLinkPhone(){
return customerLinkPhone;
}
/**
* <p>Discription:[客户联系人电话]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setCustomerLinkPhone(String customerLinkPhone){
this.customerLinkPhone = customerLinkPhone;
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
