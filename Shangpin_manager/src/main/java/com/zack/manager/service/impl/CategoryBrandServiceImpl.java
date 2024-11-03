package com.zack.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zack.common.log.annotion.Log;
import com.zack.manager.mapper.CategoryBrandMapper;
import com.zack.manager.service.CategoryBrandService;
import com.zack.model.dto.product.CategoryBrandDto;
import com.zack.model.enity.product.Brand;
import com.zack.model.enity.product.CategoryBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryBrandServiceImpl implements CategoryBrandService {
    @Autowired
    CategoryBrandMapper categoryBrandMapper;

    @Override
    public PageInfo<CategoryBrand> findByPage(Integer page, Integer limit, CategoryBrandDto categoryBrandDto) {
        PageHelper.startPage(page, limit);
        List<CategoryBrand> categoryBrandList = categoryBrandMapper.findByPage(categoryBrandDto);
        return new PageInfo<>(categoryBrandList);
    }

    @Log(title = "分类品牌模块", businessType = 1)
    @Override
    public void save(CategoryBrand categoryBrand) {
        categoryBrandMapper.save(categoryBrand);
    }

    @Log(title = "分类品牌模块", businessType = 2)
    @Override
    public void updateById(CategoryBrand categoryBrand) {
        categoryBrandMapper.updateById(categoryBrand);
    }
    @Log(title = "分类品牌模块", businessType = 3)
    @Override
    public void deleteById(Long id) {
        categoryBrandMapper.deleteById(id);
    }

    @Override
    public List<Brand> findBrandByCategoryId(Long categoryId) {
        return List.of();
    }
}
