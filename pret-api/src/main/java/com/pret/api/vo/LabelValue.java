package com.pret.api.vo;

import lombok.Data;

/**
 * @author wujinsong
 */
@Data
public class LabelValue {

    private String label;

    private String value;

    private Float prescription;

    private String province;

    private String city;

    private String area;

    private Float lowerLimit;

    private Float mileage;
}