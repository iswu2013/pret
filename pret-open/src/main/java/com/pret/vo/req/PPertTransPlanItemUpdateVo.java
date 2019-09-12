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
public class PPertTransPlanItemUpdateVo extends PageFormVo {
    /**
    * 
    */
    private String id;
    /**
    * 运输计划id
    */
    private String transPlanId;
    /**
    * 配送单id
    */
    private String deliverOrderId;

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
* <p>Discription:[运输计划id]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getTransPlanId(){
return transPlanId;
}
/**
* <p>Discription:[运输计划id]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setTransPlanId(String transPlanId){
this.transPlanId = transPlanId;
}
/**
* <p>Discription:[配送单id]</p>
* Created on 2019年08月29日
* @return String
* @author:wujinsong
*/
public String getDeliverOrderId(){
return deliverOrderId;
}
/**
* <p>Discription:[配送单id]</p>
* Created on 2019年08月29日
* @author:wujinsong
*/
public void setDeliverOrderId(String deliverOrderId){
this.deliverOrderId = deliverOrderId;
}
}
