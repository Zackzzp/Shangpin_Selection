package com.zack.service.product.mapper;

import com.zack.model.enity.product.Brand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BrandMapper {
    public abstract List<Brand> findAll();
}
