package com.zack.cloud.order.service.Impl;

import com.zack.cloud.order.entity.Order;
import com.zack.cloud.order.mapper.OrderMapper;
import com.zack.cloud.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper ;

    @Override
    public Order findOrderByOrderId(Long orderId) {
        return orderMapper.findOrderByOrderId(orderId);
    }

}
