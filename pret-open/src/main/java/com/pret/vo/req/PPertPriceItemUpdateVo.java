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
public class PPertPriceItemUpdateVo extends PageFormVo {
    /**
    * 
    */
    private String id;
    /**
    * 服务价格id
    */
    private String priceId;
    /**
    * 起始重量
    */
    private String weightStart;
    /**
    * 结束重量
    */
    private String weightEnd;
    /**
    * 价格
    */
    private java.math.BigDecimal price;

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
* <p>Discription:[服务价格id]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getPriceId(){
return priceId;
}
/**
* <p>Discription:[服务价格id]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setPriceId(String priceId){
this.priceId = priceId;
}
/**
* <p>Discription:[起始重量]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getWeightStart(){
return weightStart;
}
/**
* <p>Discription:[起始重量]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setWeightStart(String weightStart){
this.weightStart = weightStart;
}
/**
* <p>Discription:[结束重量]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getWeightEnd(){
return weightEnd;
}
/**
* <p>Discription:[结束重量]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setWeightEnd(String weightEnd){
this.weightEnd = weightEnd;
}
/**
* <p>Discription:[价格]</p>
* Created on 2019年08月29日
* @return java.math.BigDecimal
* @author:wujinsong
*/
public java.math.BigDecimal getPrice(){
return price;
}
/**
* <p>Discription:[价格]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setPrice(java.math.BigDecimal price){
this.price = price;
}
}
