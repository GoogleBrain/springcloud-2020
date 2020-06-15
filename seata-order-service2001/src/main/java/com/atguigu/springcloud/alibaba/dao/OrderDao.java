package com.atguigu.springcloud.alibaba.dao;
 
import com.atguigu.springcloud.alibaba.domain.Order;
import feign.Param;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface OrderDao
{
   //新建订单
   void create(Order order);
 
   //修改订单状态，从零改为1
   void update(Long userId,Integer status);
}
 