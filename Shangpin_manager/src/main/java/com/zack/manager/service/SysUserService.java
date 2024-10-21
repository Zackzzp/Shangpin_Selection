package com.zack.manager.service;

import com.zack.model.dto.system.LoginDto;
import com.zack.model.enity.system.SysUser;
import com.zack.model.vo.system.LoginVo;


public interface SysUserService {
    /**
     * 根据用户名查询用户数据
     * @return
     */
    public abstract LoginVo login(LoginDto loginDto);

    /**
     * 获取用户数据
     * @param token
     * @return
     */
    public abstract SysUser getUserInfo(String token);

    /**
     * 用户退出
     * @param token
     * @return
     */
    public abstract void logout(String token);

}
