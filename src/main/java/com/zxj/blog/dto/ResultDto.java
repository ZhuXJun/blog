package com.zxj.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDto<T> {
    public static final Integer CODE_SUCC = 0;
    public static final Integer CODE_FAIL = -1;

    private Integer code;
    private String message;
    private T data;

    public static <T> ResultDto<T> succ (T data){
        return new ResultDto<>(CODE_SUCC,"操作成功",data);
    }

    public static <T> ResultDto<T> succ(T data,String message){
        return new ResultDto<>(CODE_SUCC,message,data);
    }

    public static <T> ResultDto<T> fail (T data){
        return new ResultDto<>(CODE_FAIL,"操作失败",data);
    }

    public static <T> ResultDto<T> fail(T data,String message){
        return new ResultDto<>(CODE_FAIL,message,data);
    }
}
