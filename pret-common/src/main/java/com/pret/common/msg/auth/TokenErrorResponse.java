package com.pret.common.msg.auth;


import com.pret.common.constant.RestCodeConstants;
import com.pret.common.msg.BaseResponse;

/**
 *
 */
public class TokenErrorResponse extends BaseResponse {
    public TokenErrorResponse(String message) {
        super(RestCodeConstants.TOKEN_ERROR_CODE, message);
    }
}
