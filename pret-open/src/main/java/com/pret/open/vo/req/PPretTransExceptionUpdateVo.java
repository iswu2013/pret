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
public class PPretTransExceptionUpdateVo extends PageFormVo {
    /**
    * 主键
    */
    private String id;
    /**
    * 运输计划id
    */
    private String transPlanId;
    /**
    * 运输任务单明细id
    */
    private String transOrderItemId;
    /**
    * 异常类别0
    */
    private Integer type;
    /**
    * 状态0待审核1通过2不通过
    */
    private Integer status;
    /**
    * 处理方式
    */
    private Integer handleStyle;
    /**
    * 异常描述
    */
    private String remark;
    /**
    * 图片id	
    */
    private String picIds;
    /**
    * 异常数量
    */
    private Integer count;
    /**
    * 责任方0物流1货主2客户
    */
    private Integer responsibleParty;
    /**
    * 处理时间
    */
    private java.util.Date handleTime;
    /**
    * 处理人
    */
    private String handleBy;
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
* <p>Discription:[主键]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getId(){
return id;
}
/**
* <p>Discription:[主键]</p>
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
* <p>Discription:[运输任务单明细id]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getTransOrderItemId(){
return transOrderItemId;
}
/**
* <p>Discription:[运输任务单明细id]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setTransOrderItemId(String transOrderItemId){
this.transOrderItemId = transOrderItemId;
}
/**
* <p>Discription:[异常类别0]</p>
* Created on 2019年09月15日
* @return Integer
* @author:wujinsong
*/
public Integer getType(){
return type;
}
/**
* <p>Discription:[异常类别0]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setType(Integer type){
this.type = type;
}
/**
* <p>Discription:[状态0待审核1通过2不通过]</p>
* Created on 2019年09月15日
* @return Integer
* @author:wujinsong
*/
public Integer getStatus(){
return status;
}
/**
* <p>Discription:[状态0待审核1通过2不通过]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setStatus(Integer status){
this.status = status;
}
/**
* <p>Discription:[处理方式]</p>
* Created on 2019年09月15日
* @return Integer
* @author:wujinsong
*/
public Integer getHandleStyle(){
return handleStyle;
}
/**
* <p>Discription:[处理方式]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setHandleStyle(Integer handleStyle){
this.handleStyle = handleStyle;
}
/**
* <p>Discription:[异常描述]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getRemark(){
return remark;
}
/**
* <p>Discription:[异常描述]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setRemark(String remark){
this.remark = remark;
}
/**
* <p>Discription:[图片id	]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getPicIds(){
return picIds;
}
/**
* <p>Discription:[图片id	]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setPicIds(String picIds){
this.picIds = picIds;
}
/**
* <p>Discription:[异常数量]</p>
* Created on 2019年09月15日
* @return Integer
* @author:wujinsong
*/
public Integer getCount(){
return count;
}
/**
* <p>Discription:[异常数量]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setCount(Integer count){
this.count = count;
}
/**
* <p>Discription:[责任方0物流1货主2客户]</p>
* Created on 2019年09月15日
* @return Integer
* @author:wujinsong
*/
public Integer getResponsibleParty(){
return responsibleParty;
}
/**
* <p>Discription:[责任方0物流1货主2客户]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setResponsibleParty(Integer responsibleParty){
this.responsibleParty = responsibleParty;
}
/**
* <p>Discription:[处理时间]</p>
* Created on 2019年09月15日
* @return java.util.Date
* @author:wujinsong
*/
public java.util.Date getHandleTime(){
return handleTime;
}
/**
* <p>Discription:[处理时间]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setHandleTime(java.util.Date handleTime){
this.handleTime = handleTime;
}
/**
* <p>Discription:[处理人]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getHandleBy(){
return handleBy;
}
/**
* <p>Discription:[处理人]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setHandleBy(String handleBy){
this.handleBy = handleBy;
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
