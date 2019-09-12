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
public class PPertDriverSaveVo extends PageFormVo {
    /**
    * 
    */
    private String id;
    /**
    * 司机姓名
    */
    private String name;
    /**
    * 司机电话
    */
    private String phone;
    /**
    * 车牌号
    */
    private String carNumber;

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
* <p>Discription:[司机姓名]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getName(){
return name;
}
/**
* <p>Discription:[司机姓名]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setName(String name){
this.name = name;
}
/**
* <p>Discription:[司机电话]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getPhone(){
return phone;
}
/**
* <p>Discription:[司机电话]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setPhone(String phone){
this.phone = phone;
}
/**
* <p>Discription:[车牌号]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getCarNumber(){
return carNumber;
}
/**
* <p>Discription:[车牌号]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setCarNumber(String carNumber){
this.carNumber = carNumber;
}
}
