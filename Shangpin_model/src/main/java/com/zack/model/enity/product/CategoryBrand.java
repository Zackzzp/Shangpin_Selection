package com.zack.model.enity.product;

import com.zack.model.enity.base.BaseEntity;
import lombok.Data;

@Data
public class CategoryBrand extends BaseEntity {

    private Long brandId;
    private Long categoryId;

    // 扩展的属性用来封装前端所需要的数据
    private String categoryName;
    private String brandName;
    private String logo;

}
