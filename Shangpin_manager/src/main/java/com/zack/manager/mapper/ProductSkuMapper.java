package com.zack.manager.mapper;

import com.zack.model.enity.product.ProductSku;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductSkuMapper {
    public abstract void save(ProductSku productSku);
}
