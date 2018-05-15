package com.peng.springboot.springbootdemo.handler;

import com.peng.springboot.springbootdemo.domain.Result;
import com.peng.springboot.springbootdemo.exception.GirlException;
import com.peng.springboot.springbootdemo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    private static final Logger logger = LoggerFactory.getLogger(Exception.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception ex){
        if(ex instanceof GirlException){
            GirlException exception = (GirlException) ex;
            return ResultUtil.error(exception.getCode(),exception.getMessage());
        }else {
            logger.error("[系统异常]{}",ex);
            return ResultUtil.error(-1, "未知错误");
        }
    }
}
