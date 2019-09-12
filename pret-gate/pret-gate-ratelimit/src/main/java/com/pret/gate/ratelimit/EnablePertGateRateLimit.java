package com.pret.gate.ratelimit;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(RateLimitAutoConfiguration.class)
@Documented
@Inherited
public @interface EnablePertGateRateLimit {
}
