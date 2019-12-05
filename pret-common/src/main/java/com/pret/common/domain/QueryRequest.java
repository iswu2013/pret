package com.pret.common.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class QueryRequest implements Serializable {

    private static final long serialVersionUID = -4869594085374385813L;

    private int rows = 10;
    private int page = 1;
    private String sortField;
    private String sortOrder;
    private String parentId;
    private Integer userType;
    private Integer notUserType;
    private String venderId;
}
