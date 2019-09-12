package com.pret.api.vo;

/**
 * @author jswul
 * @title: LangVo
 * @projectName pert
 * @description: 语言
 * @date 2019/7/16 17:29
 */
public class LangVo {
    /**
     * 目标属性
     */
    private String targetProperty;

    /**
     * 中文属性
     */
    private String cnTargetProperty;

    /**
     * 英文属性
     */
    private String enTargetProperty;


    public String getTargetProperty() {
        return targetProperty;
    }

    public void setTargetProperty(String targetProperty) {
        this.targetProperty = targetProperty;
    }

    public String getCnTargetProperty() {
        return cnTargetProperty;
    }

    public void setCnTargetProperty(String cnTargetProperty) {
        this.cnTargetProperty = cnTargetProperty;
    }

    public String getEnTargetProperty() {
        return enTargetProperty;
    }

    public void setEnTargetProperty(String enTargetProperty) {
        this.enTargetProperty = enTargetProperty;
    }
}
