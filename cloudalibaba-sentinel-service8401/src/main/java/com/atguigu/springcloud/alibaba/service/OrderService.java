package com.atguigu.springcloud.alibaba.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @SentinelResource("aa")
    public String aa(){
        return "aa";
    }
}
