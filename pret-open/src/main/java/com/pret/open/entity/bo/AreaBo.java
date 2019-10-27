package com.pret.open.entity.bo;

/**
 * @author wujingsong
 * @title: AreaBo
 * @projectName pret
 * @description: TODO
 * @date 2019/10/279:34 下午
 */
public class AreaBo {
    private String area;

    private String city;

    private String label;

    private Integer prescription;

    private String value;

    private String serviceRouteOrginId;

    private String province;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getPrescription() {
        return prescription;
    }

    public void setPrescription(Integer prescription) {
        this.prescription = prescription;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getServiceRouteOrginId() {
        return serviceRouteOrginId;
    }

    public void setServiceRouteOrginId(String serviceRouteOrginId) {
        this.serviceRouteOrginId = serviceRouteOrginId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
