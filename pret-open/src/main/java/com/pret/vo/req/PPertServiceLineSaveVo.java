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
public class PPertServiceLineSaveVo extends PageFormVo {
    /**
    * 主键id
    */
    private String id;
    /**
    * 供应商
    */
    private String supplierId;
    /**
    * 出发地
    */
    private String departure;
    /**
    * 目的地
    */
    private String destination;
    /**
    * 类型
    */
    private String type;

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
* <p>Discription:[供应商]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getSupplierId(){
return supplierId;
}
/**
* <p>Discription:[供应商]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setSupplierId(String supplierId){
this.supplierId = supplierId;
}
/**
* <p>Discription:[出发地]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getDeparture(){
return departure;
}
/**
* <p>Discription:[出发地]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setDeparture(String departure){
this.departure = departure;
}
/**
* <p>Discription:[目的地]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getDestination(){
return destination;
}
/**
* <p>Discription:[目的地]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setDestination(String destination){
this.destination = destination;
}
/**
* <p>Discription:[类型]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getType(){
return type;
}
/**
* <p>Discription:[类型]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setType(String type){
this.type = type;
}
}
