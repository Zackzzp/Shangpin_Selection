package com.zack.feign.user.fallback;

import com.zack.feign.user.api.UserFeignClient;
import com.zack.model.enity.user.UserAddress;
import com.zack.model.vo.common.Result;
import com.zack.model.vo.common.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserFeignClientFallback implements UserFeignClient {

    @Override
    public Result<UserAddress> getUserAddress(Long id) {
        log.info("UserFeignClientFallback...getUserAddress的方法执行了");
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

}
