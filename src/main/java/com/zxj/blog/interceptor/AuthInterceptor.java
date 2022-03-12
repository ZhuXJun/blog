package com.zxj.blog.interceptor;

import com.alibaba.fastjson.JSON;
import com.zxj.blog.Token;
import com.zxj.blog.entity.User;
import com.zxj.blog.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

import static com.zxj.blog.constant.CommonException.LOING_ILLEGAL;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        if (!StringUtils.isEmpty(queryString)) {
            queryString = URLDecoder.decode(queryString, StandardCharsets.UTF_8.name());
            uri = uri + "?" + queryString;
        }
        String body = StreamUtils.copyToString(request.getInputStream(), StandardCharsets.UTF_8);
        log.info("接收到请求：" + uri + "，body：" + body);
        Method method = ((HandlerMethod) handler).getMethod();
        Token tokenAuth = method.getAnnotation(Token.class);
        if (tokenAuth != null){
            String token = request.getHeader("token");
            String result= (String) redisTemplate.opsForValue().get(token);
            if (StringUtils.isEmpty(result)){
                throw new BaseException("1","");
            }
            User user = JSON.parseObject(result, User.class);
            redisTemplate.opsForValue().set(token,user,30, TimeUnit.MINUTES);
        }
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

    }
}
