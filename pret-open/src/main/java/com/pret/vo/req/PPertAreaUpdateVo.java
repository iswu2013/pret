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
public class PPertAreaUpdateVo extends PageFormVo {
    /**
    * 主键
    */
    private String id;
    /**
    * 地址名称
    */
    private String name;
    /**
    * 地址值
    */
    private String value;
    /**
    * 父id
    */
    private String parentId;
    /**
    * 0省1市2区县
    */
    private Integer levels;

// setter and getter
/**
* <p>Discription:[主键]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getId(){
return id;
}
/**
* <p>Discription:[主键]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setId(String id){
this.id = id;
}
/**
* <p>Discription:[地址名称]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getName(){
return name;
}
/**
* <p>Discription:[地址名称]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setName(String name){
this.name = name;
}
/**
* <p>Discription:[地址值]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getValue(){
return value;
}
/**
* <p>Discription:[地址值]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setValue(String value){
this.value = value;
}
/**
* <p>Discription:[父id]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getParentId(){
return parentId;
}
/**
* <p>Discription:[父id]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setParentId(String parentId){
this.parentId = parentId;
}
/**
* <p>Discription:[0省1市2区县]</p>
* Created on 2019年08月29日
* @return Integer
* @author:wujinsong
*/
public Integer getLevels(){
return levels;
}
/**
* <p>Discription:[0省1市2区县]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setLevels(Integer levels){
this.levels = levels;
}
}
