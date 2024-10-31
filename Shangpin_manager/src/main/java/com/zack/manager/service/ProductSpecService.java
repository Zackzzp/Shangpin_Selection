package com.zack.manager.service;

import com.github.pagehelper.PageInfo;
import com.zack.model.enity.product.ProductSpec;

import java.util.List;

public interface ProductSpecService {
    /**
     * 按页查询
     * @param page
     * @param limit
     * @return
     */
    public abstract PageInfo<ProductSpec> findByPage(Integer page, Integer limit);

    /**
     * 添加产品规格
     * @param productSpec
     */
    public abstract void save(ProductSpec productSpec);

    /**
     * 修改产品规格
     * @param productSpec
     */
    public abstract void updateById(ProductSpec productSpec);

    /**
     * 删除品牌规格
     * @param id
     */
    public abstract void deleteById(Long id);

    /**
     * 查找所有品牌
     * @return
     */
    public abstract List<ProductSpec> findAll();

}
