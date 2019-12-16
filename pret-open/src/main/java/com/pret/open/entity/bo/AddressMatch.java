package com.pret.open.entity.bo;

import com.pret.open.entity.PretAddress;
import lombok.Data;

/**
 * @author wujingsong
 * @title: AddressMatch
 * @projectName pret
 * @description: TODO
 * @date 2019/12/161:31 上午
 */
@Data
public class AddressMatch {
    private PretAddress province;

    private PretAddress city;

    private PretAddress area;

    private String serviceRouteItemIdByProvince;

    private String serviceRouteItemIdByCity;

    private String serviceRouteItemIdByArea;
}
