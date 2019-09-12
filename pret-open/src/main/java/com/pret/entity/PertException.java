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
@Table(name = "pert_exception")
public class PertException  extends VersionedAuditableIdEntity implements Serializable {

	private static final long serialVersionUID = 1L;

		/**
		* 主键
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
		* 订单号
		*/
		private String orderNo;
		/**
		* 异常类别0
		*/
		private Integer type;
		/**
		* 状态0待审核1通过2不通过
		*/
		private Integer status;
		/**
		* 订单明细
		*/
		private String orderItemId;
		/**
		* 异常描述
		*/
		private String remark;
		/**
		* 图片id	
		*/
		private String picIds;
		/**
		* 是否生成退运单0否1是
		*/
		private Integer isReturn;
		/**
		* 异常数量
		*/
		private Integer count;
		/**
		* 处理方式
		*/
		private Integer handleStyle;
		/**
		* 责任方0物流1货主2客户
		*/
		private Integer responsibleParty;
	
	// setter and getter
	/**
	* <p>Discription:[订单号]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getOrderNo(){
		return orderNo;
	}
	/**
	* <p>Discription:[订单号]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setOrderNo(String orderNo){
		this.orderNo = orderNo;
	}
	/**
	* <p>Discription:[异常类别0]</p>
	* Created on 2019年08月29日
	* @return Integer
    * @author:wujinsong
    */
	public Integer getType(){
		return type;
	}
	/**
	* <p>Discription:[异常类别0]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setType(Integer type){
		this.type = type;
	}
	/**
	* <p>Discription:[状态0待审核1通过2不通过]</p>
	* Created on 2019年08月29日
	* @return Integer
    * @author:wujinsong
    */
	public Integer getStatus(){
		return status;
	}
	/**
	* <p>Discription:[状态0待审核1通过2不通过]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setStatus(Integer status){
		this.status = status;
	}
	/**
	* <p>Discription:[订单明细]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getOrderItemId(){
		return orderItemId;
	}
	/**
	* <p>Discription:[订单明细]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setOrderItemId(String orderItemId){
		this.orderItemId = orderItemId;
	}
	/**
	* <p>Discription:[异常描述]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getRemark(){
		return remark;
	}
	/**
	* <p>Discription:[异常描述]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setRemark(String remark){
		this.remark = remark;
	}
	/**
	* <p>Discription:[图片id	]</p>
	* Created on 2019年08月29日
	* @return String
    * @author:wujinsong
    */
	public String getPicIds(){
		return picIds;
	}
	/**
	* <p>Discription:[图片id	]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setPicIds(String picIds){
		this.picIds = picIds;
	}
	/**
	* <p>Discription:[是否生成退运单0否1是]</p>
	* Created on 2019年08月29日
	* @return Integer
    * @author:wujinsong
    */
	public Integer getIsReturn(){
		return isReturn;
	}
	/**
	* <p>Discription:[是否生成退运单0否1是]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setIsReturn(Integer isReturn){
		this.isReturn = isReturn;
	}
	/**
	* <p>Discription:[异常数量]</p>
	* Created on 2019年08月29日
	* @return Integer
    * @author:wujinsong
    */
	public Integer getCount(){
		return count;
	}
	/**
	* <p>Discription:[异常数量]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setCount(Integer count){
		this.count = count;
	}
	/**
	* <p>Discription:[处理方式]</p>
	* Created on 2019年08月29日
	* @return Integer
    * @author:wujinsong
    */
	public Integer getHandleStyle(){
		return handleStyle;
	}
	/**
	* <p>Discription:[处理方式]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setHandleStyle(Integer handleStyle){
		this.handleStyle = handleStyle;
	}
	/**
	* <p>Discription:[责任方0物流1货主2客户]</p>
	* Created on 2019年08月29日
	* @return Integer
    * @author:wujinsong
    */
	public Integer getResponsibleParty(){
		return responsibleParty;
	}
	/**
	* <p>Discription:[责任方0物流1货主2客户]</p>
	* Created on 2019年08月29日
	* @author:wujinsong
	*/
	public void setResponsibleParty(Integer responsibleParty){
		this.responsibleParty = responsibleParty;
	}
}
