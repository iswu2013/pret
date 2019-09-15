package com.pret.common.exception.auth;


import com.pret.common.constant.CommonConstants;
import com.pret.common.exception.BaseException;

/**
 *
 */
public class UserInvalidException extends BaseException {
    public UserInvalidException(String message) {
        super(message, CommonConstants.EX_USER_INVALID_CODE);
    }
}
