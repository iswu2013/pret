package com.pret.api.vo.general;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pret.api.vo.ResBody;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * 通用类，表示小篇和单图小篇
 */
@XmlRootElement(name = "ResBody")
public class DocToElas extends ResBody {
    private Long id;

    /**
     * 关联id
     */
    private Long orgId;

    private int type;

    private String title;

    private String attaUrl;

    private String name;

    private boolean self;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastModifiedDate;

    private boolean displayName;

    private String pTitle;

    /**
     * 是否授权
     */
    private boolean authorize;

    /**
     * 授权类别
     */
    private String authorizeType;

    private boolean spread;

    /**
     * 小篇状态
     */
    private String msgStatus;

    /**
     * 手机号网址
     */
    private String phoneWebsite;

    /**
     * 短网址
     */
    private String shortWebsite;

    /**
     * 网址类型
     */
    private String websiteType;

    /**
     * 是否置顶
     */
    private boolean top;

    private boolean coll;

    private Long userId;

    private Date lastModifyDate;

    private boolean def;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAttaUrl() {
        return attaUrl;
    }

    public void setAttaUrl(String attaUrl) {
        this.attaUrl = attaUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelf() {
        return self;
    }

    public void setSelf(boolean self) {
        this.self = self;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public boolean isDisplayName() {
        return displayName;
    }

    public void setDisplayName(boolean displayName) {
        this.displayName = displayName;
    }

    public String getpTitle() {
        return pTitle;
    }

    public void setpTitle(String pTitle) {
        this.pTitle = pTitle;
    }

    public boolean isAuthorize() {
        return authorize;
    }

    public void setAuthorize(boolean authorize) {
        this.authorize = authorize;
    }

    public String getAuthorizeType() {
        return authorizeType;
    }

    public void setAuthorizeType(String authorizeType) {
        this.authorizeType = authorizeType;
    }

    public boolean isSpread() {
        return spread;
    }

    public void setSpread(boolean spread) {
        this.spread = spread;
    }

    public String getMsgStatus() {
        return msgStatus;
    }

    public void setMsgStatus(String msgStatus) {
        this.msgStatus = msgStatus;
    }

    public String getPhoneWebsite() {
        return phoneWebsite;
    }

    public void setPhoneWebsite(String phoneWebsite) {
        this.phoneWebsite = phoneWebsite;
    }

    public String getShortWebsite() {
        return shortWebsite;
    }

    public void setShortWebsite(String shortWebsite) {
        this.shortWebsite = shortWebsite;
    }

    public String getWebsiteType() {
        return websiteType;
    }

    public void setWebsiteType(String websiteType) {
        this.websiteType = websiteType;
    }

    public boolean isTop() {
        return top;
    }

    public void setTop(boolean top) {
        this.top = top;
    }

    public boolean isColl() {
        return coll;
    }

    public void setColl(boolean coll) {
        this.coll = coll;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(Date lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }

    public boolean isDef() {
        return def;
    }

    public void setDef(boolean def) {
        this.def = def;
    }
}
