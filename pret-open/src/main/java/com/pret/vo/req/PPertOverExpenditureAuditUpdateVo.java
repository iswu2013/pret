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
public class PPertOverExpenditureAuditUpdateVo extends PageFormVo {
    /**
    * 主键id
    */
    private String id;
    /**
    * 供应商id
    */
    private String supplierId;
    /**
    * 类型
    */
    private String type;
    /**
    * 起始地
    */
    private String departure;
    /**
    * 目的地
    */
    private String destination;
    /**
    * 里程
    */
    private java.math.BigDecimal mileage;
    /**
    * 运费
    */
    private java.math.BigDecimal freight;
    /**
    * 时效(天)
    */
    private Integer prescription;
    /**
    * 申请理由
    */
    private String reason;
    /**
    * 状态(待审核,通过,不通过)
    */
    private Integer status;

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
/**
* <p>Discription:[起始地]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getDeparture(){
return departure;
}
/**
* <p>Discription:[起始地]</p>
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
* <p>Discription:[里程]</p>
* Created on 2019年08月29日
* @return java.math.BigDecimal
* @author:wujinsong
*/
public java.math.BigDecimal getMileage(){
return mileage;
}
/**
* <p>Discription:[里程]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setMileage(java.math.BigDecimal mileage){
this.mileage = mileage;
}
/**
* <p>Discription:[运费]</p>
* Created on 2019年08月29日
* @return java.math.BigDecimal
* @author:wujinsong
*/
public java.math.BigDecimal getFreight(){
return freight;
}
/**
* <p>Discription:[运费]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setFreight(java.math.BigDecimal freight){
this.freight = freight;
}
/**
* <p>Discription:[时效(天)]</p>
* Created on 2019年08月29日
* @return Integer
* @author:wujinsong
*/
public Integer getPrescription(){
return prescription;
}
/**
* <p>Discription:[时效(天)]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setPrescription(Integer prescription){
this.prescription = prescription;
}
/**
* <p>Discription:[申请理由]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getReason(){
return reason;
}
/**
* <p>Discription:[申请理由]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setReason(String reason){
this.reason = reason;
}
/**
* <p>Discription:[状态(待审核,通过,不通过)]</p>
* Created on 2019年08月29日
* @return Integer
* @author:wujinsong
*/
public Integer getStatus(){
return status;
}
/**
* <p>Discription:[状态(待审核,通过,不通过)]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setStatus(Integer status){
this.status = status;
}
}
