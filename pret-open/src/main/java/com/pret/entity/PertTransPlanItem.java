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
@Table(name = "pert_trans_plan_item")
public class PertTransPlanItem  extends VersionedAuditableIdEntity implements Serializable {

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
		* 运输计划id
		*/
		private String transPlanId;
		/**
		* 配送单id
		*/
		private String deliverOrderId;
	
	// setter and getter
	/**
	* <p>Discription:[运输计划id]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getTransPlanId(){
		return transPlanId;
	}
	/**
	* <p>Discription:[运输计划id]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setTransPlanId(String transPlanId){
		this.transPlanId = transPlanId;
	}
	/**
	* <p>Discription:[配送单id]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getDeliverOrderId(){
		return deliverOrderId;
	}
	/**
	* <p>Discription:[配送单id]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setDeliverOrderId(String deliverOrderId){
		this.deliverOrderId = deliverOrderId;
	}
}
