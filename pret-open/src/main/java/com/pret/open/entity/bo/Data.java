package com.pret.open.entity.bo;

/**
 * @author wujingsong
 * @title: Data
 * @projectName pret
 * @description: TODO
 * @date 2019/12/197:31 下午
 */
@lombok.Data
public class Data {
    private String orderId;
    private String mailno;
    private String boxNo;
    private String sourceTransferCode;
    private String sourceCityCode;
    private String sourceDeptCode;
    private String sourceTeamCode;
    private String destCityCode;
    private String destDeptCode;
    private String destDeptCodeMapping;
    private String destTeamCode;
    private String destTransferCode;
    private String destRouteLabel;
    private String proName;
    private String cargoTypeCode;
    private String limitTypeCode;
    private String expressTypeCode;
    private String codingMapping;
    private String codingMappingOut;
    private String xbFlag;
    private String printFlag;
    private String twoDimensionCode;
    private String proCode;
    private String printIcon;
}
