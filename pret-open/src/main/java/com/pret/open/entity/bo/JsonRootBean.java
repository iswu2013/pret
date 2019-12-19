package com.pret.open.entity.bo;

import java.util.List;

/**
 * @author wujingsong
 * @title: JsonRootBean
 * @projectName pret
 * @description: TODO
 * @date 2019/12/197:32 下午
 */
@lombok.Data
public class JsonRootBean {
    private String code;
    private String message;
    private boolean success;
    private List<Data> data;
}
