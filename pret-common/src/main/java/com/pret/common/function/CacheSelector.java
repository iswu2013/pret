package com.pret.common.function;

@FunctionalInterface
public interface CacheSelector<T> {
    T select() throws Exception;
}
