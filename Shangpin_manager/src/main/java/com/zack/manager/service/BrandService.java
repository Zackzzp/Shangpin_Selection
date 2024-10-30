package com.zack.manager.service;

import com.github.pagehelper.PageInfo;
import com.zack.model.enity.product.Brand;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface BrandService {
    /**
     * 按页查询
     * @param page
     * @param limit
     * @return
     */
    public abstract PageInfo<Brand> findByPage(Integer page, Integer limit);

    /**
     * 添加品牌
     * @param brand
     */
    public abstract void save(Brand brand);

    /**
     * 修改品牌
     * @param brand
     */
    public abstract void updateById(Brand brand);

    /**
     * 删除品牌
     * @param id
     */
    public abstract void deleteById(Long id);
}
