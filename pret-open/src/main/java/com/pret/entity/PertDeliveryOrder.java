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
@Table(name = "pert_delivery_order")
public class PertDeliveryOrder  extends VersionedAuditableIdEntity implements Serializable {

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
		* 订单号
		*/
		private String orderNo;
		/**
		* 供应商id
		*/
		private String supplierId;
		/**
		* 运输方式
		*/
		private String transMode;
		/**
		* 提货日期
		*/
		private java.util.Date takeDeliveryDate;
		/**
		* 送达日期
		*/
		private java.util.Date deliveryDate;
		/**
		* 送货单号
		*/
		private String deliveryBillNumber;
		/**
		* 提货工厂
		*/
		private String pickUpFactory;
		/**
		* 提货地址
		*/
		private String pickUpAddress;
		/**
		* 送达客户id
		*/
		private String customerId;
		/**
		* 客户名称
		*/
		private String customerName;
		/**
		* 客户地址
		*/
		private String customerAddress;
		/**
		* 客户联系人
		*/
		private String customerLinkName;
		/**
		* 客户联系人电话
		*/
		private String customerLinkPhone;
	
	// setter and getter
	/**
	* <p>Discription:[订单号]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getOrderNo(){
		return orderNo;
	}
	/**
	* <p>Discription:[订单号]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setOrderNo(String orderNo){
		this.orderNo = orderNo;
	}
	/**
	* <p>Discription:[供应商id]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getSupplierId(){
		return supplierId;
	}
	/**
	* <p>Discription:[供应商id]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setSupplierId(String supplierId){
		this.supplierId = supplierId;
	}
	/**
	* <p>Discription:[运输方式]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getTransMode(){
		return transMode;
	}
	/**
	* <p>Discription:[运输方式]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setTransMode(String transMode){
		this.transMode = transMode;
	}
	/**
	* <p>Discription:[提货日期]</p>
	* Created on 2019年08月29日
	* @return java.util.Date
    * @author:wujinsong
    */
	public java.util.Date getTakeDeliveryDate(){
		return takeDeliveryDate;
	}
	/**
	* <p>Discription:[提货日期]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setTakeDeliveryDate(java.util.Date takeDeliveryDate){
		this.takeDeliveryDate = takeDeliveryDate;
	}
	/**
	* <p>Discription:[送达日期]</p>
	* Created on 2019年08月29日
	* @return java.util.Date
    * @author:wujinsong
    */
	public java.util.Date getDeliveryDate(){
		return deliveryDate;
	}
	/**
	* <p>Discription:[送达日期]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setDeliveryDate(java.util.Date deliveryDate){
		this.deliveryDate = deliveryDate;
	}
	/**
	* <p>Discription:[送货单号]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getDeliveryBillNumber(){
		return deliveryBillNumber;
	}
	/**
	* <p>Discription:[送货单号]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setDeliveryBillNumber(String deliveryBillNumber){
		this.deliveryBillNumber = deliveryBillNumber;
	}
	/**
	* <p>Discription:[提货工厂]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getPickUpFactory(){
		return pickUpFactory;
	}
	/**
	* <p>Discription:[提货工厂]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setPickUpFactory(String pickUpFactory){
		this.pickUpFactory = pickUpFactory;
	}
	/**
	* <p>Discription:[提货地址]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getPickUpAddress(){
		return pickUpAddress;
	}
	/**
	* <p>Discription:[提货地址]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setPickUpAddress(String pickUpAddress){
		this.pickUpAddress = pickUpAddress;
	}
	/**
	* <p>Discription:[送达客户id]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getCustomerId(){
		return customerId;
	}
	/**
	* <p>Discription:[送达客户id]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setCustomerId(String customerId){
		this.customerId = customerId;
	}
	/**
	* <p>Discription:[客户名称]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getCustomerName(){
		return customerName;
	}
	/**
	* <p>Discription:[客户名称]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setCustomerName(String customerName){
		this.customerName = customerName;
	}
	/**
	* <p>Discription:[客户地址]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getCustomerAddress(){
		return customerAddress;
	}
	/**
	* <p>Discription:[客户地址]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setCustomerAddress(String customerAddress){
		this.customerAddress = customerAddress;
	}
	/**
	* <p>Discription:[客户联系人]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getCustomerLinkName(){
		return customerLinkName;
	}
	/**
	* <p>Discription:[客户联系人]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setCustomerLinkName(String customerLinkName){
		this.customerLinkName = customerLinkName;
	}
	/**
	* <p>Discription:[客户联系人电话]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getCustomerLinkPhone(){
		return customerLinkPhone;
	}
	/**
	* <p>Discription:[客户联系人电话]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setCustomerLinkPhone(String customerLinkPhone){
		this.customerLinkPhone = customerLinkPhone;
	}
}
