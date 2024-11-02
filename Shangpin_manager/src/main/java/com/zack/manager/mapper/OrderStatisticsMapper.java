package com.zack.manager.mapper;

import com.zack.model.dto.order.OrderStatisticsDto;
import com.zack.model.enity.order.OrderStatistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderStatisticsMapper {
    public abstract void insert(OrderStatistics orderStatistics);

    List<OrderStatistics> selectList(OrderStatisticsDto orderStatisticsDto);
}
