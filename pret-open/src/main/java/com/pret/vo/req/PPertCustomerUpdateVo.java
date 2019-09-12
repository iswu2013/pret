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
public class PPertCustomerUpdateVo extends PageFormVo {
    /**
    * 主键id
    */
    private String id;
    /**
    * 客户名称
    */
    private String name;
    /**
    * 客户地址
    */
    private String address;
    /**
    * 联系人名称
    */
    private String linkName;
    /**
    * 联系人电话
    */
    private String linkPhone;

// setter and getter
/**
* <p>Discription:[主键id]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getId(){
return id;
}
/**
* <p>Discription:[主键id]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setId(String id){
this.id = id;
}
/**
* <p>Discription:[客户名称]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getName(){
return name;
}
/**
* <p>Discription:[客户名称]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setName(String name){
this.name = name;
}
/**
* <p>Discription:[客户地址]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getAddress(){
return address;
}
/**
* <p>Discription:[客户地址]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setAddress(String address){
this.address = address;
}
/**
* <p>Discription:[联系人名称]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getLinkName(){
return linkName;
}
/**
* <p>Discription:[联系人名称]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setLinkName(String linkName){
this.linkName = linkName;
}
/**
* <p>Discription:[联系人电话]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getLinkPhone(){
return linkPhone;
}
/**
* <p>Discription:[联系人电话]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setLinkPhone(String linkPhone){
this.linkPhone = linkPhone;
}
}
