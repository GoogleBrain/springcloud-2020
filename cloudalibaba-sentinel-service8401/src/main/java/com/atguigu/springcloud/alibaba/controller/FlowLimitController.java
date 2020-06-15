package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.alibaba.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
@Slf4j
public class FlowLimitController
{
    @Autowired
    private OrderService orderService;

    @GetMapping("/testA")
    public String testA() {
        orderService.aa();
        int a=10/0;
        log.info(">>>>>"+Thread.currentThread().getName()+","+new Date());
        return "------testA>>>>"+new Date();
    }

    @GetMapping("/testB")
    public String testB() {

        return "------testB"+new Date();
    }

    @RequestMapping("/testC")
    @SentinelResource(value = "testC",blockHandler = "kkkk")
    public String testC(@RequestParam(value = "p1",required = false)String p1,
                        @RequestParam(value = "p2",required = false)String p2){
        return "-------------test CCCC"+new Date();
    }

    public String kkkk(String a, String b, BlockException ex){
        return "ku le .";
    }
}
 