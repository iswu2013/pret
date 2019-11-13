package com.pret.open.entity.bo;

import lombok.Data;

/**
 * @author wujingsong
 * @title: AreaBo
 * @projectName pret
 * @description: TODO
 * @date 2019/10/279:34 下午
 */
@Data
public class AreaBo {
    private String area;

    private String city;

    private String label;

    private Integer prescription;

    private String value;

    private String serviceRouteOriginId;

    private String province;
}
