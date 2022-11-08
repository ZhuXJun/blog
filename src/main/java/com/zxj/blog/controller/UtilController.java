package com.zxj.blog.controller;

import com.zxj.blog.dto.ResultDto;
import com.zxj.blog.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/util")
public class UtilController {

    @Autowired
    private UtilService utilService;

    @GetMapping("/read/{fileName}/{type}")
    public ResultDto<Boolean> doRead(@PathVariable("fileName") String fileName,@PathVariable("type") Integer type){
        return ResultDto.succ(utilService.doRead(fileName,type));
    }

    @GetMapping("/generate/data/{times}")
    public ResultDto<Boolean> doGenerator(@PathVariable("times")Integer times){
        return ResultDto.succ(utilService.doGenerator(times));
    }
}
