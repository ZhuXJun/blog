package com.zxj.blog.service;

import com.zxj.blog.entity.User;

import java.util.List;

public interface BlogUserService {
    List<User> getSystemUser();

    Integer addSystemUser(User user);

    boolean addUser(User user);
}
