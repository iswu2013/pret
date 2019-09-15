package com.pret.api.filter.impl;

import com.pret.api.info.UserInfo;
import com.pret.api.session.ClothingSession;
import com.pret.api.vo.ReqBody;
import com.pret.api.feign.IUserService;
import com.pret.api.filter.BaseContext;
import com.pret.api.filter.JopFilter;
import com.pret.api.filter.JopFilterChain;
import com.pret.api.info.EnvInfo;
import com.pret.api.session.UserContext;
import com.pret.common.constant.BEEnum;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.constant.Constants;
import com.pret.common.exception.BusinessException;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.common.util.MapToBeanUtil;
import com.google.gson.Gson;
import feign.Feign;
import feign.Request;
import feign.Retryer;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * 访问过滤器，生成requestBody
 *
 * @author wujinsong
 */
@Service
public class AccessFormatFilter extends BaseContext implements JopFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccessFormatFilter.class);
    private static final String TAG = "AccessFormatFilter";
    private static final String DEFAULT_ENCODING = "UTF-8";// 编码

    private static final Gson gson = new Gson();
    // 不需要登录的接口
    protected IUserService userService;
    @Autowired
    private BaseContext baseContext;
    @Autowired
    private LoadBalancerClient loadBalancer;

    @Override
    public synchronized void doFilter(ReqBody requestBody, HttpServletRequest httpServletRequest,
                                      JopFilterChain jopFilterChain) {
        this.userService = Feign.builder().encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .options(new Request.Options(10000, 35000))
                .retryer(new Retryer.Default(5000, 50000, 3))
                .target(IUserService.class, loadBalancer.choose("pert-open").getUri().toString());

            Map<String, String[]> paramtersOld = httpServletRequest.getParameterMap();
            Map<String, String[]> paramters = new HashMap<String, String[]>();
            for (String key : paramtersOld.keySet()) {
                String[] param = paramtersOld.get(key);
                if (param[0].length() > 0) {
                    // vallidateXss(param);
                    paramters.put(key, param);
                }
            }
            String bodyStr = "";
            try {
                bodyStr = this.getRequestBodyJson(httpServletRequest.getInputStream()).trim();

            } catch (IOException e) {
                e.printStackTrace();
            }

            if (StringUtils.isEmpty(requestBody.getV())) {
                throw new BusinessException(Constants.BUSI_ERROR_000006, Constants.S_BUSI_ERROR_000006);
            }
            Class<? extends ReqBody> clazz = requestBody.getReqBody();
            if (null == clazz) {
                throw new BusinessException(Constants.BUSI_ERROR_000007, Constants.S_BUSI_ERROR_000007);
            }

            // 参数map转化为bean

            ReqBody newBody = (ReqBody) MapToBeanUtil.convertMap(clazz, paramters);
            if (!requestBody.isIgnoreBody()) {
                if (!StringUtils.isEmpty(bodyStr)) {
                    ReqBody reqBody = gson.fromJson(bodyStr.trim(), clazz);
                    BeanUtilsExtended.copyProperties(newBody, reqBody);
                }
            }

            String token = httpServletRequest.getHeader("token");
            newBody.setToken(token);
            newBody.setSessionId(httpServletRequest.getSession().getId());
            newBody.setHandler(requestBody.getHandler());
            newBody.setReqBody(requestBody.getReqBody());
            UserInfo user = null;
            if (!StringUtils.isEmpty(token)) {
                UserInfo userInfo = new UserInfo();
                userInfo.setUtoken(token);
                user = userService.findByToken(userInfo);
                if(user != null && user.getStatus() != ConstantEnum.EUserStatus.正常.getValue()) {
                    throw new BusinessException(BEEnum.E90000011.name(), BEEnum.E90000011.getMsg(newBody.getLang()));
                }
            }

            // 加入线程属性
            EnvInfo envInfo = new EnvInfo();
            //envInfo.setUserInfo(user);
            envInfo.setLang(newBody.getLang());
            newBody.setUserInfo(user);
            UserContext.set(envInfo);
            if (!requestBody.isIgnoreToken()) {
                if (StringUtils.isEmpty(token)) {
                    throw new BusinessException(Constants.BUSI_ERROR_000011, Constants.S_BUSI_ERROR_000011);
                }
                if (user == null) {
                    throw new BusinessException(Constants.BUSI_ERROR_000011, Constants.S_BUSI_ERROR_000011);
                }
            }
            ClothingSession.put("requestBody", newBody);
            LOGGER.debug("转换请求的实体：" + (null != clazz ? clazz.getName() : "null"));
    }

    /**
     * @param inputStream
     * @return
     * @throws IOException
     */
    private String getRequestBodyJson(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            throw new BusinessException(Constants.SYSTEM_ERROR, Constants.S_SYSTEM_ERROR);
        }
        // 字节数组
        byte[] bcache = new byte[2048];
        // 每次读取的字节长度
        int readSize = 0;
        ByteArrayOutputStream infoStream = new ByteArrayOutputStream();
        try {
            // 一次性读取2048字节
            while ((readSize = inputStream.read(bcache)) > 0) {
                infoStream.write(bcache, 0, readSize);
            }
        } catch (IOException e1) {
            throw new BusinessException(Constants.SYSTEM_ERROR, Constants.S_SYSTEM_ERROR);
        } finally {
            try {
                // 输入流关闭
                inputStream.close();
            } catch (IOException e) {
                throw new BusinessException(Constants.SYSTEM_ERROR, Constants.S_SYSTEM_ERROR);
            }
        }

        try {
            return infoStream.toString(DEFAULT_ENCODING);
        } catch (UnsupportedEncodingException e) {
            throw new BusinessException(Constants.SYSTEM_ERROR, Constants.S_SYSTEM_ERROR);
        }
    }

    class ViewIdMethod {
        private String method;

        private String viewId;

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public String getViewId() {
            return viewId;
        }

        public void setViewId(String viewId) {
            this.viewId = viewId;
        }
    }
}
