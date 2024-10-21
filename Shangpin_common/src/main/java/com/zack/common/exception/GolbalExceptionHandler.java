package com.zack.common.exception;

import com.zack.model.vo.common.Result;
import com.zack.model.vo.common.ResultCodeEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GolbalExceptionHandler {
    //处理自定义异常
    @ExceptionHandler(value = ZackException.class)
    public Result zackExceptionHandler(ZackException exception) {
        exception.printStackTrace();
        return Result.build(null,exception.getResultCode());

    }
    //处理系统异常
    @ExceptionHandler(value = ZackException.class)
    public Result systemExceptionHandler(ZackException exception) {
        exception.printStackTrace();
        return Result.build(null, ResultCodeEnum.SYSTEM_ERROR);
    }

}
