package com.pret.api.info;

/**
 * @author wujingsong
 * @title: TagsInfo
 * @projectName pert
 * @description: TODO
 * @date 2019-08-0900:11
 */
public class TagsInfo extends BaseInfo {
    private String id;
    /**
     * 标签名称，中文
     */
    private String tagName;

    /**
     * 标签名称,英文
     */
    private String tagEname;

    /**
     * 父级
     */
    private String parentId;

    /**
     * 状态
     * 0启用
     * 1停用
     */
    private int status;

    /**
     * 排序
     */
    private int sortNum;

    /**
     * 创建人
     */
    private String createLoginName;

    private String tagsIds;

    private String tagsName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagEname() {
        return tagEname;
    }

    public void setTagEname(String tagEname) {
        this.tagEname = tagEname;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSortNum() {
        return sortNum;
    }

    public void setSortNum(int sortNum) {
        this.sortNum = sortNum;
    }

    public String getCreateLoginName() {
        return createLoginName;
    }

    public void setCreateLoginName(String createLoginName) {
        this.createLoginName = createLoginName;
    }

    public String getTagsIds() {
        return tagsIds;
    }

    public void setTagsIds(String tagsIds) {
        this.tagsIds = tagsIds;
    }

    public String getTagsName() {
        return tagsName;
    }

    public void setTagsName(String tagsName) {
        this.tagsName = tagsName;
    }
}
