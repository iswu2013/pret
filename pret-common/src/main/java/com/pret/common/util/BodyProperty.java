package com.pret.common.util;

import lombok.Data;

/**
 * @author wujingsong
 * @title: HeaderProperty
 * @projectName pret
 * @description: TODO
 * @date 2019/12/810:43 上午
 */
@Data
public class BodyProperty {
    private String boxNo;

    private String dispatchNo;

    private String storeId;

    private String count;

    private String dcontact;

    private String dtel;

    private String daddress;

    private String jcontact;

    private String jtel;

    private String jaddress;

    private String cargo;

    private String payMethod;

    private String expressType;

    private String isReturnTracking;

    private String custPayTime;
}
