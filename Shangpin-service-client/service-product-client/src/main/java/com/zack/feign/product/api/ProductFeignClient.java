package com.zack.feign.product.api;

import com.zack.feign.product.fallback.ProductFeignClientFallback;
import com.zack.model.enity.product.ProductSku;
import com.zack.model.vo.common.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-product" , fallback = ProductFeignClientFallback.class)
public interface ProductFeignClient {

    @GetMapping("/api/product/getBySkuId/{skuId}")
    public abstract Result<ProductSku>  getBySkuId(@PathVariable Long skuId) ;

}
