package com.example.redisexample.controller;

import com.example.redisexample.common.Result;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mirau on 2022/4/23.
 * @version 1.0
 */
@RestController
@RequestMapping("demo")
public class HelloController {

    @GetMapping("hello")
    public Result<String> hello() {
        return Result.ok();
    }

}
