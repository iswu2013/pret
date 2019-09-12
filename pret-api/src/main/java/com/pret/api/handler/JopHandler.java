package com.pret.api.handler;

import com.pret.api.vo.ReqBody;
import com.pret.api.vo.ResBody;

/**
 * 接口处理
 */
public interface JopHandler {

    /* 处理接口请求 */
    ResBody handle(ReqBody requestBody);
}
