package com.zxj.blog.constant;

public enum ExceptionEnum {
    PARAMETER_ERROR("000000","参数异常")
    ;

    private String code;
    private String message;

    public String getCode(){
        return code;
    }

    public String getMessage(){
        return message;
    }

    ExceptionEnum(String code, String message){
        this.code = code;
        this.message = message;
    }
}
