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
@Table(name = "pert_service_line_item")
public class PertServiceLineItem  extends VersionedAuditableIdEntity implements Serializable {

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
		* 服务线路id
		*/
		private String serviceLineId;
		/**
		* 地址id
		*/
		private String addressId;
	
	// setter and getter
	/**
	* <p>Discription:[服务线路id]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getServiceLineId(){
		return serviceLineId;
	}
	/**
	* <p>Discription:[服务线路id]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setServiceLineId(String serviceLineId){
		this.serviceLineId = serviceLineId;
	}
	/**
	* <p>Discription:[地址id]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getAddressId(){
		return addressId;
	}
	/**
	* <p>Discription:[地址id]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setAddressId(String addressId){
		this.addressId = addressId;
	}
}
