package com.zack.manager.controller;

import com.zack.common.exception.ZackException;
import com.zack.common.util.AuthContextUtil;
import com.zack.manager.service.ValidateCodeService;
import com.zack.model.enity.system.SysUser;
import com.zack.model.vo.system.ValidateCodeVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.zack.manager.service.SysUserService;
import com.zack.model.dto.system.LoginDto;
import com.zack.model.vo.system.LoginVo;
import com.zack.model.vo.common.Result;
import com.zack.model.vo.common.ResultCodeEnum;
@Tag(name = "首页接口")
@RestController
@RequestMapping("/admin/system/index")
public class IndexController {
    @Autowired
    private SysUserService sysUserService;
   @Autowired
    private ValidateCodeService validateCodeService;
@Operation(summary = "用户登录")
    @PostMapping(value = "/login")
    public Result<LoginVo> login(@RequestBody LoginDto loginDto) {
        try {
            LoginVo loginVo = sysUserService.login(loginDto);
            return Result.build(loginVo, ResultCodeEnum.SUCCESS);
        } catch (ZackException zackException) {
            return Result.build(null, zackException.getResultCode());
        }

    }
    @Operation(summary = "生成验证码")
    @GetMapping(value = "/generateValidateCode")
    public Result<ValidateCodeVo> generateValidateCode() {
        ValidateCodeVo validateCodeVo = validateCodeService.generateValidateCode();
        return Result.build(validateCodeVo , ResultCodeEnum.SUCCESS) ;
    }
    @Operation(summary = "获取用户信息")
    @GetMapping("/getUserInfo")
    public Result<SysUser> getUserInfo(@RequestHeader(name = "token")String token) {
        return Result.build(AuthContextUtil.getUser(), ResultCodeEnum.SUCCESS);
    }
    @Operation(summary = "用户退出")
    @Parameters(value = {
            @Parameter(name = "令牌参数" , required = true)
    })
    @GetMapping(value = "/logout")
    public Result logout(@RequestHeader(name = "token")String token) {
        sysUserService.logout(token);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }



}
