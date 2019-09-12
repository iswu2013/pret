package com.pret.api.vo.general;

import com.pret.api.vo.PageReqBody;

public class DocReq extends PageReqBody {
    private Long userId;

    private String type;

    private boolean isData = true;

    private String title;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isData() {
        return isData;
    }

    public void setData(boolean data) {
        isData = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
