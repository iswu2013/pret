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
@Table(name = "pert_order_additional_costs")
public class PertOrderAdditionalCosts  extends VersionedAuditableIdEntity implements Serializable {

	private static final long serialVersionUID = 1L;

		/**
		* 
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
		* 订单id
		*/
		private String deliveryOrderId;
		/**
		* 费用类别，0赔偿费用1过路费
		*/
		private Integer type;
		/**
		* 金额
		*/
		private java.math.BigDecimal amount;
	
	// setter and getter
	/**
	* <p>Discription:[订单id]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getDeliveryOrderId(){
		return deliveryOrderId;
	}
	/**
	* <p>Discription:[订单id]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setDeliveryOrderId(String deliveryOrderId){
		this.deliveryOrderId = deliveryOrderId;
	}
	/**
	* <p>Discription:[费用类别，0赔偿费用1过路费]</p>
	* Created on 2019年08月29日
	* @return Integer
    * @author:wujinsong
    */
	public Integer getType(){
		return type;
	}
	/**
	* <p>Discription:[费用类别，0赔偿费用1过路费]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setType(Integer type){
		this.type = type;
	}
	/**
	* <p>Discription:[金额]</p>
	* Created on 2019年08月29日
	* @return java.math.BigDecimal
    * @author:wujinsong
    */
	public java.math.BigDecimal getAmount(){
		return amount;
	}
	/**
	* <p>Discription:[金额]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setAmount(java.math.BigDecimal amount){
		this.amount = amount;
	}
}
