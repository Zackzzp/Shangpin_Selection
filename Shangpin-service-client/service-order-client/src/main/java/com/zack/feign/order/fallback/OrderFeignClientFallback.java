package com.zack.feign.order.fallback;

import com.zack.feign.order.api.OrderFeignClient;
import com.zack.model.enity.order.OrderInfo;
import com.zack.model.vo.common.Result;
import com.zack.model.vo.common.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderFeignClientFallback implements OrderFeignClient {

    @Override
    public Result<OrderInfo> getOrderInfoByOrderNo(String orderNo) {
        log.info("OrderFeignClientFallback...getOrderInfoByOrderNo方法执行了");
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

}
