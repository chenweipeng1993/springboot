package com.peng.springboot.springbootdemo.exception;

import com.peng.springboot.springbootdemo.enums.ResultEnum;

public class GirlException extends RuntimeException {
    private Integer code;

    /*public GirlException( Integer code , String message){
        super(message);
        this.code = code;
    }*/
    public GirlException(ResultEnum re){
        super(re.getMsg());
        this.code = re.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
