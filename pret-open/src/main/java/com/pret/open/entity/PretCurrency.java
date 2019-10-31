package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;

import java.io.Serializable;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * <p>Description: [pretmodel]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Entity
@Table(name = "pret_currency")
@Excel("货币")
public class PretCurrency extends VersionedAuditableIdEntity implements Serializable {

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

    /**
     * 币别名称
     */
    @ExcelField(value = "币别名称")
    private String name;
    /**
     * 币别编码
     */
    @ExcelField(value = "币别编码")
    private String code;

    // setter and getter

    /**
     * <p>Discription:[币别名称]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getName() {
        return name;
    }

    /**
     * <p>Discription:[币别名称]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <p>Discription:[币别编码]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getCode() {
        return code;
    }

    /**
     * <p>Discription:[币别编码]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setCode(String code) {
        this.code = code;
    }
}
