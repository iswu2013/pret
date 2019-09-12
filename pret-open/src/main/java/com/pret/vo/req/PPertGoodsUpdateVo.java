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
public class PPertGoodsUpdateVo extends PageFormVo {
    /**
    * 主键id
    */
    private String id;
    /**
    * 商品名称
    */
    private String name;
    /**
    * 商品重量
    */
    private String weight;
    /**
    * 商品单位
    */
    private Integer unit;

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
* <p>Discription:[商品名称]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getName(){
return name;
}
/**
* <p>Discription:[商品名称]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setName(String name){
this.name = name;
}
/**
* <p>Discription:[商品重量]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getWeight(){
return weight;
}
/**
* <p>Discription:[商品重量]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setWeight(String weight){
this.weight = weight;
}
/**
* <p>Discription:[商品单位]</p>
* Created on 2019年08月29日
* @return Integer
* @author:wujinsong
*/
public Integer getUnit(){
return unit;
}
/**
* <p>Discription:[商品单位]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setUnit(Integer unit){
this.unit = unit;
}
}
