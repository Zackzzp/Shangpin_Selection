package com.zack.service.user.service.impl;

import com.zack.common.service.util.AuthContextUtil;
import com.zack.model.enity.user.UserAddress;
import com.zack.service.user.mapper.UserAddressMapper;
import com.zack.service.user.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAddressServiceImpl implements UserAddressService {
    @Autowired
    private UserAddressMapper userAddressMapper;

    @Override
    public List<UserAddress> findUserAddressList() {
        Long userId = AuthContextUtil.getUserInfo().getId();
        return userAddressMapper.findByUserId(userId);
    }
}
