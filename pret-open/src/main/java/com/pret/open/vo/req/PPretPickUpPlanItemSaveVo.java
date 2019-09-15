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
public class PPretPickUpPlanItemSaveVo extends PageFormVo {
    /**
    * 主键id
    */
    private String id;
    /**
    * 提货计划id
    */
    private String pickUpPlanId;
    /**
    * 配送单id
    */
    private String deliveryOrderId;
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
* <p>Discription:[提货计划id]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getPickUpPlanId(){
return pickUpPlanId;
}
/**
* <p>Discription:[提货计划id]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setPickUpPlanId(String pickUpPlanId){
this.pickUpPlanId = pickUpPlanId;
}
/**
* <p>Discription:[配送单id]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getDeliveryOrderId(){
return deliveryOrderId;
}
/**
* <p>Discription:[配送单id]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setDeliveryOrderId(String deliveryOrderId){
this.deliveryOrderId = deliveryOrderId;
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
}
