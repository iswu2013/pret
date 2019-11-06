package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;
import com.wuwenze.poi.annotation.Excel;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * <p>Description: [plutomodel]</p>
 * Created on 2019年10月03日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Entity
@Table(name = "pret_image")
@Excel("图片")
public class PretImage extends VersionedAuditableIdEntity implements Serializable {

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
     * 用户id
     */
    private String userId;
    /**
     * 图片地址
     */
    private String url;
    /**
     * 图标本地地址
     */
    private String path;

    /**
     * 类别
     */
    private String type;

    /**
     * 备注
     */
    private String remark;
    /**
     *
     */
    private String createBy;

    // setter and getter

    /**
     * <p>Discription:[用户id]</p>
     * Created on 2019年10月03日
     *
     * @return Long
     * @author:wujinsong
     */
    public String getUserId() {
        return userId;
    }

    /**
     * <p>Discription:[用户id]</p>
     * Created on 2019年10月03日
     *
     * @author:wujinsong
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * <p>Discription:[图片地址]</p>
     * Created on 2019年10月03日
     *
     * @return String
     * @author:wujinsong
     */
    public String getUrl() {
        return url;
    }

    /**
     * <p>Discription:[图片地址]</p>
     * Created on 2019年10月03日
     *
     * @author:wujinsong
     */
    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * <p>Discription:[图标本地地址]</p>
     * Created on 2019年10月03日
     *
     * @return String
     * @author:wujinsong
     */
    public String getPath() {
        return path;
    }

    /**
     * <p>Discription:[图标本地地址]</p>
     * Created on 2019年10月03日
     *
     * @author:wujinsong
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * <p>Discription:[备注]</p>
     * Created on 2019年10月03日
     *
     * @return String
     * @author:wujinsong
     */
    public String getRemark() {
        return remark;
    }

    /**
     * <p>Discription:[备注]</p>
     * Created on 2019年10月03日
     *
     * @author:wujinsong
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * <p>Discription:[]</p>
     * Created on 2019年10月03日
     *
     * @return String
     * @author:wujinsong
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * <p>Discription:[]</p>
     * Created on 2019年10月03日
     *
     * @author:wujinsong
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}
