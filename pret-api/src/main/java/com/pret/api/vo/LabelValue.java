package com.pret.api.vo;

/**
 * @author wujinsong
 */
public class LabelValue {

    private String label;

    private String value;

    private Integer prescription;

    private String province;

    private String city;

    private String area;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getPrescription() {
        return prescription;
    }

    public void setPrescription(Integer prescription) {
        this.prescription = prescription;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}