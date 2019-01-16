package com.hqw.demo.exception;

import com.hqw.demo.dao.result.Result;
import com.hqw.demo.dao.result.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandl {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandl.class);

    @ExceptionHandler(value = Exception.class)
    public Result handler(Exception e){
        if(e instanceof DqException){
            DqException dqException = (DqException) e;
            return ResultUtils.failedresult(dqException.getMessage(),dqException.getCode());
        }else{
            logger.info("系统错误",e);
            return ResultUtils.failedresult("未知错误",-1);
        }
    }
}

