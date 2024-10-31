package com.zack.manager.mapper;

import com.zack.model.dto.product.CategoryBrandDto;
import com.zack.model.enity.product.CategoryBrand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryBrandMapper {
    public abstract List<CategoryBrand> findByPage(CategoryBrandDto categoryBrandDto);

    public abstract void save(CategoryBrand categoryBrand);

    public abstract void updateById(CategoryBrand categoryBrand);

    public abstract void deleteById(Long id);
}
