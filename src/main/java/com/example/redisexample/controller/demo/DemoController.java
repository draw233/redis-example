package com.example.redisexample.controller.demo;

import com.example.redisexample.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author mirau on 2022/5/6.
 * @version 1.0
 */
@RestController
@RequestMapping("demo")
@Api(tags = "demo接口")
public class DemoController {

    @ApiOperation("测试 api1")
    @GetMapping("api1")
    public Result<String> api1(String id) {
        return Result.ok("api ok");
    }

    @ApiOperation("测试 api2")
    @PostMapping("api2")
    public Result<String> api2(@RequestBody String id) {
        return Result.ok("api ok");
    }
}
