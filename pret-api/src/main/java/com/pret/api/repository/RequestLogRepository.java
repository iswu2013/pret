package com.pret.api.repository;

import com.pret.api.entity.RequestLog;
import com.pret.common.repository.BaseRepository;


/**
 * 请求日志
 *
 * @author wujinsong
 */
public interface RequestLogRepository extends BaseRepository<RequestLog> {
    RequestLog findBySerialNo(String serialNo);
}
