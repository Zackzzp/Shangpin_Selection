package com.zack.manager.service;

import com.github.pagehelper.PageInfo;
import com.zack.model.dto.product.ProductDto;
import com.zack.model.enity.product.Product;

public interface ProductService {

    public abstract PageInfo<Product> findByPage(Integer page, Integer limit, ProductDto productDto);

    public abstract void save(Product product);
}
