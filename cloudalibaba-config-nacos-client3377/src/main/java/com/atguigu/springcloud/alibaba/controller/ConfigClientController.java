package com.atguigu.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RefreshScope
public class ConfigClientController
{
    @Value("${user.name}")
    String userName;

    @Value("${user.age}")
    int age;

    @GetMapping("/config/info")
    public String getConfigInfo() {
        return userName+age;
    }
}
 