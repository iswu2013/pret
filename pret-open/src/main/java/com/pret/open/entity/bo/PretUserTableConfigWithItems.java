package com.pret.open.entity.bo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingsong
 * @title: UserTableConfigWithItems
 * @projectName pluto
 * @description: TODO
 * @date 2019/10/319:22 上午
 */
@Data
public class PretUserTableConfigWithItems {
    private List<PretTableItemBo> items = new ArrayList<>();

    private List<String> selectItems = new ArrayList<>();

    private boolean checkAll = false;

    private boolean indeterminate = false;
}
