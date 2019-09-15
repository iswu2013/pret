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
public class PPretServiceRouteUpdateVo extends PageFormVo {
    /**
    * 主键id
    */
    private String id;
    /**
    * 供应商id
    */
    private String venderId;
    /**
    * 起运地
    */
    private String seviceRouteOrginId;
    /**
    * 计费区间id
    */
    private String billingIntervalId;
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
* <p>Discription:[起运地]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getSeviceRouteOrginId(){
return seviceRouteOrginId;
}
/**
* <p>Discription:[起运地]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setSeviceRouteOrginId(String seviceRouteOrginId){
this.seviceRouteOrginId = seviceRouteOrginId;
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
