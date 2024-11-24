package com.zack.feign.product.api;

import com.zack.feign.product.fallback.ProductFeignClientFallback;
import com.zack.model.dto.product.SkuSaleDto;
import com.zack.model.enity.product.ProductSku;
import com.zack.model.vo.common.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "service-product" , fallback = ProductFeignClientFallback.class)
public interface ProductFeignClient {

    @GetMapping("/api/product/getBySkuId/{skuId}")
    public abstract Result<ProductSku>  getBySkuId(@PathVariable Long skuId) ;

    @PostMapping("/api/product/updateSkuSaleNum")
    Boolean updateSkuSaleNum(@RequestBody List<SkuSaleDto> skuSaleDtoList);

}
