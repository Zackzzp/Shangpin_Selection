package com.zack.model.vo.h5;

import com.zack.model.enity.product.Category;
import com.zack.model.enity.product.ProductSku;
import lombok.Data;

import java.util.List;

@Data
public class IndexVo {

    private List<Category> categoryList ;       // 一级分类的类别数据
    private List<ProductSku> productSkuList ;   // 畅销商品列表数据

}
