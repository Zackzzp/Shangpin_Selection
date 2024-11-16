package com.zack.service.product.service;

import com.zack.model.enity.product.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findOneCategory();

    List<Category> findCategoryTree();
}
