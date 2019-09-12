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
@Table(name = "pert_goods")
public class PertGoods  extends VersionedAuditableIdEntity implements Serializable {

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
		* 商品名称
		*/
		private String name;
		/**
		* 商品重量
		*/
		private String weight;
		/**
		* 商品单位
		*/
		private Integer unit;
	
	// setter and getter
	/**
	* <p>Discription:[商品名称]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getName(){
		return name;
	}
	/**
	* <p>Discription:[商品名称]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setName(String name){
		this.name = name;
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
	/**
	* <p>Discription:[商品单位]</p>
	* Created on 2019年08月29日
	* @return Integer
    * @author:wujinsong
    */
	public Integer getUnit(){
		return unit;
	}
	/**
	* <p>Discription:[商品单位]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setUnit(Integer unit){
		this.unit = unit;
	}
}
