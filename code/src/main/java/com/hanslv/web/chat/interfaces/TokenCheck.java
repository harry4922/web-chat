package com.hanslv.web.chat.interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/6 10:40
 * @description Token校验注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TokenCheck {
}
