package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;

import com.atguigu.springcloud.alibaba.handler.CustomerHander;
import com.atguigu.springcloud.entities.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RateLimitController {
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名称限流测试OK", new Payment(2020L, "serial001"));
    }

    public CommonResult handleException(BlockException exception) {
        return new CommonResult(444, exception.getClass().getCanonicalName() + "\t 服务不可用");
    }

    @GetMapping("/testD")
    @SentinelResource(value = "testD",blockHandlerClass = CustomerHander.class,blockHandler = "dffddfdfdf")
    public CommonResult handleException(){
        return new CommonResult(200, "TestDDDDDDDDDDDD", new Payment(2020L, "serial001"));
    }
}