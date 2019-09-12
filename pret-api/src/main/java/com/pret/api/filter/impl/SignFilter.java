package com.pret.api.filter.impl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pret.api.filter.JopFilter;
import com.pret.api.filter.JopFilterChain;
import com.pret.api.vo.ReqBody;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.constant.Constants;
import com.pret.common.exception.BusinessException;
import com.pret.common.util.CommonUtil;
import com.pret.common.util.MapUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


@Service
public class SignFilter implements JopFilter {
    @Override
    public synchronized void doFilter(ReqBody requestBody, HttpServletRequest httpServletRequest, JopFilterChain appFilterChain) {
        try {
            if(requestBody.getClientType() != ConstantEnum.EClientType.Web.getValue()) {
                if (StringUtils.isEmpty(requestBody.getEnv()) || !requestBody.getEnv().equals("test")) {
                    Map<String, Object> paramters = MapUtil.changeGetParameterMap(httpServletRequest);
                    String sign = CommonUtil.getSequenceString(paramters, Constants.APP_KEY, Constants.APP_SECRET);
                    if (!requestBody.getSign().equals(sign)) {
                        String key = Constants.BUSI_ERROR_000010;
                        throw new BusinessException(key, Constants.S_BUSI_ERROR_000010);
                    }
                }
            }
        } catch (Exception e) {
            throw e;
        }
        appFilterChain.doFilter(requestBody, httpServletRequest);
    }
}
