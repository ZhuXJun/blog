package com.zxj.blog.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Data
public class User {
    /**
     *
     */
    private Long id;

    /**
     *
     */
    private String avatar;

    /**
     *
     */
    private Date createtime;

    /**
     *
     */
    private String email;

    /**
     *
     */
    private String nickname;

    /**
     *
     */
    private String password;

    /**
     *
     */
    private Integer role;

    /**
     *
     */
    private Date updatetime;

    /**
     *
     */
    private String username;

    public List<User> getUserList(int amount){
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= amount; i++) {
            User user = new User();
            user.setId(new Random().nextLong()*99+1);
            user.setUsername("朱相俊-" + new Random().nextInt()*99 + 1);
            user.setNickname("朱相俊测试ES-01");
            user.setAvatar("不知道是什么意思了");
            user.setEmail("xiangjun_mail@163.com");
            user.setRole(1);
            user.setPassword("1234qwer");
            user.setCreatetime(new Date());
            user.setUpdatetime(new Date());
            users.add(user);
        }
        return users;
    }
}