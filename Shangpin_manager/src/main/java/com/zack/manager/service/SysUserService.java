package com.zack.manager.service;

import com.zack.model.dto.system.LoginDto;
import com.zack.model.vo.LoginVo;


public interface SysUserService {
    /**
     * 根据用户名查询用户数据
     * @return
     */
    public abstract LoginVo login(LoginDto loginDto);

}
