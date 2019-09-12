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
public class PPertServiceLineItemSaveVo extends PageFormVo {
    /**
    * 
    */
    private String id;
    /**
    * 服务线路id
    */
    private String serviceLineId;
    /**
    * 地址id
    */
    private String addressId;

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
* <p>Discription:[服务线路id]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getServiceLineId(){
return serviceLineId;
}
/**
* <p>Discription:[服务线路id]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setServiceLineId(String serviceLineId){
this.serviceLineId = serviceLineId;
}
/**
* <p>Discription:[地址id]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getAddressId(){
return addressId;
}
/**
* <p>Discription:[地址id]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setAddressId(String addressId){
this.addressId = addressId;
}
}
