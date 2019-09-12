package com.pret.api.info;

/**
 * 附件信息
 */
public class AttaInfo {
    /**
     * id
     */
    private Long id;
    /**
     * 所属用户
     */
    private Long userId;

    /**
     * 附件名称
     */
    private String fileName;

    /**
     * 附件类型
     */
    private String fileType;

    /**
     * 附件url
     */
    private String fileUrl;

    /**
     * 持久化id
     */
    private String persistentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getPersistentId() {
        return persistentId;
    }

    public void setPersistentId(String persistentId) {
        this.persistentId = persistentId;
    }
}
