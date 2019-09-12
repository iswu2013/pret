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
@Table(name = "pert_delivery_order_item")
public class PertDeliveryOrderItem  extends VersionedAuditableIdEntity implements Serializable {

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
		* 所属订单id
		*/
		private String deliveryOrderId;
		/**
		* 商品id
		*/
		private String goodsId;
		/**
		* 商品数量
		*/
		private Integer count;
		/**
		* 商品重量
		*/
		private String weight;
	
	// setter and getter
	/**
	* <p>Discription:[所属订单id]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getDeliveryOrderId(){
		return deliveryOrderId;
	}
	/**
	* <p>Discription:[所属订单id]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setDeliveryOrderId(String deliveryOrderId){
		this.deliveryOrderId = deliveryOrderId;
	}
	/**
	* <p>Discription:[商品id]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getGoodsId(){
		return goodsId;
	}
	/**
	* <p>Discription:[商品id]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setGoodsId(String goodsId){
		this.goodsId = goodsId;
	}
	/**
	* <p>Discription:[商品数量]</p>
	* Created on 2019年08月29日
	* @return Integer
    * @author:wujinsong
    */
	public Integer getCount(){
		return count;
	}
	/**
	* <p>Discription:[商品数量]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setCount(Integer count){
		this.count = count;
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
}
