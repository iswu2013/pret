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
@Table(name = "pert_cost_prescription")
public class PertCostPrescription  extends VersionedAuditableIdEntity implements Serializable {

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
		* 运输类别
		*/
		private String transType;
		/**
		* 供应商id
		*/
		private String supplierId;
		/**
		* 时效
		*/
		private Integer prescription;
		/**
		* 价格
		*/
		private java.math.BigDecimal price;
	
	// setter and getter
	/**
	* <p>Discription:[运输类别]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getTransType(){
		return transType;
	}
	/**
	* <p>Discription:[运输类别]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setTransType(String transType){
		this.transType = transType;
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
	* <p>Discription:[时效]</p>
	* Created on 2019年08月29日
	* @return Integer
    * @author:wujinsong
    */
	public Integer getPrescription(){
		return prescription;
	}
	/**
	* <p>Discription:[时效]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setPrescription(Integer prescription){
		this.prescription = prescription;
	}
	/**
	* <p>Discription:[价格]</p>
	* Created on 2019年08月29日
	* @return java.math.BigDecimal
    * @author:wujinsong
    */
	public java.math.BigDecimal getPrice(){
		return price;
	}
	/**
	* <p>Discription:[价格]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setPrice(java.math.BigDecimal price){
		this.price = price;
	}
}
