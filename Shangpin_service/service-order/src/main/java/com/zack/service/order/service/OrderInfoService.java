package com.zack.service.order.service;

import com.github.pagehelper.PageInfo;
import com.zack.model.dto.order.OrderInfoDto;
import com.zack.model.enity.order.OrderInfo;
import com.zack.model.vo.h5.TradeVo;

public interface OrderInfoService {
    TradeVo getTrade();

    Long submitOrder(OrderInfoDto orderInfoDto);

    OrderInfo getOrderInfo(Long orderId);

    TradeVo buy(Long skuId);

    PageInfo<OrderInfo> findUserPage(Integer page, Integer limit, Integer orderStatus);

    OrderInfo getByOrderNo(String orderNo) ;
}
