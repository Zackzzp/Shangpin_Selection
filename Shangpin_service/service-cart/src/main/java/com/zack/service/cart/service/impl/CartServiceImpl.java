package com.zack.service.cart.service.impl;

import com.alibaba.fastjson.JSON;
import com.zack.common.service.util.AuthContextUtil;
import com.zack.feign.product.api.ProductFeignClient;
import com.zack.model.enity.product.CartInfo;
import com.zack.model.enity.product.ProductSku;
import com.zack.service.cart.service.CartService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

        @Autowired
        private RedisTemplate<String , String> redisTemplate;

        @Autowired
        private ProductFeignClient productFeignClient;

        private String getCartKey(Long userId) {
            //定义key user:cart:userId
            return "user:cart:" + userId;
        }

        @Override
        public void addToCart(Long skuId, Integer skuNum) {

            // 获取当前登录用户的id
            Long userId = AuthContextUtil.getUserInfo().getId();
            String cartKey = getCartKey(userId);

            //获取缓存对象
            Object cartInfoObj = redisTemplate.opsForHash().get(cartKey, String.valueOf(skuId));
            CartInfo cartInfo = null ;
            if(cartInfoObj != null) {       //  如果购物车中有该商品，则商品数量 相加！
                cartInfo = JSON.parseObject(cartInfoObj.toString() , CartInfo.class) ;
                cartInfo.setSkuNum(cartInfo.getSkuNum() + skuNum);
                cartInfo.setIsChecked(1);
                cartInfo.setUpdateTime(new Date());
            }else {

                // 当购物车中没用该商品的时候，则直接添加到购物车！
                cartInfo = new CartInfo();

                // 购物车数据是从商品详情得到 {skuInfo}
                ProductSku productSku = productFeignClient.getBySkuId(skuId).getData() ;
                cartInfo.setCartPrice(productSku.getSalePrice());
                cartInfo.setSkuNum(skuNum);
                cartInfo.setSkuId(skuId);
                cartInfo.setUserId(userId);
                cartInfo.setImgUrl(productSku.getThumbImg());
                cartInfo.setSkuName(productSku.getSkuName());
                cartInfo.setIsChecked(1);
                cartInfo.setCreateTime(new Date());
                cartInfo.setUpdateTime(new Date());

            }

            // 将商品数据存储到购物车中
            redisTemplate.opsForHash().put(cartKey , String.valueOf(skuId) , JSON.toJSONString(cartInfo));
        }

    @Override
    public List<CartInfo> getCartList() {
        // 获取当前登录的用户信息
        Long userId = AuthContextUtil.getUserInfo().getId();
        String cartKey = this.getCartKey(userId);

        // 获取数据
        List<Object> cartInfoList = redisTemplate.opsForHash().values(cartKey);

        if (!CollectionUtils.isEmpty(cartInfoList)) {
            List<CartInfo> infoList = cartInfoList.stream().map(cartInfoJSON -> JSON.parseObject(cartInfoJSON.toString(), CartInfo.class))
                    .sorted((o1, o2) -> o2.getCreateTime().compareTo(o1.getCreateTime()))
                    .collect(Collectors.toList());
            return infoList ;
        }

        return new ArrayList<>() ;
    }
}

