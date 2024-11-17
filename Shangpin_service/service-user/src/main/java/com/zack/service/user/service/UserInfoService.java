package com.zack.service.user.service;

import com.zack.model.dto.user.UserLoginDto;
import com.zack.model.dto.user.UserRegisterDto;
import com.zack.model.vo.h5.UserInfoVo;

public interface UserInfoService {
    void register(UserRegisterDto userRegisterDto);

    String login(UserLoginDto userLoginDto, String ip);

    UserInfoVo getCurrentUserInfo(String token);
}
