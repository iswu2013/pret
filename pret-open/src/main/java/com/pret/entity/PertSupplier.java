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
@Table(name = "pert_supplier")
public class PertSupplier  extends VersionedAuditableIdEntity implements Serializable {

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
		* 编号
		*/
		private String code;
		/**
		* 名称
		*/
		private String name;
		/**
		* 出发地
		*/
		private String departure;
		/**
		* 目的地
		*/
		private String destination;
		/**
		* 联系人
		*/
		private String linkName;
		/**
		* 联系号码
		*/
		private String linkPhone;
	
	// setter and getter
	/**
	* <p>Discription:[编号]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getCode(){
		return code;
	}
	/**
	* <p>Discription:[编号]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setCode(String code){
		this.code = code;
	}
	/**
	* <p>Discription:[名称]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getName(){
		return name;
	}
	/**
	* <p>Discription:[名称]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setName(String name){
		this.name = name;
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
	* <p>Discription:[联系人]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getLinkName(){
		return linkName;
	}
	/**
	* <p>Discription:[联系人]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setLinkName(String linkName){
		this.linkName = linkName;
	}
	/**
	* <p>Discription:[联系号码]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getLinkPhone(){
		return linkPhone;
	}
	/**
	* <p>Discription:[联系号码]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setLinkPhone(String linkPhone){
		this.linkPhone = linkPhone;
	}
}
