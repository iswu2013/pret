package com.pret.user.common.function;

@FunctionalInterface
public interface CacheSelector<T> {
    T select() throws Exception;
}
