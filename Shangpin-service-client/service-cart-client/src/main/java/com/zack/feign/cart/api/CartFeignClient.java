package com.zack.feign.cart.api;

import com.zack.feign.cart.fallback.CartFeignClientFallback;
import com.zack.model.enity.product.CartInfo;
import com.zack.model.vo.common.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@FeignClient(value = "service-cart" , fallback = CartFeignClientFallback.class)
public interface CartFeignClient {

    @GetMapping(value = "/api/order/cart/auth/getAllCkecked")
    public abstract Result<List<CartInfo>> getAllCkecked(Long userId) ;

}

