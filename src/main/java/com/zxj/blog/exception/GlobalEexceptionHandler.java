package com.zxj.blog.exception;


import com.zxj.blog.dto.ResultDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@ResponseBody
public class GlobalEexceptionHandler {

    private ResultDto<String> createResult(Integer code, String message) {
        return new ResultDto<>(code, message, null);
    }

    @ExceptionHandler(BaseException.class)
    public ResultDto<String> exceptionHandler(BaseException e) {
        return createResult(ResultDto.CODE_FAIL, e.getLocalizedMessage());
    }

}
