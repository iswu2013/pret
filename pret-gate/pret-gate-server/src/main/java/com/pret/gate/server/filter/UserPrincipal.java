package com.pret.gate.server.filter;

import com.pret.gate.ratelimit.config.IUserPrincipal;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jswul
 * @title: UserPrincipal
 * @projectName pert
 * @description: TODO
 * @date 2019/6/1416:30
 */
public class UserPrincipal implements IUserPrincipal {

    @Override
    public String getName(HttpServletRequest request) {
        return null;
    }
}
