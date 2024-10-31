package com.zack.model.enity.product;

import com.zack.model.enity.base.BaseEntity;
import lombok.Data;

@Data
public class ProductDetails extends BaseEntity {

    private Long productId;
    private String imageUrls;

}