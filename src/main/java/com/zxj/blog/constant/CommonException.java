package com.zxj.blog.constant;

import lombok.Getter;

public enum CommonException {
    TOKEN_NOT_EXIST("000000","Token不存在"),
    LOING_ILLEGAL("000001","登录失效");

    private String code;
    private String message;

    CommonException(String code , String message){
        this.code = code;
        this.message = message;
    }

    public String getCode(){
        return code;
    }

    public String getMessage(){
        return message;
    }

}
