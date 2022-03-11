package com.zxj.blog.entity;

import lombok.Data;

import java.util.Date;

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
    private Integer type;

    /**
     * 
     */
    private Date updatetime;

    /**
     * 
     */
    private String username;
}