package com.pret.open.service.handler;

import com.pret.api.vo.ReqBody;
import com.pret.open.vo.req.*;

import java.util.HashMap;
import java.util.Map;
/** 
 * <p>Description: [pretmodel]</p>
 * Created on 2019年09月15日
 * @author  <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0 
 * Copyright (c) 2019年 极客城堡
 */
public class InterfaceConfig  {
/* 接口处理器 */
public static final Map<String, String> JOP_HANDLER = new HashMap<String, String>();
/* 接口处理器 */
public static final Map<String, Class<? extends ReqBody>> JOP_VO = new HashMap<String, Class<? extends ReqBody>>();

	public static final String HPretAdressSave = "pretAdress.save.do";
	public static final String HPretAdressDelete = "pretAdress.delete.do";
	public static final String HPretAdressUpdate = "pretAdress.update.do";
	public static final String HPretAdressQuery = "pretAdress.query.get";
	public static final String HPretAdressDetail = "pretAdress.detail.get";
	public static final String HPretBillingIntervalSave = "pretBillingInterval.save.do";
	public static final String HPretBillingIntervalDelete = "pretBillingInterval.delete.do";
	public static final String HPretBillingIntervalUpdate = "pretBillingInterval.update.do";
	public static final String HPretBillingIntervalQuery = "pretBillingInterval.query.get";
	public static final String HPretBillingIntervalDetail = "pretBillingInterval.detail.get";
	public static final String HPretBillingIntervalItemSave = "pretBillingIntervalItem.save.do";
	public static final String HPretBillingIntervalItemDelete = "pretBillingIntervalItem.delete.do";
	public static final String HPretBillingIntervalItemUpdate = "pretBillingIntervalItem.update.do";
	public static final String HPretBillingIntervalItemQuery = "pretBillingIntervalItem.query.get";
	public static final String HPretBillingIntervalItemDetail = "pretBillingIntervalItem.detail.get";
	public static final String HPretCostPrescriptionSave = "pretCostPrescription.save.do";
	public static final String HPretCostPrescriptionDelete = "pretCostPrescription.delete.do";
	public static final String HPretCostPrescriptionUpdate = "pretCostPrescription.update.do";
	public static final String HPretCostPrescriptionQuery = "pretCostPrescription.query.get";
	public static final String HPretCostPrescriptionDetail = "pretCostPrescription.detail.get";
	public static final String HPretCustomerSave = "pretCustomer.save.do";
	public static final String HPretCustomerDelete = "pretCustomer.delete.do";
	public static final String HPretCustomerUpdate = "pretCustomer.update.do";
	public static final String HPretCustomerQuery = "pretCustomer.query.get";
	public static final String HPretCustomerDetail = "pretCustomer.detail.get";
	public static final String HPretCustomerAddressSave = "pretCustomerAddress.save.do";
	public static final String HPretCustomerAddressDelete = "pretCustomerAddress.delete.do";
	public static final String HPretCustomerAddressUpdate = "pretCustomerAddress.update.do";
	public static final String HPretCustomerAddressQuery = "pretCustomerAddress.query.get";
	public static final String HPretCustomerAddressDetail = "pretCustomerAddress.detail.get";
	public static final String HPretCustomerUpdateSave = "pretCustomerUpdate.save.do";
	public static final String HPretCustomerUpdateDelete = "pretCustomerUpdate.delete.do";
	public static final String HPretCustomerUpdateUpdate = "pretCustomerUpdate.update.do";
	public static final String HPretCustomerUpdateQuery = "pretCustomerUpdate.query.get";
	public static final String HPretCustomerUpdateDetail = "pretCustomerUpdate.detail.get";
	public static final String HPretDriverSave = "pretDriver.save.do";
	public static final String HPretDriverDelete = "pretDriver.delete.do";
	public static final String HPretDriverUpdate = "pretDriver.update.do";
	public static final String HPretDriverQuery = "pretDriver.query.get";
	public static final String HPretDriverDetail = "pretDriver.detail.get";
	public static final String HPretGoodsSave = "pretGoods.save.do";
	public static final String HPretGoodsDelete = "pretGoods.delete.do";
	public static final String HPretGoodsUpdate = "pretGoods.update.do";
	public static final String HPretGoodsQuery = "pretGoods.query.get";
	public static final String HPretGoodsDetail = "pretGoods.detail.get";
	public static final String HPretPayableStatementSave = "pretPayableStatement.save.do";
	public static final String HPretPayableStatementDelete = "pretPayableStatement.delete.do";
	public static final String HPretPayableStatementUpdate = "pretPayableStatement.update.do";
	public static final String HPretPayableStatementQuery = "pretPayableStatement.query.get";
	public static final String HPretPayableStatementDetail = "pretPayableStatement.detail.get";
	public static final String HPretPickUpAddressSave = "pretPickUpAddress.save.do";
	public static final String HPretPickUpAddressDelete = "pretPickUpAddress.delete.do";
	public static final String HPretPickUpAddressUpdate = "pretPickUpAddress.update.do";
	public static final String HPretPickUpAddressQuery = "pretPickUpAddress.query.get";
	public static final String HPretPickUpAddressDetail = "pretPickUpAddress.detail.get";
	public static final String HPretPickUpPlanSave = "pretPickUpPlan.save.do";
	public static final String HPretPickUpPlanDelete = "pretPickUpPlan.delete.do";
	public static final String HPretPickUpPlanUpdate = "pretPickUpPlan.update.do";
	public static final String HPretPickUpPlanQuery = "pretPickUpPlan.query.get";
	public static final String HPretPickUpPlanDetail = "pretPickUpPlan.detail.get";
	public static final String HPretPickUpPlanItemSave = "pretPickUpPlanItem.save.do";
	public static final String HPretPickUpPlanItemDelete = "pretPickUpPlanItem.delete.do";
	public static final String HPretPickUpPlanItemUpdate = "pretPickUpPlanItem.update.do";
	public static final String HPretPickUpPlanItemQuery = "pretPickUpPlanItem.query.get";
	public static final String HPretPickUpPlanItemDetail = "pretPickUpPlanItem.detail.get";
	public static final String HPretQuotationSave = "pretQuotation.save.do";
	public static final String HPretQuotationDelete = "pretQuotation.delete.do";
	public static final String HPretQuotationUpdate = "pretQuotation.update.do";
	public static final String HPretQuotationQuery = "pretQuotation.query.get";
	public static final String HPretQuotationDetail = "pretQuotation.detail.get";
	public static final String HPretQuotationItemSave = "pretQuotationItem.save.do";
	public static final String HPretQuotationItemDelete = "pretQuotationItem.delete.do";
	public static final String HPretQuotationItemUpdate = "pretQuotationItem.update.do";
	public static final String HPretQuotationItemQuery = "pretQuotationItem.query.get";
	public static final String HPretQuotationItemDetail = "pretQuotationItem.detail.get";
	public static final String HPretQuotationItemPriceSave = "pretQuotationItemPrice.save.do";
	public static final String HPretQuotationItemPriceDelete = "pretQuotationItemPrice.delete.do";
	public static final String HPretQuotationItemPriceUpdate = "pretQuotationItemPrice.update.do";
	public static final String HPretQuotationItemPriceQuery = "pretQuotationItemPrice.query.get";
	public static final String HPretQuotationItemPriceDetail = "pretQuotationItemPrice.detail.get";
	public static final String HPretServiceRouteSave = "pretServiceRoute.save.do";
	public static final String HPretServiceRouteDelete = "pretServiceRoute.delete.do";
	public static final String HPretServiceRouteUpdate = "pretServiceRoute.update.do";
	public static final String HPretServiceRouteQuery = "pretServiceRoute.query.get";
	public static final String HPretServiceRouteDetail = "pretServiceRoute.detail.get";
	public static final String HPretServiceRouteItemSave = "pretServiceRouteItem.save.do";
	public static final String HPretServiceRouteItemDelete = "pretServiceRouteItem.delete.do";
	public static final String HPretServiceRouteItemUpdate = "pretServiceRouteItem.update.do";
	public static final String HPretServiceRouteItemQuery = "pretServiceRouteItem.query.get";
	public static final String HPretServiceRouteItemDetail = "pretServiceRouteItem.detail.get";
	public static final String HPretServiceRouteOrginSave = "pretServiceRouteOrgin.save.do";
	public static final String HPretServiceRouteOrginDelete = "pretServiceRouteOrgin.delete.do";
	public static final String HPretServiceRouteOrginUpdate = "pretServiceRouteOrgin.update.do";
	public static final String HPretServiceRouteOrginQuery = "pretServiceRouteOrgin.query.get";
	public static final String HPretServiceRouteOrginDetail = "pretServiceRouteOrgin.detail.get";
	public static final String HPretTransExceptionSave = "pretTransException.save.do";
	public static final String HPretTransExceptionDelete = "pretTransException.delete.do";
	public static final String HPretTransExceptionUpdate = "pretTransException.update.do";
	public static final String HPretTransExceptionQuery = "pretTransException.query.get";
	public static final String HPretTransExceptionDetail = "pretTransException.detail.get";
	public static final String HPretTransFeeSave = "pretTransFee.save.do";
	public static final String HPretTransFeeDelete = "pretTransFee.delete.do";
	public static final String HPretTransFeeUpdate = "pretTransFee.update.do";
	public static final String HPretTransFeeQuery = "pretTransFee.query.get";
	public static final String HPretTransFeeDetail = "pretTransFee.detail.get";
	public static final String HPretTransFeeItemSave = "pretTransFeeItem.save.do";
	public static final String HPretTransFeeItemDelete = "pretTransFeeItem.delete.do";
	public static final String HPretTransFeeItemUpdate = "pretTransFeeItem.update.do";
	public static final String HPretTransFeeItemQuery = "pretTransFeeItem.query.get";
	public static final String HPretTransFeeItemDetail = "pretTransFeeItem.detail.get";
	public static final String HPretTransOrderSave = "pretTransOrder.save.do";
	public static final String HPretTransOrderDelete = "pretTransOrder.delete.do";
	public static final String HPretTransOrderUpdate = "pretTransOrder.update.do";
	public static final String HPretTransOrderQuery = "pretTransOrder.query.get";
	public static final String HPretTransOrderDetail = "pretTransOrder.detail.get";
	public static final String HPretTransOrderItemSave = "pretTransOrderItem.save.do";
	public static final String HPretTransOrderItemDelete = "pretTransOrderItem.delete.do";
	public static final String HPretTransOrderItemUpdate = "pretTransOrderItem.update.do";
	public static final String HPretTransOrderItemQuery = "pretTransOrderItem.query.get";
	public static final String HPretTransOrderItemDetail = "pretTransOrderItem.detail.get";
	public static final String HPretTransPlanSave = "pretTransPlan.save.do";
	public static final String HPretTransPlanDelete = "pretTransPlan.delete.do";
	public static final String HPretTransPlanUpdate = "pretTransPlan.update.do";
	public static final String HPretTransPlanQuery = "pretTransPlan.query.get";
	public static final String HPretTransPlanDetail = "pretTransPlan.detail.get";
	public static final String HPretTransPlanItemSave = "pretTransPlanItem.save.do";
	public static final String HPretTransPlanItemDelete = "pretTransPlanItem.delete.do";
	public static final String HPretTransPlanItemUpdate = "pretTransPlanItem.update.do";
	public static final String HPretTransPlanItemQuery = "pretTransPlanItem.query.get";
	public static final String HPretTransPlanItemDetail = "pretTransPlanItem.detail.get";
	public static final String HPretTransStatementSave = "pretTransStatement.save.do";
	public static final String HPretTransStatementDelete = "pretTransStatement.delete.do";
	public static final String HPretTransStatementUpdate = "pretTransStatement.update.do";
	public static final String HPretTransStatementQuery = "pretTransStatement.query.get";
	public static final String HPretTransStatementDetail = "pretTransStatement.detail.get";
	public static final String HPretTransTrajectorySave = "pretTransTrajectory.save.do";
	public static final String HPretTransTrajectoryDelete = "pretTransTrajectory.delete.do";
	public static final String HPretTransTrajectoryUpdate = "pretTransTrajectory.update.do";
	public static final String HPretTransTrajectoryQuery = "pretTransTrajectory.query.get";
	public static final String HPretTransTrajectoryDetail = "pretTransTrajectory.detail.get";
	public static final String HPretVenderSave = "pretVender.save.do";
	public static final String HPretVenderDelete = "pretVender.delete.do";
	public static final String HPretVenderUpdate = "pretVender.update.do";
	public static final String HPretVenderQuery = "pretVender.query.get";
	public static final String HPretVenderDetail = "pretVender.detail.get";
static {
		JOP_HANDLER.put(HPretAdressSave, "HPretAdressSave");
		JOP_HANDLER.put(HPretAdressDelete, "HPretAdressDelete");
		JOP_HANDLER.put(HPretAdressUpdate, "HPretAdressUpdate");
		JOP_HANDLER.put(HPretAdressQuery, "HPretAdressQuery");
		JOP_HANDLER.put(HPretAdressDetail, "HPretAdressDetail");
		JOP_HANDLER.put(HPretBillingIntervalSave, "HPretBillingIntervalSave");
		JOP_HANDLER.put(HPretBillingIntervalDelete, "HPretBillingIntervalDelete");
		JOP_HANDLER.put(HPretBillingIntervalUpdate, "HPretBillingIntervalUpdate");
		JOP_HANDLER.put(HPretBillingIntervalQuery, "HPretBillingIntervalQuery");
		JOP_HANDLER.put(HPretBillingIntervalDetail, "HPretBillingIntervalDetail");
		JOP_HANDLER.put(HPretBillingIntervalItemSave, "HPretBillingIntervalItemSave");
		JOP_HANDLER.put(HPretBillingIntervalItemDelete, "HPretBillingIntervalItemDelete");
		JOP_HANDLER.put(HPretBillingIntervalItemUpdate, "HPretBillingIntervalItemUpdate");
		JOP_HANDLER.put(HPretBillingIntervalItemQuery, "HPretBillingIntervalItemQuery");
		JOP_HANDLER.put(HPretBillingIntervalItemDetail, "HPretBillingIntervalItemDetail");
		JOP_HANDLER.put(HPretCostPrescriptionSave, "HPretCostPrescriptionSave");
		JOP_HANDLER.put(HPretCostPrescriptionDelete, "HPretCostPrescriptionDelete");
		JOP_HANDLER.put(HPretCostPrescriptionUpdate, "HPretCostPrescriptionUpdate");
		JOP_HANDLER.put(HPretCostPrescriptionQuery, "HPretCostPrescriptionQuery");
		JOP_HANDLER.put(HPretCostPrescriptionDetail, "HPretCostPrescriptionDetail");
		JOP_HANDLER.put(HPretCustomerSave, "HPretCustomerSave");
		JOP_HANDLER.put(HPretCustomerDelete, "HPretCustomerDelete");
		JOP_HANDLER.put(HPretCustomerUpdate, "HPretCustomerUpdate");
		JOP_HANDLER.put(HPretCustomerQuery, "HPretCustomerQuery");
		JOP_HANDLER.put(HPretCustomerDetail, "HPretCustomerDetail");
		JOP_HANDLER.put(HPretCustomerAddressSave, "HPretCustomerAddressSave");
		JOP_HANDLER.put(HPretCustomerAddressDelete, "HPretCustomerAddressDelete");
		JOP_HANDLER.put(HPretCustomerAddressUpdate, "HPretCustomerAddressUpdate");
		JOP_HANDLER.put(HPretCustomerAddressQuery, "HPretCustomerAddressQuery");
		JOP_HANDLER.put(HPretCustomerAddressDetail, "HPretCustomerAddressDetail");
		JOP_HANDLER.put(HPretCustomerUpdateSave, "HPretCustomerUpdateSave");
		JOP_HANDLER.put(HPretCustomerUpdateDelete, "HPretCustomerUpdateDelete");
		JOP_HANDLER.put(HPretCustomerUpdateUpdate, "HPretCustomerUpdateUpdate");
		JOP_HANDLER.put(HPretCustomerUpdateQuery, "HPretCustomerUpdateQuery");
		JOP_HANDLER.put(HPretCustomerUpdateDetail, "HPretCustomerUpdateDetail");
		JOP_HANDLER.put(HPretDriverSave, "HPretDriverSave");
		JOP_HANDLER.put(HPretDriverDelete, "HPretDriverDelete");
		JOP_HANDLER.put(HPretDriverUpdate, "HPretDriverUpdate");
		JOP_HANDLER.put(HPretDriverQuery, "HPretDriverQuery");
		JOP_HANDLER.put(HPretDriverDetail, "HPretDriverDetail");
		JOP_HANDLER.put(HPretGoodsSave, "HPretGoodsSave");
		JOP_HANDLER.put(HPretGoodsDelete, "HPretGoodsDelete");
		JOP_HANDLER.put(HPretGoodsUpdate, "HPretGoodsUpdate");
		JOP_HANDLER.put(HPretGoodsQuery, "HPretGoodsQuery");
		JOP_HANDLER.put(HPretGoodsDetail, "HPretGoodsDetail");
		JOP_HANDLER.put(HPretPayableStatementSave, "HPretPayableStatementSave");
		JOP_HANDLER.put(HPretPayableStatementDelete, "HPretPayableStatementDelete");
		JOP_HANDLER.put(HPretPayableStatementUpdate, "HPretPayableStatementUpdate");
		JOP_HANDLER.put(HPretPayableStatementQuery, "HPretPayableStatementQuery");
		JOP_HANDLER.put(HPretPayableStatementDetail, "HPretPayableStatementDetail");
		JOP_HANDLER.put(HPretPickUpAddressSave, "HPretPickUpAddressSave");
		JOP_HANDLER.put(HPretPickUpAddressDelete, "HPretPickUpAddressDelete");
		JOP_HANDLER.put(HPretPickUpAddressUpdate, "HPretPickUpAddressUpdate");
		JOP_HANDLER.put(HPretPickUpAddressQuery, "HPretPickUpAddressQuery");
		JOP_HANDLER.put(HPretPickUpAddressDetail, "HPretPickUpAddressDetail");
		JOP_HANDLER.put(HPretPickUpPlanSave, "HPretPickUpPlanSave");
		JOP_HANDLER.put(HPretPickUpPlanDelete, "HPretPickUpPlanDelete");
		JOP_HANDLER.put(HPretPickUpPlanUpdate, "HPretPickUpPlanUpdate");
		JOP_HANDLER.put(HPretPickUpPlanQuery, "HPretPickUpPlanQuery");
		JOP_HANDLER.put(HPretPickUpPlanDetail, "HPretPickUpPlanDetail");
		JOP_HANDLER.put(HPretPickUpPlanItemSave, "HPretPickUpPlanItemSave");
		JOP_HANDLER.put(HPretPickUpPlanItemDelete, "HPretPickUpPlanItemDelete");
		JOP_HANDLER.put(HPretPickUpPlanItemUpdate, "HPretPickUpPlanItemUpdate");
		JOP_HANDLER.put(HPretPickUpPlanItemQuery, "HPretPickUpPlanItemQuery");
		JOP_HANDLER.put(HPretPickUpPlanItemDetail, "HPretPickUpPlanItemDetail");
		JOP_HANDLER.put(HPretQuotationSave, "HPretQuotationSave");
		JOP_HANDLER.put(HPretQuotationDelete, "HPretQuotationDelete");
		JOP_HANDLER.put(HPretQuotationUpdate, "HPretQuotationUpdate");
		JOP_HANDLER.put(HPretQuotationQuery, "HPretQuotationQuery");
		JOP_HANDLER.put(HPretQuotationDetail, "HPretQuotationDetail");
		JOP_HANDLER.put(HPretQuotationItemSave, "HPretQuotationItemSave");
		JOP_HANDLER.put(HPretQuotationItemDelete, "HPretQuotationItemDelete");
		JOP_HANDLER.put(HPretQuotationItemUpdate, "HPretQuotationItemUpdate");
		JOP_HANDLER.put(HPretQuotationItemQuery, "HPretQuotationItemQuery");
		JOP_HANDLER.put(HPretQuotationItemDetail, "HPretQuotationItemDetail");
		JOP_HANDLER.put(HPretQuotationItemPriceSave, "HPretQuotationItemPriceSave");
		JOP_HANDLER.put(HPretQuotationItemPriceDelete, "HPretQuotationItemPriceDelete");
		JOP_HANDLER.put(HPretQuotationItemPriceUpdate, "HPretQuotationItemPriceUpdate");
		JOP_HANDLER.put(HPretQuotationItemPriceQuery, "HPretQuotationItemPriceQuery");
		JOP_HANDLER.put(HPretQuotationItemPriceDetail, "HPretQuotationItemPriceDetail");
		JOP_HANDLER.put(HPretServiceRouteSave, "HPretServiceRouteSave");
		JOP_HANDLER.put(HPretServiceRouteDelete, "HPretServiceRouteDelete");
		JOP_HANDLER.put(HPretServiceRouteUpdate, "HPretServiceRouteUpdate");
		JOP_HANDLER.put(HPretServiceRouteQuery, "HPretServiceRouteQuery");
		JOP_HANDLER.put(HPretServiceRouteDetail, "HPretServiceRouteDetail");
		JOP_HANDLER.put(HPretServiceRouteItemSave, "HPretServiceRouteItemSave");
		JOP_HANDLER.put(HPretServiceRouteItemDelete, "HPretServiceRouteItemDelete");
		JOP_HANDLER.put(HPretServiceRouteItemUpdate, "HPretServiceRouteItemUpdate");
		JOP_HANDLER.put(HPretServiceRouteItemQuery, "HPretServiceRouteItemQuery");
		JOP_HANDLER.put(HPretServiceRouteItemDetail, "HPretServiceRouteItemDetail");
		JOP_HANDLER.put(HPretServiceRouteOrginSave, "HPretServiceRouteOrginSave");
		JOP_HANDLER.put(HPretServiceRouteOrginDelete, "HPretServiceRouteOrginDelete");
		JOP_HANDLER.put(HPretServiceRouteOrginUpdate, "HPretServiceRouteOrginUpdate");
		JOP_HANDLER.put(HPretServiceRouteOrginQuery, "HPretServiceRouteOrginQuery");
		JOP_HANDLER.put(HPretServiceRouteOrginDetail, "HPretServiceRouteOrginDetail");
		JOP_HANDLER.put(HPretTransExceptionSave, "HPretTransExceptionSave");
		JOP_HANDLER.put(HPretTransExceptionDelete, "HPretTransExceptionDelete");
		JOP_HANDLER.put(HPretTransExceptionUpdate, "HPretTransExceptionUpdate");
		JOP_HANDLER.put(HPretTransExceptionQuery, "HPretTransExceptionQuery");
		JOP_HANDLER.put(HPretTransExceptionDetail, "HPretTransExceptionDetail");
		JOP_HANDLER.put(HPretTransFeeSave, "HPretTransFeeSave");
		JOP_HANDLER.put(HPretTransFeeDelete, "HPretTransFeeDelete");
		JOP_HANDLER.put(HPretTransFeeUpdate, "HPretTransFeeUpdate");
		JOP_HANDLER.put(HPretTransFeeQuery, "HPretTransFeeQuery");
		JOP_HANDLER.put(HPretTransFeeDetail, "HPretTransFeeDetail");
		JOP_HANDLER.put(HPretTransFeeItemSave, "HPretTransFeeItemSave");
		JOP_HANDLER.put(HPretTransFeeItemDelete, "HPretTransFeeItemDelete");
		JOP_HANDLER.put(HPretTransFeeItemUpdate, "HPretTransFeeItemUpdate");
		JOP_HANDLER.put(HPretTransFeeItemQuery, "HPretTransFeeItemQuery");
		JOP_HANDLER.put(HPretTransFeeItemDetail, "HPretTransFeeItemDetail");
		JOP_HANDLER.put(HPretTransOrderSave, "HPretTransOrderSave");
		JOP_HANDLER.put(HPretTransOrderDelete, "HPretTransOrderDelete");
		JOP_HANDLER.put(HPretTransOrderUpdate, "HPretTransOrderUpdate");
		JOP_HANDLER.put(HPretTransOrderQuery, "HPretTransOrderQuery");
		JOP_HANDLER.put(HPretTransOrderDetail, "HPretTransOrderDetail");
		JOP_HANDLER.put(HPretTransOrderItemSave, "HPretTransOrderItemSave");
		JOP_HANDLER.put(HPretTransOrderItemDelete, "HPretTransOrderItemDelete");
		JOP_HANDLER.put(HPretTransOrderItemUpdate, "HPretTransOrderItemUpdate");
		JOP_HANDLER.put(HPretTransOrderItemQuery, "HPretTransOrderItemQuery");
		JOP_HANDLER.put(HPretTransOrderItemDetail, "HPretTransOrderItemDetail");
		JOP_HANDLER.put(HPretTransPlanSave, "HPretTransPlanSave");
		JOP_HANDLER.put(HPretTransPlanDelete, "HPretTransPlanDelete");
		JOP_HANDLER.put(HPretTransPlanUpdate, "HPretTransPlanUpdate");
		JOP_HANDLER.put(HPretTransPlanQuery, "HPretTransPlanQuery");
		JOP_HANDLER.put(HPretTransPlanDetail, "HPretTransPlanDetail");
		JOP_HANDLER.put(HPretTransPlanItemSave, "HPretTransPlanItemSave");
		JOP_HANDLER.put(HPretTransPlanItemDelete, "HPretTransPlanItemDelete");
		JOP_HANDLER.put(HPretTransPlanItemUpdate, "HPretTransPlanItemUpdate");
		JOP_HANDLER.put(HPretTransPlanItemQuery, "HPretTransPlanItemQuery");
		JOP_HANDLER.put(HPretTransPlanItemDetail, "HPretTransPlanItemDetail");
		JOP_HANDLER.put(HPretTransStatementSave, "HPretTransStatementSave");
		JOP_HANDLER.put(HPretTransStatementDelete, "HPretTransStatementDelete");
		JOP_HANDLER.put(HPretTransStatementUpdate, "HPretTransStatementUpdate");
		JOP_HANDLER.put(HPretTransStatementQuery, "HPretTransStatementQuery");
		JOP_HANDLER.put(HPretTransStatementDetail, "HPretTransStatementDetail");
		JOP_HANDLER.put(HPretTransTrajectorySave, "HPretTransTrajectorySave");
		JOP_HANDLER.put(HPretTransTrajectoryDelete, "HPretTransTrajectoryDelete");
		JOP_HANDLER.put(HPretTransTrajectoryUpdate, "HPretTransTrajectoryUpdate");
		JOP_HANDLER.put(HPretTransTrajectoryQuery, "HPretTransTrajectoryQuery");
		JOP_HANDLER.put(HPretTransTrajectoryDetail, "HPretTransTrajectoryDetail");
		JOP_HANDLER.put(HPretVenderSave, "HPretVenderSave");
		JOP_HANDLER.put(HPretVenderDelete, "HPretVenderDelete");
		JOP_HANDLER.put(HPretVenderUpdate, "HPretVenderUpdate");
		JOP_HANDLER.put(HPretVenderQuery, "HPretVenderQuery");
		JOP_HANDLER.put(HPretVenderDetail, "HPretVenderDetail");
}

static {
		JOP_VO.put(HPretAdressSave, PPretAdressSaveVo.class);
		JOP_VO.put(HPretAdressDelete, PPretAdressDeleteVo.class);
		JOP_VO.put(HPretAdressUpdate, PPretAdressUpdateVo.class);
		JOP_VO.put(HPretAdressQuery, PPretAdressQueryVo.class);
		JOP_VO.put(HPretAdressDetail, PPretAdressDetailVo.class);
		JOP_VO.put(HPretBillingIntervalSave, PPretBillingIntervalSaveVo.class);
		JOP_VO.put(HPretBillingIntervalDelete, PPretBillingIntervalDeleteVo.class);
		JOP_VO.put(HPretBillingIntervalUpdate, PPretBillingIntervalUpdateVo.class);
		JOP_VO.put(HPretBillingIntervalQuery, PPretBillingIntervalQueryVo.class);
		JOP_VO.put(HPretBillingIntervalDetail, PPretBillingIntervalDetailVo.class);
		JOP_VO.put(HPretBillingIntervalItemSave, PPretBillingIntervalItemSaveVo.class);
		JOP_VO.put(HPretBillingIntervalItemDelete, PPretBillingIntervalItemDeleteVo.class);
		JOP_VO.put(HPretBillingIntervalItemUpdate, PPretBillingIntervalItemUpdateVo.class);
		JOP_VO.put(HPretBillingIntervalItemQuery, PPretBillingIntervalItemQueryVo.class);
		JOP_VO.put(HPretBillingIntervalItemDetail, PPretBillingIntervalItemDetailVo.class);
		JOP_VO.put(HPretCustomerSave, PPretCustomerSaveVo.class);
		JOP_VO.put(HPretCustomerDelete, PPretCustomerDeleteVo.class);
		JOP_VO.put(HPretCustomerUpdate, PPretCustomerUpdateVo.class);
		JOP_VO.put(HPretCustomerQuery, PPretCustomerQueryVo.class);
		JOP_VO.put(HPretCustomerDetail, PPretCustomerDetailVo.class);
		JOP_VO.put(HPretCustomerAddressSave, PPretCustomerAddressSaveVo.class);
		JOP_VO.put(HPretCustomerAddressDelete, PPretCustomerAddressDeleteVo.class);
		JOP_VO.put(HPretCustomerAddressUpdate, PPretCustomerAddressUpdateVo.class);
		JOP_VO.put(HPretCustomerAddressQuery, PPretCustomerAddressQueryVo.class);
		JOP_VO.put(HPretCustomerAddressDetail, PPretCustomerAddressDetailVo.class);
		JOP_VO.put(HPretCustomerUpdateSave, PPretCustomerUpdateSaveVo.class);
		JOP_VO.put(HPretCustomerUpdateDelete, PPretCustomerUpdateDeleteVo.class);
		JOP_VO.put(HPretCustomerUpdateUpdate, PPretCustomerUpdateUpdateVo.class);
		JOP_VO.put(HPretCustomerUpdateQuery, PPretCustomerUpdateQueryVo.class);
		JOP_VO.put(HPretCustomerUpdateDetail, PPretCustomerUpdateDetailVo.class);
		JOP_VO.put(HPretDriverSave, PPretDriverSaveVo.class);
		JOP_VO.put(HPretDriverDelete, PPretDriverDeleteVo.class);
		JOP_VO.put(HPretDriverUpdate, PPretDriverUpdateVo.class);
		JOP_VO.put(HPretDriverQuery, PPretDriverQueryVo.class);
		JOP_VO.put(HPretDriverDetail, PPretDriverDetailVo.class);
		JOP_VO.put(HPretGoodsSave, PPretGoodsSaveVo.class);
		JOP_VO.put(HPretGoodsDelete, PPretGoodsDeleteVo.class);
		JOP_VO.put(HPretGoodsUpdate, PPretGoodsUpdateVo.class);
		JOP_VO.put(HPretGoodsQuery, PPretGoodsQueryVo.class);
		JOP_VO.put(HPretGoodsDetail, PPretGoodsDetailVo.class);
		JOP_VO.put(HPretPickUpAddressSave, PPretPickUpAddressSaveVo.class);
		JOP_VO.put(HPretPickUpAddressDelete, PPretPickUpAddressDeleteVo.class);
		JOP_VO.put(HPretPickUpAddressUpdate, PPretPickUpAddressUpdateVo.class);
		JOP_VO.put(HPretPickUpAddressQuery, PPretPickUpAddressQueryVo.class);
		JOP_VO.put(HPretPickUpAddressDetail, PPretPickUpAddressDetailVo.class);
		JOP_VO.put(HPretPickUpPlanSave, PPretPickUpPlanSaveVo.class);
		JOP_VO.put(HPretPickUpPlanDelete, PPretPickUpPlanDeleteVo.class);
		JOP_VO.put(HPretPickUpPlanUpdate, PPretPickUpPlanUpdateVo.class);
		JOP_VO.put(HPretPickUpPlanQuery, PPretPickUpPlanQueryVo.class);
		JOP_VO.put(HPretPickUpPlanDetail, PPretPickUpPlanDetailVo.class);
		JOP_VO.put(HPretPickUpPlanItemSave, PPretPickUpPlanItemSaveVo.class);
		JOP_VO.put(HPretPickUpPlanItemDelete, PPretPickUpPlanItemDeleteVo.class);
		JOP_VO.put(HPretPickUpPlanItemUpdate, PPretPickUpPlanItemUpdateVo.class);
		JOP_VO.put(HPretPickUpPlanItemQuery, PPretPickUpPlanItemQueryVo.class);
		JOP_VO.put(HPretPickUpPlanItemDetail, PPretPickUpPlanItemDetailVo.class);
		JOP_VO.put(HPretQuotationSave, PPretQuotationSaveVo.class);
		JOP_VO.put(HPretQuotationDelete, PPretQuotationDeleteVo.class);
		JOP_VO.put(HPretQuotationUpdate, PPretQuotationUpdateVo.class);
		JOP_VO.put(HPretQuotationQuery, PPretQuotationQueryVo.class);
		JOP_VO.put(HPretQuotationDetail, PPretQuotationDetailVo.class);
		JOP_VO.put(HPretQuotationItemSave, PPretQuotationItemSaveVo.class);
		JOP_VO.put(HPretQuotationItemDelete, PPretQuotationItemDeleteVo.class);
		JOP_VO.put(HPretQuotationItemUpdate, PPretQuotationItemUpdateVo.class);
		JOP_VO.put(HPretQuotationItemQuery, PPretQuotationItemQueryVo.class);
		JOP_VO.put(HPretQuotationItemDetail, PPretQuotationItemDetailVo.class);
		JOP_VO.put(HPretQuotationItemPriceSave, PPretQuotationItemPriceSaveVo.class);
		JOP_VO.put(HPretQuotationItemPriceDelete, PPretQuotationItemPriceDeleteVo.class);
		JOP_VO.put(HPretQuotationItemPriceUpdate, PPretQuotationItemPriceUpdateVo.class);
		JOP_VO.put(HPretQuotationItemPriceQuery, PPretQuotationItemPriceQueryVo.class);
		JOP_VO.put(HPretQuotationItemPriceDetail, PPretQuotationItemPriceDetailVo.class);
		JOP_VO.put(HPretServiceRouteSave, PPretServiceRouteSaveVo.class);
		JOP_VO.put(HPretServiceRouteDelete, PPretServiceRouteDeleteVo.class);
		JOP_VO.put(HPretServiceRouteUpdate, PPretServiceRouteUpdateVo.class);
		JOP_VO.put(HPretServiceRouteQuery, PPretServiceRouteQueryVo.class);
		JOP_VO.put(HPretServiceRouteDetail, PPretServiceRouteDetailVo.class);
		JOP_VO.put(HPretServiceRouteItemSave, PPretServiceRouteItemSaveVo.class);
		JOP_VO.put(HPretServiceRouteItemDelete, PPretServiceRouteItemDeleteVo.class);
		JOP_VO.put(HPretServiceRouteItemUpdate, PPretServiceRouteItemUpdateVo.class);
		JOP_VO.put(HPretServiceRouteItemQuery, PPretServiceRouteItemQueryVo.class);
		JOP_VO.put(HPretServiceRouteItemDetail, PPretServiceRouteItemDetailVo.class);
		JOP_VO.put(HPretServiceRouteOrginSave, PPretServiceRouteOrginSaveVo.class);
		JOP_VO.put(HPretServiceRouteOrginDelete, PPretServiceRouteOrginDeleteVo.class);
		JOP_VO.put(HPretServiceRouteOrginUpdate, PPretServiceRouteOrginUpdateVo.class);
		JOP_VO.put(HPretServiceRouteOrginQuery, PPretServiceRouteOrginQueryVo.class);
		JOP_VO.put(HPretServiceRouteOrginDetail, PPretServiceRouteOrginDetailVo.class);
		JOP_VO.put(HPretTransExceptionSave, PPretTransExceptionSaveVo.class);
		JOP_VO.put(HPretTransExceptionDelete, PPretTransExceptionDeleteVo.class);
		JOP_VO.put(HPretTransExceptionUpdate, PPretTransExceptionUpdateVo.class);
		JOP_VO.put(HPretTransExceptionQuery, PPretTransExceptionQueryVo.class);
		JOP_VO.put(HPretTransExceptionDetail, PPretTransExceptionDetailVo.class);
		JOP_VO.put(HPretTransFeeSave, PPretTransFeeSaveVo.class);
		JOP_VO.put(HPretTransFeeDelete, PPretTransFeeDeleteVo.class);
		JOP_VO.put(HPretTransFeeUpdate, PPretTransFeeUpdateVo.class);
		JOP_VO.put(HPretTransFeeQuery, PPretTransFeeQueryVo.class);
		JOP_VO.put(HPretTransFeeDetail, PPretTransFeeDetailVo.class);
		JOP_VO.put(HPretTransFeeItemSave, PPretTransFeeItemSaveVo.class);
		JOP_VO.put(HPretTransFeeItemDelete, PPretTransFeeItemDeleteVo.class);
		JOP_VO.put(HPretTransFeeItemUpdate, PPretTransFeeItemUpdateVo.class);
		JOP_VO.put(HPretTransFeeItemQuery, PPretTransFeeItemQueryVo.class);
		JOP_VO.put(HPretTransFeeItemDetail, PPretTransFeeItemDetailVo.class);
		JOP_VO.put(HPretTransOrderSave, PPretTransOrderSaveVo.class);
		JOP_VO.put(HPretTransOrderDelete, PPretTransOrderDeleteVo.class);
		JOP_VO.put(HPretTransOrderUpdate, PPretTransOrderUpdateVo.class);
		JOP_VO.put(HPretTransOrderQuery, PPretTransOrderQueryVo.class);
		JOP_VO.put(HPretTransOrderDetail, PPretTransOrderDetailVo.class);
		JOP_VO.put(HPretTransOrderItemSave, PPretTransOrderItemSaveVo.class);
		JOP_VO.put(HPretTransOrderItemDelete, PPretTransOrderItemDeleteVo.class);
		JOP_VO.put(HPretTransOrderItemUpdate, PPretTransOrderItemUpdateVo.class);
		JOP_VO.put(HPretTransOrderItemQuery, PPretTransOrderItemQueryVo.class);
		JOP_VO.put(HPretTransOrderItemDetail, PPretTransOrderItemDetailVo.class);
		JOP_VO.put(HPretTransPlanSave, PPretTransPlanSaveVo.class);
		JOP_VO.put(HPretTransPlanDelete, PPretTransPlanDeleteVo.class);
		JOP_VO.put(HPretTransPlanUpdate, PPretTransPlanUpdateVo.class);
		JOP_VO.put(HPretTransPlanQuery, PPretTransPlanQueryVo.class);
		JOP_VO.put(HPretTransPlanDetail, PPretTransPlanDetailVo.class);
		JOP_VO.put(HPretTransStatementSave, PPretTransStatementSaveVo.class);
		JOP_VO.put(HPretTransStatementDelete, PPretTransStatementDeleteVo.class);
		JOP_VO.put(HPretTransStatementUpdate, PPretTransStatementUpdateVo.class);
		JOP_VO.put(HPretTransStatementQuery, PPretTransStatementQueryVo.class);
		JOP_VO.put(HPretTransStatementDetail, PPretTransStatementDetailVo.class);
		JOP_VO.put(HPretTransTrajectorySave, PPretTransTrajectorySaveVo.class);
		JOP_VO.put(HPretTransTrajectoryDelete, PPretTransTrajectoryDeleteVo.class);
		JOP_VO.put(HPretTransTrajectoryUpdate, PPretTransTrajectoryUpdateVo.class);
		JOP_VO.put(HPretTransTrajectoryQuery, PPretTransTrajectoryQueryVo.class);
		JOP_VO.put(HPretTransTrajectoryDetail, PPretTransTrajectoryDetailVo.class);
		JOP_VO.put(HPretVenderSave, PPretVenderSaveVo.class);
		JOP_VO.put(HPretVenderDelete, PPretVenderDeleteVo.class);
		JOP_VO.put(HPretVenderUpdate, PPretVenderUpdateVo.class);
		JOP_VO.put(HPretVenderQuery, PPretVenderQueryVo.class);
		JOP_VO.put(HPretVenderDetail, PPretVenderDetailVo.class);
		JOP_VO.put(HPretVenderDetail, PPretVenderDetailVo.class);
}
}
