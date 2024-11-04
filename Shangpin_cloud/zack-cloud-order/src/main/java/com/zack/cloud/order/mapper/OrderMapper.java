package com.zack.cloud.order.mapper;

import com.zack.cloud.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    // 根据订单的id查询订单数据
    public abstract Order findOrderByOrderId(Long orderId) ;
}
