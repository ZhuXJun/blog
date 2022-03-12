package com.zxj.blog.aspect;

import com.zxj.blog.annotation.SaveLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Component
@Slf4j
@Aspect
public class LogAspcet {

    @Pointcut(value = "@within(com.zxj.blog.annotation.SaveLog) || @annotation(com.zxj.blog.annotation.SaveLog)")
    public void pointCut() {

    }

    @Around("pointCut()")
    public void doAspect(ProceedingJoinPoint point) {
        log.info("------------------------------------------------------------------");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //获取URL、IP
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        //获取请求方法
        log.info("url=========>: {}",url);
        log.info("ip=========>: {}",ip);
        //获取被代理方法参数
        Object[] args = point.getArgs();
        //获取被代理对象
        Object target = point.getTarget();
        log.info("参数： {}", args);
        log.info("target： {}", target);
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        try {
            log.info("methodSignature.getName()： {}", methodSignature.getName());
            log.info("methodSignature.getParameterTypes()： {}", methodSignature.getParameterTypes());
            Method method = target.getClass().getMethod(methodSignature.getName(),methodSignature.getParameterTypes());
            // SaveLog saveLog = method.getAnnotation(SaveLog.class);
            // if (saveLog == null){
            //     saveLog = target.getClass().getAnnotation(SaveLog.class);
            // }
            // if (saveLog != null){
            //
            // }
        } catch (Exception e) {
            log.info("切入点报错：{} ", e);
        }
    }
}
