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
public class PPretVenderSaveVo extends PageFormVo {
    /**
    * 
    */
    private String id;
    /**
    * 编号
    */
    private String code;
    /**
    * 名称
    */
    private String name;
    /**
    * 联系人
    */
    private String linkName;
    /**
    * 联系号码
    */
    private String linkPhone;
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
* <p>Discription:[编号]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getCode(){
return code;
}
/**
* <p>Discription:[编号]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setCode(String code){
this.code = code;
}
/**
* <p>Discription:[名称]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getName(){
return name;
}
/**
* <p>Discription:[名称]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setName(String name){
this.name = name;
}
/**
* <p>Discription:[联系人]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getLinkName(){
return linkName;
}
/**
* <p>Discription:[联系人]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setLinkName(String linkName){
this.linkName = linkName;
}
/**
* <p>Discription:[联系号码]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getLinkPhone(){
return linkPhone;
}
/**
* <p>Discription:[联系号码]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setLinkPhone(String linkPhone){
this.linkPhone = linkPhone;
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
