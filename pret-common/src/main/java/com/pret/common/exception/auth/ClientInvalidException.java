package com.pret.common.exception.auth;


import com.pret.common.constant.CommonConstants;
import com.pret.common.exception.BaseException;

/**
 *
 */
public class ClientInvalidException extends BaseException {
    public ClientInvalidException(String message) {
        super(message, CommonConstants.EX_CLIENT_INVALID_CODE);
    }
}
