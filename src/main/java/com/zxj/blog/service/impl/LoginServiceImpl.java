package com.zxj.blog.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zxj.blog.constant.ExceptionEnum;
import com.zxj.blog.dao.UserMapper;
import com.zxj.blog.dto.LoginDTO;
import com.zxj.blog.entity.User;
import com.zxj.blog.exception.BaseException;
import com.zxj.blog.service.LoginService;
import com.zxj.blog.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static com.zxj.blog.constant.RedisConstant.token_path;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public String login(LoginDTO loginDTO) {
        User user = userMapper.selectByUserName(loginDTO.getUserName());
        if (Objects.isNull(user) || !loginDTO.getPassword().equals(user.getPassword()) || user.getPassword().equals("")){
            return "登录失败";
        }
        String token = RandomUtil.getRandomString(16);
        redisTemplate.opsForValue().set(token_path + token, JSONObject.toJSONString(user),300, TimeUnit.SECONDS);
        return token;
    }
}
