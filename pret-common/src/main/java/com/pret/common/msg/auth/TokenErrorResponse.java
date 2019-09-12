package com.pret.common.msg.auth;


import com.pret.common.msg.BaseResponse;
import com.pret.common.constant.RestCodeConstants;

/**
 *
 */
public class TokenErrorResponse extends BaseResponse {
    public TokenErrorResponse(String message) {
        super(RestCodeConstants.TOKEN_ERROR_CODE, message);
    }
}
