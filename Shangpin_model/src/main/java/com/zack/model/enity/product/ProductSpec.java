package com.zack.model.enity.product;

import com.zack.model.enity.base.BaseEntity;
import lombok.Data;

@Data
public class ProductSpec extends BaseEntity {

    private String specName;   // 规格名称
    private String specValue;  // 规格值

}
