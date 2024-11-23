package com.zack.feign.order.api;

import com.zack.feign.order.fallback.OrderFeignClientFallback;
import com.zack.model.enity.order.OrderInfo;
import com.zack.model.vo.common.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-order" , fallback = OrderFeignClientFallback.class)
public interface OrderFeignClient {

    @GetMapping("/api/order/orderInfo/auth/getOrderInfoByOrderNo/{orderNo}")
    public Result<OrderInfo> getOrderInfoByOrderNo(@PathVariable String orderNo) ;

}
