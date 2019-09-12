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
@Table(name = "pert_service_line")
public class PertServiceLine  extends VersionedAuditableIdEntity implements Serializable {

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
		* 供应商
		*/
		private String supplierId;
		/**
		* 出发地
		*/
		private String departure;
		/**
		* 目的地
		*/
		private String destination;
		/**
		* 类型
		*/
		private String type;
	
	// setter and getter
	/**
	* <p>Discription:[供应商]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getSupplierId(){
		return supplierId;
	}
	/**
	* <p>Discription:[供应商]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setSupplierId(String supplierId){
		this.supplierId = supplierId;
	}
	/**
	* <p>Discription:[出发地]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getDeparture(){
		return departure;
	}
	/**
	* <p>Discription:[出发地]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setDeparture(String departure){
		this.departure = departure;
	}
	/**
	* <p>Discription:[目的地]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getDestination(){
		return destination;
	}
	/**
	* <p>Discription:[目的地]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setDestination(String destination){
		this.destination = destination;
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
}
