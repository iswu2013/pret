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
public class PPretDriverUpdateVo extends PageFormVo {
    /**
    * 
    */
    private String id;
    /**
    * 司机姓名
    */
    private String name;
    /**
    * 司机电话
    */
    private String phone;
    /**
    * 车牌号
    */
    private String carNumber;
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
* <p>Discription:[司机姓名]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getName(){
return name;
}
/**
* <p>Discription:[司机姓名]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setName(String name){
this.name = name;
}
/**
* <p>Discription:[司机电话]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getPhone(){
return phone;
}
/**
* <p>Discription:[司机电话]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setPhone(String phone){
this.phone = phone;
}
/**
* <p>Discription:[车牌号]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getCarNumber(){
return carNumber;
}
/**
* <p>Discription:[车牌号]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setCarNumber(String carNumber){
this.carNumber = carNumber;
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
