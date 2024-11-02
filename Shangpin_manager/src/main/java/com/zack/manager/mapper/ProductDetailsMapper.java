package com.zack.manager.mapper;

import com.zack.model.enity.product.ProductDetails;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductDetailsMapper {
    public abstract void save(ProductDetails productDetails);

    public abstract ProductDetails selectByProductId(Long id);

    public abstract void updateById(ProductDetails productDetails);

    public abstract void deleteByProductId(Long id);
}
