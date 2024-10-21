package com.zack.model.vo.common;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {
    SUCCESS(200,"操作成功"),
    LOGIN_ERROR(201,"用户名或密码错误"),
    SYSTEM_ERROR(500,"系统异常"),
    VALIDATECODE_ERROR(202 , "验证码错误");
    private Integer code;
    private String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }



}
