package com.zack.manager.service;

import com.zack.model.dto.order.OrderStatisticsDto;
import com.zack.model.vo.order.OrderStatisticsVo;

public interface OrderInfoService {
    public abstract OrderStatisticsVo getOrderStatisticsData(OrderStatisticsDto orderStatisticsDto);
}
