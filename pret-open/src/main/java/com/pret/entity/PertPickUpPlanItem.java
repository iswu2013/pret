package com.pret.entity;

import com.pret.common.VersionedAuditableIdEntity;
import java.io.Serializable;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
/** 
 * <p>Description: [pertmodel]</p>
 * Created on 2019年08月29日
 * @author  <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0 
 * Copyright (c) 2019年 极客城堡
 */
@Entity
@Table(name = "pert_pick_up_plan_item")
public class PertPickUpPlanItem  extends VersionedAuditableIdEntity implements Serializable {

	private static final long serialVersionUID = 1L;

		/**
		* 主键id
		*/
		@Id
		@GenericGenerator(name="idGenerator", strategy="uuid") //这个是hibernate的注解/生成32位UUID
		@GeneratedValue(generator="idGenerator")
		@Override
		public String getId() {
		return id;
		}
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
