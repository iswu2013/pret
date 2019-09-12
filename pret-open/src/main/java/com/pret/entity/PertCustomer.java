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
@Table(name = "pert_customer")
public class PertCustomer  extends VersionedAuditableIdEntity implements Serializable {

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
		* 客户名称
		*/
		private String name;
		/**
		* 客户地址
		*/
		private String address;
		/**
		* 联系人名称
		*/
		private String linkName;
		/**
		* 联系人电话
		*/
		private String linkPhone;
	
	// setter and getter
	/**
	* <p>Discription:[客户名称]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getName(){
		return name;
	}
	/**
	* <p>Discription:[客户名称]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setName(String name){
		this.name = name;
	}
	/**
	* <p>Discription:[客户地址]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getAddress(){
		return address;
	}
	/**
	* <p>Discription:[客户地址]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setAddress(String address){
		this.address = address;
	}
	/**
	* <p>Discription:[联系人名称]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getLinkName(){
		return linkName;
	}
	/**
	* <p>Discription:[联系人名称]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setLinkName(String linkName){
		this.linkName = linkName;
	}
	/**
	* <p>Discription:[联系人电话]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getLinkPhone(){
		return linkPhone;
	}
	/**
	* <p>Discription:[联系人电话]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setLinkPhone(String linkPhone){
		this.linkPhone = linkPhone;
	}
}
