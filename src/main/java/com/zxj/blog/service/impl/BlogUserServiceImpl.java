package com.zxj.blog.service.impl;

import com.zxj.blog.dao.UserMapper;
import com.zxj.blog.entity.User;
import com.zxj.blog.service.BlogUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogUserServiceImpl implements BlogUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getSystemUser() {
        List<User> users = userMapper.selectAll();
        return users;
    }

    @Override
    public Integer addSystemUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public boolean addUser(User user) {
        Integer integer = userMapper.insertAndReturnId(user);
        return integer != null;
    }
}
