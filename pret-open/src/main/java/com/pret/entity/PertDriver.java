package com.pret.entity;

import com.pret.common.VersionedAuditableIdEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/** 
 * <p>Description: [pertmodel]</p>
 * Created on 2019年08月29日
 * @author  <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0 
 * Copyright (c) 2019年 极客城堡
 */
@Entity
@Table(name = "pert_driver")
public class PertDriver  extends VersionedAuditableIdEntity implements Serializable {

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
		* 司机姓名
		*/
		private String name;
		/**
		* 司机电话
		*/
		private String phone;
		/**
		* 车牌号
		*/
		private String carNumber;
	
	// setter and getter
	/**
	* <p>Discription:[司机姓名]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getName(){
		return name;
	}
	/**
	* <p>Discription:[司机姓名]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setName(String name){
		this.name = name;
	}
	/**
	* <p>Discription:[司机电话]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getPhone(){
		return phone;
	}
	/**
	* <p>Discription:[司机电话]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setPhone(String phone){
		this.phone = phone;
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
}
