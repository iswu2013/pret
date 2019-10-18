package com.pret.open.entity.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingsong
 * @title: PretAddressBo
 * @projectName pret
 * @description: TODO
 * @date 2019/10/167:08 下午
 */
public class PretAddressBo {
    private String firstName= "-";

    private String secondName = "-";

    private String thirdName = "-";

    private List<PretAddressBo> children = new ArrayList<>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public List<PretAddressBo> getChildren() {
        return children;
    }

    public void setChildren(List<PretAddressBo> children) {
        this.children = children;
    }
}
