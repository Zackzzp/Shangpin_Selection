package com.zack.model.vo.common;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {
    SUCCESS(200,"操作成功"),
    LOGIN_ERROR(201,"用户名或密码错误"),
    SYSTEM_ERROR(500,"系统异常"),
    VALIDATECODE_ERROR(202 , "验证码错误"),
    LOGIN_AUTH(208,"用户未登录"),
    NODE_ERROR(400,"存在子节点，不允许删除"),
    DATA_ERROR(401,"数据异常"),
    USER_NAME_IS_EXISTS(200,"用户名已存在"),
    ACCOUNT_STOP(216,"账号已停用"),
    STOCK_LESS(219,"库存不足");
    private Integer code;
    private String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }



}
