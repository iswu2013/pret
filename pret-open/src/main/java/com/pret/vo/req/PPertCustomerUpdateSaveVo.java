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
public class PPertCustomerUpdateSaveVo extends PageFormVo {
    /**
    * 
    */
    private String id;
    /**
    * 客户id
    */
    private String customerId;
    /**
    * 客户手机号码
    */
    private String phone;
    /**
    * 客户姓名
    */
    private String name;
    /**
    * 地址
    */
    private String areaId;
    /**
    * 详细地址
    */
    private String detailAddress;
    /**
    * 状态0待处理1通过2不通过
    */
    private Integer status;

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
* <p>Discription:[客户手机号码]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getPhone(){
return phone;
}
/**
* <p>Discription:[客户手机号码]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setPhone(String phone){
this.phone = phone;
}
/**
* <p>Discription:[客户姓名]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getName(){
return name;
}
/**
* <p>Discription:[客户姓名]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setName(String name){
this.name = name;
}
/**
* <p>Discription:[地址]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getAreaId(){
return areaId;
}
/**
* <p>Discription:[地址]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setAreaId(String areaId){
this.areaId = areaId;
}
/**
* <p>Discription:[详细地址]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getDetailAddress(){
return detailAddress;
}
/**
* <p>Discription:[详细地址]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setDetailAddress(String detailAddress){
this.detailAddress = detailAddress;
}
/**
* <p>Discription:[状态0待处理1通过2不通过]</p>
* Created on 2019年08月29日
* @return Integer
* @author:wujinsong
*/
public Integer getStatus(){
return status;
}
/**
* <p>Discription:[状态0待处理1通过2不通过]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setStatus(Integer status){
this.status = status;
}
}
