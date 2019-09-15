package com.pret.open.gate.ratelimit.config;

import javax.servlet.http.HttpServletRequest;

/**
 *
 */
public class DefaultUserPrincipal implements IUserPrincipal {
    @Override
    public String getName(HttpServletRequest request) {
        if (request.getUserPrincipal() == null) {
            return null;
        }
        return request.getUserPrincipal().getName();
    }
}
