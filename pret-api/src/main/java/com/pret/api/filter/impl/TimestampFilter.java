package com.pret.api.filter.impl;

import com.pret.api.filter.JopFilter;
import com.pret.api.filter.JopFilterChain;
import com.pret.api.vo.ReqBody;
import com.pret.common.constant.Constants;
import com.pret.common.exception.BusinessException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 时间误差控制
 *
 * @author wujinsong
 */
@Service
public class TimestampFilter implements JopFilter {
    @Override
    public synchronized void doFilter(ReqBody requestBody, HttpServletRequest httpServletRequest, JopFilterChain jopFilterChain) {
        // 获取传入参数
        //String timestamp = requestBody.getTimestamp();
        SimpleDateFormat sf1 = new SimpleDateFormat("yyyyMMddHHmmss");
        SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sfstr = "";
        try {
            sfstr = sf2.format(sf1.parse(requestBody.getTimestamp()));
            requestBody.setTimestamp(sfstr);
        } catch (ParseException e) {
            throw new BusinessException(Constants.SYSTEM_ERROR, Constants.S_SYSTEM_ERROR);
        }

        // 计算时间差值
		/*long d_value = System.currentTimeMillis() - Timestamp.valueOf(sfstr).getTime();
		// 判断误差是否大于 6 分钟，即 6 * 60 * 1000 毫秒
		if (Math.abs(d_value) > (6 * 60 * 1000)) {
			throw new BusinessException(Constants.BUSI_ERROR_000005, Constants.S_BUSI_ERROR_000005);
		}*/

        jopFilterChain.doFilter(requestBody, httpServletRequest);

    }
}
