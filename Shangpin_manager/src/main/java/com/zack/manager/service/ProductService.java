package com.zack.manager.service;

import com.github.pagehelper.PageInfo;
import com.zack.model.dto.product.ProductDto;
import com.zack.model.enity.product.Product;

public interface ProductService {

    public abstract PageInfo<Product> findByPage(Integer page, Integer limit, ProductDto productDto);

    public abstract void save(Product product);

    public abstract Product getById(Long id);

    public abstract void updateById(Product product);

    public abstract void deleteById(Long id);

    public abstract void updateAuditStatus(Long id,Integer auditStatus);

    public abstract void updateStatus(Long id,Integer status);
}
