package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;
import com.pret.common.constant.ConstantEnum;
import com.pret.open.entity.user.Dept;
import com.wuwenze.poi.annotation.Excel;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 */
@Entity
@Table(name = "pret_member_auth")
@Excel("路由")
@Data
public class PretMemberAuth extends VersionedAuditableIdEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid") //这个是hibernate的注解/生成32位UUID
    @GeneratedValue(generator = "idGenerator")
    @Override
    public String getId() {
        return id;
    }

    private Integer userType;

    private String name;

    private String mobile;

    private String openid;

    private String no;

    private String serviceRouteOriginId;

    private Integer status = ConstantEnum.EAuthStatus.待审核.getLabel();

    private String authUsername;

    private Long authDate;

    private String nickName;

    private String avatarUrl;

    private String deptId;

    private String u9code;

    private Dept dept;

    private String customerId;

    private String salesId;

    private List<PretCustomer> customerList;

    private List<PretSales> salesList;

    @Transient()
    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Transient()
    public List<PretCustomer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<PretCustomer> customerList) {
        this.customerList = customerList;
    }

    @Transient()
    public List<PretSales> getSalesList() {
        return salesList;
    }

    public void setSalesList(List<PretSales> salesList) {
        this.salesList = salesList;
    }
}
