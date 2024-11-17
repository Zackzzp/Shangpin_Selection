package com.zack.service.product.service;

import com.github.pagehelper.PageInfo;
import com.zack.model.dto.product.ProductSkuDto;
import com.zack.model.enity.product.ProductSku;
import com.zack.model.vo.h5.ProductItemVo;

import java.util.List;

public interface ProductService {
    List<ProductSku> findProductSkuBySale();
    PageInfo<ProductSku> findByPage(Integer page, Integer limit, ProductSkuDto productSkuDto);
    ProductItemVo item(Long skuId);
}
