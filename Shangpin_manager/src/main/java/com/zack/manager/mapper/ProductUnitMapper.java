package com.zack.manager.mapper;

import com.zack.model.enity.product.ProductUnit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductUnitMapper {
    public abstract List<ProductUnit> findAll();
}
