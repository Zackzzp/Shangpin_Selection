package com.zack.manager.mapper;

import com.zack.model.dto.product.ProductDto;
import com.zack.model.enity.product.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
   public abstract List<Product> findByPage(ProductDto productDto);
}
