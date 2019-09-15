package com.pret.open.gate.ratelimit.config;

import javax.servlet.http.HttpServletRequest;

/**
 *
 */
public interface IUserPrincipal {
    String getName(HttpServletRequest request);
}
