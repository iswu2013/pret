package com.pret.api.entity;

import com.pret.common.VersionedAuditableIdEntity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 请求日志
 *
 * @author wujinsong
 */
@Entity
@Table(name = "pret_request_log")
@Data()
public class RequestLog extends VersionedAuditableIdEntity {

    /**
     *
     */
    private static final long serialVersionUID = 5629923312616708235L;

    private String ip;// 客户端IP

    private String method;// API接口名称

    private String requestTimestamp;// 时间戳，格式为yyyy-MM-dd HH:mm:ss，例如：2013-05-06
    // 13:52:03。API服务端允许客户端请求时间误差为6分钟。

    private String format = "json";// 可选，指定响应格式。默认json,目前支持格式json

    private String appKey;// JOP分配给应用的AppKey ，创建应用时可获得

    private String v;// API协议版本，可选值:1.0。

    private String status;// 状态 (000000:正常)

    private String memo;// 备注

    private String responseTimestamp;// 响应时间，格式为yyyy-MM-dd HH:mm:ss

    private String serialNo; // 流水号

    private String body;

    private String url;

    private String responseContent;

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid") //这个是hibernate的注解/生成32位UUID
    @GeneratedValue(generator = "idGenerator")
    @Override
    public String getId() {
        return id;
    }
}
