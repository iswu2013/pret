package com.pret.open.entity.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingsong
 * @title: UserTableConfigWithItems
 * @projectName pluto
 * @description: TODO
 * @date 2019/10/319:22 上午
 */
public class PretUserTableConfigWithItems {
    private List<PretTableItemBo> items = new ArrayList<>();

    private List<String> selectItems = new ArrayList<>();

    private boolean checkAll = false;

    private boolean indeterminate = false;

    public List<PretTableItemBo> getItems() {
        return items;
    }

    public void setItems(List<PretTableItemBo> items) {
        this.items = items;
    }

    public List<String> getSelectItems() {
        return selectItems;
    }

    public void setSelectItems(List<String> selectItems) {
        this.selectItems = selectItems;
    }

    public boolean isCheckAll() {
        return checkAll;
    }

    public void setCheckAll(boolean checkAll) {
        this.checkAll = checkAll;
    }

    public boolean isIndeterminate() {
        return indeterminate;
    }

    public void setIndeterminate(boolean indeterminate) {
        this.indeterminate = indeterminate;
    }
}
