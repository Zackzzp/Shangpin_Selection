package com.zack.service.product.mapper;

import com.zack.model.enity.product.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {

    Product getById(Long id);
}
