package com.zack.cloud.user.service.Impl;

import com.zack.cloud.user.entity.User;
import com.zack.cloud.user.mapper.UserMapper;
import com.zack.cloud.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByUserId(Long userId) {
        return userMapper.findUserByUserId(userId);
    }
}
