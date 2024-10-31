package com.zack.manager.mapper;

import com.zack.model.enity.product.ProductSpec;
import jdk.dynalink.linker.LinkerServices;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductSpecMapper {
    public abstract List<ProductSpec> findByPage();

    public abstract void save(ProductSpec productSpec);

    public abstract void updateById(ProductSpec productSpec);

    public abstract void deleteById(Long id);
}
