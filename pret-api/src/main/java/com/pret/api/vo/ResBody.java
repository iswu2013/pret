package com.pret.api.vo;

import com.pret.common.constant.Constants;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


/**
 * 返回数据父类
 *
 * @author wujinsong
 */
@XmlRootElement
public class ResBody implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 6892599410002224919L;

    private String status = Constants.SUCCUSS_CODE;

    private String message;

    private Object data;

    private Object ext;

    private String serialNo;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public ResBody setData(Object data) {
        this.data = data;
        return this;
    }

    public Object getExt() {
        return ext;
    }

    public void setExt(Object ext) {
        this.ext = ext;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }
}
