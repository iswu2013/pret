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
public class PPretGoodsUpdateVo extends PageFormVo {
    /**
    * 主键id
    */
    private String id;
    /**
    * 料号
    */
    private String partNo;
    /**
    * 批号
    */
    private String batchNo;
    /**
    * 品名
    */
    private String product;
    /**
    * 商品重量
    */
    private String weight;
    /**
    * 商品单位
    */
    private Integer unit;
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
* <p>Discription:[料号]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getPartNo(){
return partNo;
}
/**
* <p>Discription:[料号]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setPartNo(String partNo){
this.partNo = partNo;
}
/**
* <p>Discription:[批号]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getBatchNo(){
return batchNo;
}
/**
* <p>Discription:[批号]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setBatchNo(String batchNo){
this.batchNo = batchNo;
}
/**
* <p>Discription:[品名]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getProduct(){
return product;
}
/**
* <p>Discription:[品名]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setProduct(String product){
this.product = product;
}
/**
* <p>Discription:[商品重量]</p>
* Created on 2019年09月15日
* @return String
* @author:wujinsong
*/
public String getWeight(){
return weight;
}
/**
* <p>Discription:[商品重量]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setWeight(String weight){
this.weight = weight;
}
/**
* <p>Discription:[商品单位]</p>
* Created on 2019年09月15日
* @return Integer
* @author:wujinsong
*/
public Integer getUnit(){
return unit;
}
/**
* <p>Discription:[商品单位]</p>
* Created on 2019年09月15日
* @author:wujinsong
*/
public void setUnit(Integer unit){
this.unit = unit;
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
