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
public class PPertPriceUpdateVo extends PageFormVo {
    /**
    * 主键id
    */
    private String id;
    /**
    * 供应商id
    */
    private String supplierId;
    /**
    * 服务线路id
    */
    private String serviceLineId;

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
* <p>Discription:[供应商id]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getSupplierId(){
return supplierId;
}
/**
* <p>Discription:[供应商id]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setSupplierId(String supplierId){
this.supplierId = supplierId;
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
}
