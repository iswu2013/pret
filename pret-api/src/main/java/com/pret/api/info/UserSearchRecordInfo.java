package com.pret.api.info;

/**
 * @author wujingsong
 * @title: UserSearchRecordInfo
 * @projectName pert
 * @description: 用户搜索
 * @date 2019-07-30 17:36
 */
public class UserSearchRecordInfo extends BaseInfo {
    private String id;

    private String keyword;

    private String schoolId;

    private String uid;

    private int count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
