package com.pret.common.constant;

import org.apache.commons.lang3.time.FastDateFormat;

import com.google.gson.Gson;

/**
 * 常量类
 *
 * @author wujinsong
 */
public class Constants {
    public static final String FILEPATHIMG = "/home/upload/image/"; // 图片上传路径

    /**
     * 正确返回码
     */
    public static final String SUCCUSS_CODE = "000000";
    /**
     * 服务器处理异常
     */
    public static final String ERROR_CODE = "000001";
    /**
     * 服务器处理异常
     */
    public static final String S_ERROR_CODE = "服务器处理异常";

    /**
     * 请求方式不正确
     */
    public static final String METHOD_ERROR = "000002";
    /**
     * 请求方式不正确
     */
    public static final String S_METHOD_ERROR = "请求方式不正确";

    /**
     * 参数错误
     */
    public static final String PARAM_ERROR = "000003";
    /**
     * 参数错误
     */
    public static final String S_PARAM_ERROR = "参数错误";

    /**
     * 系统错误
     */
    public static final String SYSTEM_ERROR = "000004";
    /**
     * 系统错误
     */
    public static final String S_SYSTEM_ERROR = "系统错误";
    /**
     * 时间误差过大
     */
    public static final String BUSI_ERROR_000005 = "000005";
    /**
     * 时间误差过大
     */
    public static final String S_BUSI_ERROR_000005 = "时间误差过大";

    /**
     * 参数列表错误
     */
    public static final String BUSI_ERROR_000006 = "000006";
    /**
     * 参数列表错误
     */
    public static final String S_BUSI_ERROR_000006 = "参数列表错误";

    /**
     * 方法名不存在
     */
    public static final String BUSI_ERROR_000007 = "000007";
    /**
     * 方法名不存在
     */
    public static final String S_BUSI_ERROR_000007 = "方法名不存在";

    /**
     * 不支持的响应格式
     */
    public static final String BUSI_ERROR_000008 = "000008";
    /**
     * 不支持的响应格式
     */
    public static final String S_BUSI_ERROR_000008 = "不支持的响应格式";

    /**
     * 重复请求
     */
    public static final String BUSI_ERROR_000009 = "000009";
    /**
     *
     */
    public static final String S_BUSI_ERROR_000009 = "重复请求";

    /**
     * sign不正确
     */
    public static final String BUSI_ERROR_000010 = "000010";

    /**
     * sign不正确
     */
    public static final String S_BUSI_ERROR_000010 = "sign不正确";

    /**
     * 未登陆
     */
    public static final String BUSI_ERROR_000011 = "000011";

    /**
     * 未登陆
     */
    public static final String S_BUSI_ERROR_000011 = "未登陆";

    /**
     * ip不在白名单中
     */
    public static final String S_BUSI_ERROR_000012 = "ip不在白名单中";

    /**
     * 账户不可用
     */
    public static final String BUSI_ERROR_000013 = "000013";

    /**
     * 账户不可用
     */
    public static final String S_BUSI_ERROR_000013 = "账户不可用";

    /**
     * 账户不可用
     */
    public static final String BUSI_ERROR_000014 = "000014";

    /**
     * 账户不可用
     */
    public static final String S_BUSI_ERROR_000014 = "账户不可用";

    /**
     * 用户信息获取失败，请重新登录
     */
    public static final String BUSI_ERROR_000015 = "000015";

    /**
     * 用户信息获取失败，请重新登录
     */
    public static final String S_BUSI_ERROR_000015 = "用户信息获取失败，请重新登录";

    /**
     * 七牛ak
     */
    public static final String qiniu_ak = "ysduD_Oe2H0cugDJ9p1of_ERb3c1tTlLshxwH44M";

    /**
     * 七牛sk
     */
    public static final String qiniu_sk = "XHbtMFBw9DO1rJt2aiHZJRvE-lgcQAXef8HdZpuz";

    /**
     *
     */
    public static final String qiniu_bucket = "duanxunproject";

    /**
     * 七牛云url
     */
    public static final String qiniu_url = "oi42x1205.bkt.clouddn.com/";

    /**
     * 管道
     */
    public static final String qiniu_pipeline = "duanxunstack";

    /**
     * APPSCRET
     */
    public static final String APP_SCRET = "clothing_app_scret";

    /**
     * 年月日时分秒
     */
    public static FastDateFormat df2 = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");

    public static FastDateFormat dfyyyyMMdd = FastDateFormat.getInstance("yyyy-MM-dd");

    public static FastDateFormat df_ddMMyyHHmmss = FastDateFormat.getInstance("ddMMyyHHmmss");

