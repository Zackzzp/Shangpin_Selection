package com.zack.common.anno;

import com.zack.common.exception.GolbalExceptionHandler;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@Import(value = GolbalExceptionHandler.class)
public @interface EnableGlobaleExceptionHandler {
}