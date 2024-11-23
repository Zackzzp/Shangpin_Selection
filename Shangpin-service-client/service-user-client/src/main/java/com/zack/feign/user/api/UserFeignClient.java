package com.zack.feign.user.api;

import com.zack.model.enity.user.UserAddress;
import com.zack.model.vo.common.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-user" , fallback = UserFeignClientFallback.class)
public interface UserFeignClient {

    @GetMapping("/api/user/userAddress/getUserAddress/{id}")
    public abstract Result<UserAddress> getUserAddress(@PathVariable Long id) ;

}

