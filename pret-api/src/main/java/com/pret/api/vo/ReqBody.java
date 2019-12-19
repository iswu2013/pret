package com.pret.api.vo;

import com.pret.api.info.TypeUserInfo;
import com.pret.api.info.UserInfo;
import com.pret.api.handler.JopHandler;
import com.pret.common.constant.ConstantEnum;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class ReqBody<H extends JopHandler> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String method;// API接口名称

    private String timestamp;// 时间戳，格式为yyyy-MM-dd HH:mm:ss，例如：2013-05-06
    // 13:52:03。API服务端允许客户端请求时间误差为6分钟。

    private String format = "json";// 可选，指定响应格式。默认json,目前支持格式json

    private String app_key;// JOP分配给应用的AppKey ，创建应用时可获得

    private String v;// API协议版本，可选值:1.0。

    /*	private String serial_no; // 流水号
     */
    private String level;

    private String sign;

    private String token;

    private String openid;

    private HttpServletRequest httpRequest;

    /**
     * 是否忽略登录信息
     */
    private Class<? extends ResBody> reqBody;

    /**
     * 处理器
     */
    private H handler;

    /**
     * 是否忽略
     */
    private boolean isIgnoreToken = true;

    /**
     * 用户信息
     */
    private TypeUserInfo userInfo;

    private String sessionId;

    private String viewId;

    /**
     * 语言
     */
    private String lang;

    /**
     * 环境
     */
    private String env;
    /**
     * 是否忽略报文体
     */
    private boolean isIgnoreBody = false;

    private String serialNo;

    @NotBlank
    @Size(max = 100)
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Size(min = 14, max = 14)
    @DateTimeFormat(pattern = "yyyyMMddHHmmss")
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Size(max = 30)
    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Size(max = 30)
    public String getApp_key() {
        return app_key;
    }

    public void setApp_key(String app_key) {
        this.app_key = app_key;
    }

    @NotBlank
    @Size(max = 30)
    @Pattern(message = "版本不支持", regexp = "^1.[0|2|3]$")
    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

	/*@NotBlank
	@Size(min = 19, max = 19)
	public String getSerial_no() {
		return serial_no;
	}

	public void setSerial_no(String serial_no) {
		this.serial_no = serial_no;
	}*/

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public HttpServletRequest getHttpRequest() {
        return httpRequest;
    }

    public void setHttpRequest(HttpServletRequest httpRequest) {
        this.httpRequest = httpRequest;
    }

    public Class<? extends ResBody> getReqBody() {
        return reqBody;
    }

    public void setReqBody(Class<? extends ResBody> reqBody) {
        this.reqBody = reqBody;
    }

    public H getHandler() {
        return handler;
    }

    public void setHandler(H handler) {
        this.handler = handler;
    }

    public boolean isIgnoreToken() {
        return isIgnoreToken;
    }

    public void setIgnoreToken(boolean ignoreToken) {
        isIgnoreToken = ignoreToken;
    }

    public TypeUserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(TypeUserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getViewId() {
        return viewId;
    }

    public void setViewId(String viewId) {
        this.viewId = viewId;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public boolean isIgnoreBody() {
        return isIgnoreBody;
    }

    public void setIgnoreBody(boolean ignoreBody) {
        isIgnoreBody = ignoreBody;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }
}
