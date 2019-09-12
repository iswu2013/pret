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
@Table(name = "pert_trans_trajectory")
public class PertTransTrajectory  extends VersionedAuditableIdEntity implements Serializable {

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
		* 司机id
		*/
		private String driverId;
		/**
		* 位置
		*/
		private String position;
		/**
		* 备注
		*/
		private String remark;
	
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
	* <p>Discription:[司机id]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getDriverId(){
		return driverId;
	}
	/**
	* <p>Discription:[司机id]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setDriverId(String driverId){
		this.driverId = driverId;
	}
	/**
	* <p>Discription:[位置]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getPosition(){
		return position;
	}
	/**
	* <p>Discription:[位置]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setPosition(String position){
		this.position = position;
	}
	/**
	* <p>Discription:[备注]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getRemark(){
		return remark;
	}
	/**
	* <p>Discription:[备注]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setRemark(String remark){
		this.remark = remark;
	}
}
