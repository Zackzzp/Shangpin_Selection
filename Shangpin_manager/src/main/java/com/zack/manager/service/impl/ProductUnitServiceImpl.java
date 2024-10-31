package com.zack.manager.service.impl;

import com.zack.manager.mapper.ProductUnitMapper;
import com.zack.manager.service.ProductUnitService;
import com.zack.model.enity.product.ProductUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductUnitServiceImpl implements ProductUnitService {
    @Autowired
    ProductUnitMapper productUnitMapper;
    @Override
    public List<ProductUnit> findAll() {
        return productUnitMapper.findAll();
    }
}
