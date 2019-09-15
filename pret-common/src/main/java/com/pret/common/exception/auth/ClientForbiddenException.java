package com.pret.common.exception.auth;


import com.pret.common.constant.CommonConstants;
import com.pret.common.exception.BaseException;

/**
 *
 */
public class ClientForbiddenException extends BaseException {
    public ClientForbiddenException(String message) {
        super(message, CommonConstants.EX_CLIENT_FORBIDDEN_CODE);
    }

}
