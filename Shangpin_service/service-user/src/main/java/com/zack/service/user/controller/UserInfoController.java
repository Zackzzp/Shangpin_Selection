package com.zack.service.user.controller;

import com.zack.common.util.IpUtil;
import com.zack.model.dto.user.UserLoginDto;
import com.zack.model.dto.user.UserRegisterDto;
import com.zack.model.enity.user.UserInfo;
import com.zack.model.vo.common.Result;
import com.zack.model.vo.common.ResultCodeEnum;
import com.zack.model.vo.h5.UserInfoVo;
import com.zack.service.user.service.UserInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.zack.common.service.util.AuthContextUtil;

@Tag(name = "会员用户接口")
@RestController
@RequestMapping("api/user/userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Operation(summary = "会员注册")
    @PostMapping("register")
    public Result register(@RequestBody UserRegisterDto userRegisterDto) {
        userInfoService.register(userRegisterDto);
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    @Operation(summary = "会员登录")
    @PostMapping("login")
    public Result login(@RequestBody UserLoginDto userLoginDto, HttpServletRequest request) {
        String ip = IpUtil.getIpAddress(request);
        return Result.build(userInfoService.login(userLoginDto, ip), ResultCodeEnum.SUCCESS);
    }

    @Operation(summary = "获取当前登录用户信息")
    @GetMapping("auth/getCurrentUserInfo")
    public UserInfoVo getCurrentUserInfo(HttpServletRequest request) {
        UserInfo userInfo = AuthContextUtil.getUserInfo();
        UserInfoVo userInfoVo = new UserInfoVo();
        BeanUtils.copyProperties(userInfo, userInfoVo);
        return userInfoVo ;
    }


}
