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
@Table(name = "pert_payable_statement")
public class PertPayableStatement  extends VersionedAuditableIdEntity implements Serializable {

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
		* 供应商id
		*/
		private String supplierId;
		/**
		* 应付总金额
		*/
		private java.math.BigDecimal amount;
		/**
		* 费用开始时间
		*/
		private java.util.Date startDate;
		/**
		* 费用结束时间
		*/
		private java.util.Date endDate;
		/**
		* 0待生成1已生成
		*/
		private Integer status;
	
	// setter and getter
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
	* <p>Discription:[应付总金额]</p>
	* Created on 2019年08月29日
	* @return java.math.BigDecimal
    * @author:wujinsong
    */
	public java.math.BigDecimal getAmount(){
		return amount;
	}
	/**
	* <p>Discription:[应付总金额]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setAmount(java.math.BigDecimal amount){
		this.amount = amount;
	}
	/**
	* <p>Discription:[费用开始时间]</p>
	* Created on 2019年08月29日
	* @return java.util.Date
    * @author:wujinsong
    */
	public java.util.Date getStartDate(){
		return startDate;
	}
	/**
	* <p>Discription:[费用开始时间]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setStartDate(java.util.Date startDate){
		this.startDate = startDate;
	}
	/**
	* <p>Discription:[费用结束时间]</p>
	* Created on 2019年08月29日
	* @return java.util.Date
    * @author:wujinsong
    */
	public java.util.Date getEndDate(){
		return endDate;
	}
	/**
	* <p>Discription:[费用结束时间]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setEndDate(java.util.Date endDate){
		this.endDate = endDate;
	}
	/**
	* <p>Discription:[0待生成1已生成]</p>
	* Created on 2019年08月29日
	* @return Integer
    * @author:wujinsong
    */
	public Integer getStatus(){
		return status;
	}
	/**
	* <p>Discription:[0待生成1已生成]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setStatus(Integer status){
		this.status = status;
	}
}
