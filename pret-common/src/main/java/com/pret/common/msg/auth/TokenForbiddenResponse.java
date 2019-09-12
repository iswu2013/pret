package com.pret.common.msg.auth;

import com.pret.common.constant.RestCodeConstants;
import com.pret.common.msg.BaseResponse;

/**
 *
 */
public class TokenForbiddenResponse extends BaseResponse {
    public TokenForbiddenResponse(String message) {
        super(RestCodeConstants.TOKEN_FORBIDDEN_CODE, message);
    }
}
