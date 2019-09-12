package com.pret.api.filter.impl;

import com.pret.api.filter.JopFilter;
import com.pret.api.filter.JopFilterChain;
import com.pret.api.vo.ReqBody;
import com.pret.common.constant.Constants;
import com.pret.common.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * jsr303校验
 *
 * @author wujinsong
 */
@Service
public class RequestBodyJsr303Filter implements JopFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestBodyJsr303Filter.class);

    @Autowired
    private Validator validator;

    @Override
    public synchronized void doFilter(ReqBody requestBody, HttpServletRequest httpServletRequest, JopFilterChain jopFilterChain) {
        Set<ConstraintViolation<ReqBody>> constraintViolations = validator.validate(requestBody);
        if (constraintViolations.size() > 0) {
            StringBuilder message = new StringBuilder();
            for (ConstraintViolation<ReqBody> constrainViolation : constraintViolations) {
                message.append(constrainViolation.getPropertyPath().toString() + constrainViolation.getMessage() + "|");
            }
            LOGGER.warn("参数错误");
            throw new BusinessException(Constants.PARAM_ERROR, message.toString());
        }
        jopFilterChain.doFilter(requestBody, httpServletRequest);

    }
}
