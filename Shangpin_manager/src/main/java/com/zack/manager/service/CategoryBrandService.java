package com.zack.manager.service;

import com.github.pagehelper.PageInfo;
import com.zack.model.dto.product.CategoryBrandDto;
import com.zack.model.enity.product.Brand;
import com.zack.model.enity.product.CategoryBrand;

import java.util.List;

public interface CategoryBrandService {

    /**
     * 按页查询
     * @param page
     * @param limit
     * @param categoryBrandDto
     * @return
     */
    public abstract PageInfo<CategoryBrand> findByPage(Integer page, Integer limit, CategoryBrandDto categoryBrandDto);

    /**
     * 添加分类品牌
     * @param categoryBrand
     */
    public abstract void save(CategoryBrand categoryBrand);

    /**
     * 修改品牌
     * @param categoryBrand
     */
    public abstract void updateById(CategoryBrand categoryBrand);

    /**
     * 删除分类品牌
     * @param id
     */
    public abstract void deleteById(Long id);

    /**
     * 查找商品品牌
     * @param categoryId
     * @return
     */
    public abstract List<Brand>findBrandByCategoryId(Long categoryId);

}
