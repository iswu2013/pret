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
@Table(name = "pert_pick_up_plan")
public class PertPickUpPlan  extends VersionedAuditableIdEntity implements Serializable {

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
		* 编号
		*/
		private String no;
		/**
		* 供应商id
		*/
		private String supplierId;
		/**
		* 配送单id
		*/
		private String deliveryOrderId;
		/**
		* 类型
		*/
		private String type;
		/**
		* 预计提货时间
		*/
		private java.util.Date pickUpTime;
		/**
		* 司机姓名
		*/
		private String driverName;
		/**
		* 车牌号
		*/
		private String carNumber;
		/**
		* 司机电话
		*/
		private String driverPhone;
		/**
		* 提货数量
		*/
		private Integer count;
		/**
		* 提货重量
		*/
		private String weight;
		/**
		* 0待提货1已完成
		*/
		private Integer status;
		/**
		* 实际提货时间
		*/
		private java.util.Date startTime;
		/**
		* 结束提货时间
		*/
		private java.util.Date endTime;
	
	// setter and getter
	/**
	* <p>Discription:[编号]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getNo(){
		return no;
	}
	/**
	* <p>Discription:[编号]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setNo(String no){
		this.no = no;
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
	/**
	* <p>Discription:[类型]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getType(){
		return type;
	}
	/**
	* <p>Discription:[类型]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setType(String type){
		this.type = type;
	}
	/**
	* <p>Discription:[预计提货时间]</p>
	* Created on 2019年08月29日
	* @return java.util.Date
    * @author:wujinsong
    */
	public java.util.Date getPickUpTime(){
		return pickUpTime;
	}
	/**
	* <p>Discription:[预计提货时间]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setPickUpTime(java.util.Date pickUpTime){
		this.pickUpTime = pickUpTime;
	}
	/**
	* <p>Discription:[司机姓名]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getDriverName(){
		return driverName;
	}
	/**
	* <p>Discription:[司机姓名]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setDriverName(String driverName){
		this.driverName = driverName;
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
	/**
	* <p>Discription:[司机电话]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getDriverPhone(){
		return driverPhone;
	}
	/**
	* <p>Discription:[司机电话]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setDriverPhone(String driverPhone){
		this.driverPhone = driverPhone;
	}
	/**
	* <p>Discription:[提货数量]</p>
	* Created on 2019年08月29日
	* @return Integer
    * @author:wujinsong
    */
	public Integer getCount(){
		return count;
	}
	/**
	* <p>Discription:[提货数量]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setCount(Integer count){
		this.count = count;
	}
	/**
	* <p>Discription:[提货重量]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getWeight(){
		return weight;
	}
	/**
	* <p>Discription:[提货重量]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setWeight(String weight){
		this.weight = weight;
	}
	/**
	* <p>Discription:[0待提货1已完成]</p>
	* Created on 2019年08月29日
	* @return Integer
    * @author:wujinsong
    */
	public Integer getStatus(){
		return status;
	}
	/**
	* <p>Discription:[0待提货1已完成]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setStatus(Integer status){
		this.status = status;
	}
	/**
	* <p>Discription:[实际提货时间]</p>
	* Created on 2019年08月29日
	* @return java.util.Date
    * @author:wujinsong
    */
	public java.util.Date getStartTime(){
		return startTime;
	}
	/**
	* <p>Discription:[实际提货时间]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setStartTime(java.util.Date startTime){
		this.startTime = startTime;
	}
	/**
	* <p>Discription:[结束提货时间]</p>
	* Created on 2019年08月29日
	* @return java.util.Date
    * @author:wujinsong
    */
	public java.util.Date getEndTime(){
		return endTime;
	}
	/**
	* <p>Discription:[结束提货时间]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setEndTime(java.util.Date endTime){
		this.endTime = endTime;
	}
}
