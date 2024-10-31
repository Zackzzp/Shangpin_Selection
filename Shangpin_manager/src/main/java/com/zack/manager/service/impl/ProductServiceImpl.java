package com.zack.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zack.manager.mapper.ProductMapper;
import com.zack.manager.service.ProductService;
import com.zack.model.dto.product.ProductDto;
import com.zack.model.enity.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public PageInfo<Product> findByPage(Integer page, Integer limit,ProductDto productDto) {
        PageHelper.startPage(page, limit);
        List<Product> productList=productMapper.findByPage(productDto);
        return new PageInfo<>(productList);
    }

}
