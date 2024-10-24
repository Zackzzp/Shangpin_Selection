package com.zack.manager.service.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zack.common.exception.ZackException;
import com.zack.model.dto.system.SysUserDto;
import com.zack.model.vo.common.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import com.zack.manager.mapper.SysUserMapper;
import com.zack.manager.service.SysUserService;
import com.zack.model.dto.system.LoginDto;
import com.zack.model.enity.system.SysUser;
import com.zack.model.vo.system.LoginVo;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class SysUserImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper ;

    @Autowired
    private RedisTemplate<String , String> redisTemplate ;

    @Override
    public LoginVo login(LoginDto loginDto) {

        // 根据用户名查询用户
        SysUser sysUser = sysUserMapper.selectByUserName(loginDto.getUserName());
        if(sysUser == null) {
            throw new ZackException(ResultCodeEnum.SUCCESS);
        }

        // 验证密码是否正确
        String inputPassword = loginDto.getPassword();
        String md5InputPassword = DigestUtils.md5DigestAsHex(inputPassword.getBytes());
        String captha=loginDto.getCaptcha();
        String codeKey=loginDto.getCodeKey();
        if(!md5InputPassword.equals(sysUser.getPassword())) {
            throw new ZackException(ResultCodeEnum.LOGIN_ERROR) ;
        }
        String redisCode = redisTemplate.opsForValue().get("user:login:validatecode"+codeKey);
        if (StrUtil.isEmpty(redisCode)||StrUtil.equalsIgnoreCase(redisCode,captha)) {
            throw new ZackException(ResultCodeEnum.VALIDATECODE_ERROR) ;
        }
        redisTemplate.delete("user:login:validatecode"+codeKey);

        // 生成令牌，保存数据到Redis中
        String token = UUID.randomUUID().toString().replace("-", "");
        redisTemplate.opsForValue().set("user:login:" + token , com.alibaba.fastjson.JSON.toJSONString(sysUser), 30 , TimeUnit.MINUTES);

        // 构建响应结果对象
        LoginVo loginVo = new LoginVo() ;
        loginVo.setToken(token);
        loginVo.setRefresh_token("");



        // 返回
        return loginVo;
    }

    @Override
    public SysUser getUserInfo(String token) {
        String usereJson=redisTemplate.opsForValue().get("user:login:"+token);
        return JSON.parseObject(usereJson, SysUser.class);
    }

    @Override
    public void logout(String token) {
        redisTemplate.delete("user:login:"+token);
    }

    @Override
    public PageInfo<SysUser> findByPage(SysUserDto sysUserDto,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SysUser> sysUserList=sysUserMapper.findByPage(sysUserDto);
        PageInfo<SysUser> pageInfo = new PageInfo<>(sysUserList);
        return pageInfo;
    }

    @Override
    public void saveSysUser(SysUser sysUser) {
        sysUserMapper.saveSysUser(sysUser);
    }

    @Override
    public void updateSysUser(SysUser sysUser) {
        sysUserMapper.updateSysUser(sysUser);
    }

    @Override
    public void deleteById(Long id) {
        sysUserMapper.deleteById(id);
    }
}
