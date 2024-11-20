package com.zack.service.product.mapper;

import com.zack.model.dto.product.ProductSkuDto;
import com.zack.model.enity.product.ProductSku;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductSkuMapper {
    List<ProductSku> findProductSkuBySale();
    List<ProductSku> findByPage(ProductSkuDto productSkuDto);
    ProductSku getById(Long id);
    List<ProductSku> findByProductId(Long productId);
}