    public static FastDateFormat df_yyyyMMddHHmmssSSS = FastDateFormat.getInstance("yyyyMMddHHmmssSSS");

    /**
     * 服务器端ip
     */
    public static final String LOCAL_IP = "127.0.0.1";
    public static final String LOCALHOST_IP = "0:0:0:0:0:0:0:1";

    /**
     * 七牛云上传成功URL
     */
    public static final String QINIU_UPLOAD_URL = "qiniu_upload_url";

    /**
     * 七牛云上传成功key
     */
    public static final String QINIU_UPLOAD_KEY = "qiniu_upload_key";

    /**
     * 七牛云文件类型
     */
    public static final String QINIU_UPLOAD_FILETYPE = "qiniu_upload_filetype";

    /**
     * 名称
     */
    public static final String QINIU_UPLOAD_FILENAME = "qiniu_upload_filename";

    /**
     * 七牛云上传成功附件id
     */
    public static final String QINIU_UPLOAD_ATTACHMENT_ID = "qiniu_upload_attachment_id";

    /**
     * 开始页
     */
    public static final int PAGE_START = 1;

    /**
     * 模糊搜索返回页大小
     */
    public static final int PAGE_SIZE_LIKE = 10;

    /**
     * 3页大小
     */
    public static final int PAGE_SIZE_3 = 3;

    /**
     * 2页大小
     */
    public static final int PAGE_SIZE_2 = 2;

    /**
     * 默认短讯大小
     */
    public static final int PAGE_SIZE_DEFAULT_3 = 3;

    /**
     * 默认附件列表大小
     */
    public static final int PAGE_SIZE_DEFAULT_8 = 8;

    /**
     * 队列开始
     */
    public static final String QUEUE_START = "1";

    /**
     * 某某某
     */
    public static final String ANONYMOUS = "某某某";

    /**
     * 我
     */
    public static final String ME = "我";

    /**
     * 默认附件页历史大小
     */
    public static final int PAGE_SIZE_DEFAULT_HISTORY_8 = 8;

    /**
     * 模糊查询大小
     */
    public static final int LIKE_PAGE_SIZE = 10;

    /**
     * png
     */
    public static final String imagepng = "image/png";

    public static final String png = "png";

    /**
     * jpeg
     */
    public static final String imagejpeg = "image/jpeg";

    /**
     * jpg
     */
    public static final String jpg = "jpg";

    /**
     * jpg
     */
    public static final String imagejpg = "image/jpg";

    /**
     * gson对象
     */
    public static final Gson GSON = new Gson();

    /**
     * 顶级菜单
     */
    public static final String TOP_MENU_NAME = "顶级菜单";

    /**
     * 逗号
     */
    public static final String SEMICOLON = ",";

    /**
     * 短信发送token
     */
    public static final String TOKEN = "713C67C3B1D3C333FB352B40D7313185";

    /**
     * 短信通道号
     */
    public static final String PORT = "10004";

    /**
     *
     */
    public static final String PIC_URL_ROOT = "http://120.24.71.221/athena-manager/attachment/display?picUrl=/uploads/";

    public static final String PIC_ROOT = "/usr/local/apache-tomcat-8.0.36/webapps";

    /**
     * 默认密码
     */
    public static final String DEFAULT_PASSWORD = "000000";

    /**
     * 联通默认成功
     */
    public static final String LT_SUCCESS = "00000";

    public static final String XP_VIEW_ADDRESS = "xp.view.by.address.do";

    public static final String XP_VIEW = "xp.detail.get";

    public static final String GT_VIEW = "gtpage.id.get";

    public static final String GT_VIEW_ADDRESS = "gtpage.address.do";

    public static final String M_VIEW = "mpage.id.get";

    public static final String M_VIEW_ADDRESS = "mpage.address.do";

    public static final String CP_NOTE = "满40可用";

    public static final String APP_KEY = "pertcnihplod";

    public static final String APP_SECRET = "pertcnihplod98234";

    public static final String TAIL = "000001";

    /**
     * 默认昵称
     */
    public static final String DEFAULT_USER_ENAME = "nickname";

    /**
     * 默认图像地址
     */
    public static final String DEFAULT_IMAGE_URL = "http://chuantu.xyz/t6/702/1562136776x1954578459.jpg";

    /**
     * 二维码宽度
     */
    public static final int QR_WIDTH = 350;

    /**
     * 二维码高度
     */
    public static final int QR_HEIGHT = 350;

    /**
     * 二维码地址
     */
    public static final String QR_ROOT_PATH = "/home/services/qrcode/";
}
