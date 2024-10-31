package com.zack.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zack.manager.mapper.ProductDetailsMapper;
import com.zack.manager.mapper.ProductMapper;
import com.zack.manager.mapper.ProductSkuMapper;
import com.zack.manager.mapper.ProductUnitMapper;
import com.zack.manager.service.ProductService;
import com.zack.model.dto.product.ProductDto;
import com.zack.model.enity.product.Product;
import com.zack.model.enity.product.ProductDetails;
import com.zack.model.enity.product.ProductSku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductSkuMapper productSkuMapper;
    @Autowired
    private ProductDetailsMapper productDetailsMapper;
    @Override
    public PageInfo<Product> findByPage(Integer page, Integer limit,ProductDto productDto) {
        PageHelper.startPage(page, limit);
        List<Product> productList=productMapper.findByPage(productDto);
        return new PageInfo<>(productList);
    }

    @Transactional
    @Override
    public void save(Product product) {

        // 保存商品数据
        product.setStatus(0);              // 设置上架状态为0
        product.setAuditStatus(0);         // 设置审核状态为0
        productMapper.save(product);

        // 保存商品sku数据
        List<ProductSku> productSkuList = product.getProductSkuList();
        for(int i=0,size=productSkuList.size(); i<size; i++) {

            // 获取ProductSku对象
            ProductSku productSku = productSkuList.get(i);
            productSku.setSkuCode(product.getId() + "_" + i);       // 构建skuCode
            productSku.setProductId(product.getId());               // 设置商品id
            productSku.setSkuName(product.getName() + productSku.getSkuSpec());
            productSku.setSaleNum(0);                               // 设置销量
            productSku.setStatus(0);
            productSkuMapper.save(productSku);                    // 保存数据

        }

        // 保存商品详情数据
        ProductDetails productDetails = new ProductDetails();
        productDetails.setProductId(product.getId());
        productDetails.setImageUrls(product.getDetailsImageUrls());
        productDetailsMapper.save(productDetails);

    }

}
