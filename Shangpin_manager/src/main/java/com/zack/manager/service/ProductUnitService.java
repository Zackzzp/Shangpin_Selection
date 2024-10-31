package com.zack.manager.service;

import com.zack.model.enity.product.ProductUnit;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface ProductUnitService {

    public abstract List<ProductUnit> findAll();
}
