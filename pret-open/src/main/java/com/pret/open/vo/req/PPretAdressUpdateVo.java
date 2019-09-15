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
public class PPretAdressUpdateVo extends PageFormVo {
    /**
    * 主键
    */
    private String id;
    /**
    * 地址名称
    */
    private String name;
    /**
    * 地址值
    */
    private String value;
    /**
    * 父id
    */
    private String parentId;
    /**
    * 0省1市2区县
    */
    private Integer levels;
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
* <p>Discription:[地址名称]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getName(){
return name;
}
/**
* <p>Discription:[地址名称]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setName(String name){
this.name = name;
}
/**
* <p>Discription:[地址值]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getValue(){
return value;
}
/**
* <p>Discription:[地址值]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setValue(String value){
this.value = value;
}
/**
* <p>Discription:[父id]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getParentId(){
return parentId;
}
/**
* <p>Discription:[父id]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setParentId(String parentId){
this.parentId = parentId;
}
/**
* <p>Discription:[0省1市2区县]</p>
* Created on 2019年09月15日
* @return Integer
* @author:wujinsong
*/
public Integer getLevels(){
return levels;
}
/**
* <p>Discription:[0省1市2区县]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setLevels(Integer levels){
this.levels = levels;
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
