package com.atguigu.springcloud.alibaba.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

public class CustomerHander {

    public static CommonResult dffddfdfdf(BlockException excption){
        return new CommonResult(444, "系统崩溃.......服务不可用");
    }
}
