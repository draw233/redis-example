package com.example.redisexample.controller;

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
        return Result.RESULT_SUCCESS;
    }

    @Data
    public static class Result<T> {
        private static Result<String> RESULT_SUCCESS = new Result<>();

        static {
            RESULT_SUCCESS.setCode("0000");
            RESULT_SUCCESS.setMsg("success");
            RESULT_SUCCESS.setData("");
        }

        static Result<String> success() {
            return RESULT_SUCCESS;
        }

        private String msg;
        private String code;
        private T data;
    }
}
