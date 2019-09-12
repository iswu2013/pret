package com.pret.common.exception.auth;


import com.pret.common.exception.BaseException;
import com.pret.common.constant.CommonConstants;

/**
 *
 */
public class ClientInvalidException extends BaseException {
    public ClientInvalidException(String message) {
        super(message, CommonConstants.EX_CLIENT_INVALID_CODE);
    }
}
