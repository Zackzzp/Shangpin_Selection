package com.zack.manager.mapper;

import com.zack.model.enity.product.ProductDetails;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDetailsMapper {
    public abstract void save(ProductDetails productDetails);
}
