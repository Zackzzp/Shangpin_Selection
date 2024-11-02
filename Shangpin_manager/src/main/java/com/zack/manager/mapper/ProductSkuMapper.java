package com.zack.manager.mapper;

import com.zack.model.enity.product.Product;
import com.zack.model.enity.product.ProductSku;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductSkuMapper {
    public abstract void save(ProductSku productSku);

    public abstract List<ProductSku> selectByProductId(Long id);

    public abstract  void updateById(ProductSku productSku);

    public abstract void deleteByProductId(Long id);
}
