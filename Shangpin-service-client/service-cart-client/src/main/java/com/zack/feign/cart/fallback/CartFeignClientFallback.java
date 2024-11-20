package com.zack.feign.cart.fallback;

import com.zack.feign.cart.api.CartFeignClient;
import com.zack.model.enity.product.CartInfo;
import com.zack.model.vo.common.Result;
import com.zack.model.vo.common.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class CartFeignClientFallback implements CartFeignClient {

    @Override
    public Result<List<CartInfo>> getAllCkecked(Long userId) {
        log.info("CartFeignClientFallback...getAllCkecked的方法执行了");
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }
}
