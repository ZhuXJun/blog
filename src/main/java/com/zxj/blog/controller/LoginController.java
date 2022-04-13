package com.zxj.blog.controller;

import com.zxj.blog.dto.LoginDTO;
import com.zxj.blog.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/test/login")
    public String login(@RequestBody LoginDTO loginDTO){
        return loginService.login(loginDTO);
    }

}
