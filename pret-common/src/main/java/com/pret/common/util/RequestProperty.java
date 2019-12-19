package com.pret.common.util;

import lombok.Data;

/**
 * @author wujingsong
 * @title: HeaderProperty
 * @projectName pret
 * @description: TODO
 * @date 2019/12/810:43 上午
 */
@Data
public class RequestProperty {
    private BodyProperty body;
    private HeadProperty head;
}
