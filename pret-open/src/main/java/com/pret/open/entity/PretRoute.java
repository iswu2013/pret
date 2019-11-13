package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;
import com.wuwenze.poi.annotation.Excel;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 */
@Entity
@Table(name = "pret_route")
@Excel("路由")
@Data
public class PretRoute extends VersionedAuditableIdEntity implements Serializable {
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

    private String acceptTime;
    private String acceptAddress;
    private String remark;
    private String opcode;
    private Integer type;
    private String mailno;
    private String transPlanId;
}
