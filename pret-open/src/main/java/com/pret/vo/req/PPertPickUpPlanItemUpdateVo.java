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
public class PPertPickUpPlanItemUpdateVo extends PageFormVo {
    /**
    * 主键id
    */
    private String id;
    /**
    * 提货计划id
    */
    private String pickUpPlanId;
    /**
    * 配送单id
    */
    private String deliveryOrderId;

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
* <p>Discription:[提货计划id]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getPickUpPlanId(){
return pickUpPlanId;
}
/**
* <p>Discription:[提货计划id]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setPickUpPlanId(String pickUpPlanId){
this.pickUpPlanId = pickUpPlanId;
}
/**
* <p>Discription:[配送单id]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getDeliveryOrderId(){
return deliveryOrderId;
}
/**
* <p>Discription:[配送单id]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setDeliveryOrderId(String deliveryOrderId){
this.deliveryOrderId = deliveryOrderId;
}
}
