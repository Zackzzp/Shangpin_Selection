package com.zack.service.cart.service;

import com.zack.model.enity.product.CartInfo;

import java.util.List;

public interface CartService {
    void addToCart(Long skuId, Integer skuNum);
    List<CartInfo> getCartList();
}
