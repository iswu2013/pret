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
public class PPretTransOrderItemSaveVo extends PageFormVo {
    /**
    * 主键id
    */
    private String id;
    /**
    * 运输任务单id
    */
    private String transOrderId;
    /**
    * 商品id
    */
    private String goodsId;
    /**
    * 提货计划id
    */
    private String pickUpPlanId;
    /**
    * 运输计划id
    */
    private String transPlanId;
    /**
    * 商品数量
    */
    private Integer count;
    /**
    * 商品重量/体积
    */
    private String cb;
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
* <p>Discription:[运输任务单id]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getTransOrderId(){
return transOrderId;
}
/**
* <p>Discription:[运输任务单id]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setTransOrderId(String transOrderId){
this.transOrderId = transOrderId;
}
/**
* <p>Discription:[商品id]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getGoodsId(){
return goodsId;
}
/**
* <p>Discription:[商品id]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setGoodsId(String goodsId){
this.goodsId = goodsId;
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
* <p>Discription:[商品数量]</p>
* Created on 2019年09月15日
* @return Integer
* @author:wujinsong
*/
public Integer getCount(){
return count;
}
/**
* <p>Discription:[商品数量]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setCount(Integer count){
this.count = count;
}
/**
* <p>Discription:[商品重量/体积]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getCb(){
return cb;
}
/**
* <p>Discription:[商品重量/体积]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setCb(String cb){
this.cb = cb;
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
