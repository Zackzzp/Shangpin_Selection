package com.zack.manager.controller;

import com.zack.common.exception.ZackException;
import com.zack.manager.service.ValidateCodeService;
import com.zack.model.enity.system.SysUser;
import com.zack.model.vo.system.ValidateCodeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.zack.manager.service.SysUserService;
import com.zack.model.dto.system.LoginDto;
import com.zack.model.vo.system.LoginVo;
import com.zack.model.vo.common.Result;
import com.zack.model.vo.common.ResultCodeEnum;

@RestController
@RequestMapping("/admin/system/index")
public class IndexController {
    @Autowired
    private SysUserService sysUserService;
   @Autowired
    private ValidateCodeService validateCodeService;

    @PostMapping(value = "/login")
    public Result<LoginVo> login(@RequestBody LoginDto loginDto) {
        try {
            LoginVo loginVo = sysUserService.login(loginDto);
            return Result.build(loginVo, ResultCodeEnum.SUCCESS);
        } catch (ZackException zackException) {
            return Result.build(null, zackException.getResultCode());
        }

    }
    @GetMapping(value = "/generateValidateCode")
    public Result<ValidateCodeVo> generateValidateCode() {
        ValidateCodeVo validateCodeVo = validateCodeService.generateValidateCode();
        return Result.build(validateCodeVo , ResultCodeEnum.SUCCESS) ;
    }
    @GetMapping("/getUserInfo")
    public Result<SysUser> getUserInfo(@RequestHeader(name = "token")String token) {
        SysUser sysUser=sysUserService.getUserInfo(token);
        return Result.build(sysUser, ResultCodeEnum.SUCCESS);
    }
    @GetMapping(value = "/logout")
    public Result logout(@RequestHeader(name = "token")String token) {
        sysUserService.logout(token);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }

}
