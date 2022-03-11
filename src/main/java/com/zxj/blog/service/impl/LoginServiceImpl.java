package com.zxj.blog.service.impl;

import com.zxj.blog.constant.ExceptionEnum;
import com.zxj.blog.dao.UserMapper;
import com.zxj.blog.dto.LoginDTO;
import com.zxj.blog.exception.BaseException;
import com.zxj.blog.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public String login(LoginDTO loginDTO) {
        userMapper.select(loginDTO.getUserName());
        if (false){
            throw new BaseException(ExceptionEnum.PARAMETER_ERROR.getCode(),ExceptionEnum.PARAMETER_ERROR.getMessage());
        }
        return null;
    }
}
