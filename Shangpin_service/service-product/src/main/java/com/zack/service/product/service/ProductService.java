package com.zack.service.product.service;

import com.zack.model.enity.product.ProductSku;

import java.util.List;

public interface ProductService {
    List<ProductSku> findProductSkuBySale();
}
