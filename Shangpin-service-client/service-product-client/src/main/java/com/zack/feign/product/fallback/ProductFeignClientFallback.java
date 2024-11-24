package com.zack.feign.product.fallback;

import com.zack.feign.product.api.ProductFeignClient;
import com.zack.model.dto.product.SkuSaleDto;
import com.zack.model.enity.product.ProductSku;
import com.zack.model.vo.common.Result;
import com.zack.model.vo.common.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class ProductFeignClientFallback implements ProductFeignClient {

    @Override
    public Result<ProductSku> getBySkuId(Long skuId) {
        log.info("ProductFeignClientFallback...getBySkuId的方法执行了");
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }
    @Override
    public Boolean updateSkuSaleNum(List<SkuSaleDto> skuSaleDtoList) {
        log.info("ProductFeignClientFallback...updateSkuSaleNum的方法执行了");
        return false ;
    }

}
