package com.zack.manager.mapper;

import com.zack.model.enity.product.Brand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BrandMapper {
    public abstract List<Brand> findByPage();

    public abstract void save(Brand brand);

    public abstract void updateById(Brand brand);

    public abstract void deleteById(Long id);
}
