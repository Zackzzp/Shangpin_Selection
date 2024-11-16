package com.zack.service.product.service.impl;

import com.zack.model.enity.product.ProductSku;
import com.zack.service.product.mapper.ProductSkuMapper;
import com.zack.service.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductSkuMapper productSkuMapper;

    @Override
    public List<ProductSku> findProductSkuBySale() {
        return productSkuMapper.findProductSkuBySale();
    }
}
