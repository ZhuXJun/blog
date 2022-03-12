package com.zxj.blog.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class LogAspcet {

    @Pointcut(value = "@within(com.zxj.blog.annotation.SaveLog) || @annotation(com.zxj.blog.annotation.SaveLog)")
    public void pointCut(){

    }

    @Around("pointCut()")
    public void doSaveLog(){

    }
}
