package com.zxj.blog.controller;

import com.zxj.blog.annotation.SaveLog;
import com.zxj.blog.annotation.Token;
import com.zxj.blog.dto.ResultDto;
import com.zxj.blog.entity.User;
import com.zxj.blog.service.BlogUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class BlogUserController {

    @Autowired
    private BlogUserService blogUserService;

    @GetMapping("/getSystemUser")
    // @Token
    // @SaveLog
    public ResultDto<List<User>> getSystemUser(){
        return ResultDto.succ(blogUserService.getSystemUser());
    }

    @PostMapping("/addSystemUser")
    @Token
    public ResultDto<Integer> addSystemUser(@RequestBody User user){
        return ResultDto.succ(blogUserService.addSystemUser(user));
    }

    /**
     * @PostMapping:增数据
     * @PutMapping:改数据
     * @DeleteMapping:删除
     * @GETMapping:查
     */
    @PostMapping("/addUser")
    @Token
    public ResultDto<Boolean> addUser(@RequestBody User user){
        if (blogUserService.addUser(user)){
            return ResultDto.succ(true);
        }else {
            return ResultDto.fail(false);
        }
    }

    
}
