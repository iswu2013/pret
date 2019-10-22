package com.pret.open.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/* *
 * 功能描述: 顺丰配置
 * 〈〉
 * @Param:
        * @Return: 
        * @Author: wujingsong
        * @Date: 2019/10/22  6:22 下午
 */
@Component
@ConfigurationProperties(prefix = "sender")
public class Sender {
    private String name;

    private String phone;

    private String tel;

    private String address;

    private String j_company;

    private String j_contact;

    private String j_tel;

    private String custid;

    private String clientCode;

    private String checkword;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJ_company() {
        return j_company;
    }

    public void setJ_company(String j_company) {
        this.j_company = j_company;
    }

    public String getJ_contact() {
        return j_contact;
    }

    public void setJ_contact(String j_contact) {
        this.j_contact = j_contact;
    }

    public String getJ_tel() {
        return j_tel;
    }

    public void setJ_tel(String j_tel) {
        this.j_tel = j_tel;
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public String getCheckword() {
        return checkword;
    }

    public void setCheckword(String checkword) {
        this.checkword = checkword;
    }
}
