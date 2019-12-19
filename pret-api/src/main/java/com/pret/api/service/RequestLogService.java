package com.pret.api.service;

import com.pret.api.entity.RequestLog;
import com.pret.api.repository.RequestLogRepository;
import com.pret.api.session.ClothingSession;
import com.pret.api.vo.ErrorResponseBody;
import com.pret.api.vo.ReqBody;
import com.pret.api.vo.ResBody;
import com.pret.common.constant.Constants;
import com.pret.common.exception.BusinessException;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class RequestLogService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestLogService.class);

    @Autowired
    private RequestLogRepository requestLogRepository;

    public void createRequestLog(ReqBody requestBody, String ip, String body, String url, String serialNo) {
        RequestLog requestLog = new RequestLog();
        try {
            BeanUtilsBean.getInstance().copyProperties(requestLog, requestBody);
        } catch (IllegalAccessException | InvocationTargetException e) {
            LOGGER.error("记录请求日志失败：{}", e);
            throw new BusinessException(e);
        }
        requestLog.setBody(body);
        requestLog.setUrl(url);
        requestLog.setIp(ip);
        requestLog.setSerialNo(serialNo);
        try {
            requestLog.setRequestTimestamp(requestBody.getTimestamp());
        } catch (Exception e) {
            LOGGER.error("记录日志格式化时间失败：{}", e);
            throw new BusinessException(e);
        }
        requestLogRepository.save(requestLog);
        ClothingSession.put("requestLog", requestLog);
    }

    public void updateRequestLog(ErrorResponseBody responseBody) {
        try {
            if (!StringUtils.isEmpty(responseBody.getSerialNo())) {
                RequestLog requestLog = requestLogRepository
                        .findBySerialNo(responseBody.getSerialNo());
                if (null == requestLog) {
                    LOGGER.error("日志未保存" + responseBody);
                    return;
                }
                requestLog.setResponseTimestamp(Constants.df2.format(new Date()));
            }
        } catch (Exception e) {
            LOGGER.error("更新请求日志失败：{}", e);
        }
        ClothingSession.clear();

    }

    public void updateRequestLog(ResBody responseBody) {
        try {
            if (!StringUtils.isEmpty(responseBody.getSerialNo())) {
                RequestLog requestLog = requestLogRepository.findBySerialNo(responseBody.getSerialNo());
                if (requestLog != null) {
                    requestLog.setResponseContent(responseBody.toString());
                    requestLog.setStatus(Constants.SUCCUSS_CODE);
                    requestLog.setResponseTimestamp(Constants.df2.format(new Date()));
                    requestLogRepository.save(requestLog);
                }
            }
        } catch (Exception e) {
            LOGGER.error("更新请求日志失败：{}", e);
        }
        ClothingSession.clear();

    }

    /**
     * 根据流水号和会员信息查询RequestLog
     *
     * @param serial_no 流水号
     * @param memberId  会员信息
     * @return RequestLog
     */
    public long countBySerialNoAndMemberId(final String serial_no, final Long memberId) {
        return requestLogRepository.count(new Specification<RequestLog>() {
            @Override
            public Predicate toPredicate(Root<RequestLog> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate predicate = cb.conjunction();

                List<Expression<Boolean>> expressions = predicate.getExpressions();
                // 流水号
                expressions.add(cb.equal(root.<String>get("serial_no"), serial_no));
                // 会员信息
                expressions.add(cb.equal(root.<Long>get("memberId"), memberId));

                return predicate;
            }
        });
    }
}
