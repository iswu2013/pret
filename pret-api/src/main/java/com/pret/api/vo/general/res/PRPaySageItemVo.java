package com.pret.api.vo.general.res;

/**
 * @author wujingsong
 * @title: PRPaySageItemVo
 * @projectName pert
 * @description: TODO
 * @date 2019-08-1108:37
 */
public class PRPaySageItemVo {
    private String successURL;

    private String failureURL;

    public String getSuccessURL() {
        return successURL;
    }

    public void setSuccessURL(String successURL) {
        this.successURL = successURL;
    }

    public String getFailureURL() {
        return failureURL;
    }

    public void setFailureURL(String failureURL) {
        this.failureURL = failureURL;
    }
}
