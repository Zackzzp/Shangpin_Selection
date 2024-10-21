package com.zack.common.exception;

import com.zack.model.vo.common.ResultCodeEnum;
import lombok.Data;

@Data
public class ZackException extends RuntimeException{
    private Integer code;
    private String messsage;
    private ResultCodeEnum resultCode;

    public ZackException(Integer code, String messsage, ResultCodeEnum resultCode) {
        this.messsage = messsage;
        this.code = code;
        this.resultCode = resultCode;
    }
    public ZackException(Integer code, String messsage) {
        this.messsage = messsage;
        this.code = code;
    }
    public ZackException(ResultCodeEnum resultCode) {
        this.resultCode = resultCode;
    }
    
}
