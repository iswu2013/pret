package com.pret.open.entity.bo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingsong
 * @title: PretAddressBo
 * @projectName pret
 * @description: TODO
 * @date 2019/10/167:08 下午
 */
@Data
public class PretAddressBo {
    private String firstName = "-";

    private String secondName = "-";

    private String thirdName = "-";

    private List<PretAddressBo> children = new ArrayList<>();
}
