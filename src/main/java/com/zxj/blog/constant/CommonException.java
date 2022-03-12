package com.zxj.blog.constant;

import lombok.Getter;

public enum CommonException {
    LOING_ILLEGAL(000001,"登录失效");

    private Integer code;
    private String message;

    CommonException(Integer code , String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode(){
        return code;
    }

    public String getMessage(){
        return message;
    }

}
