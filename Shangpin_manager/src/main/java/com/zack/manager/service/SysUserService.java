package com.zack.manager.service;

import com.github.pagehelper.PageInfo;
import com.zack.model.dto.system.LoginDto;
import com.zack.model.dto.system.SysUserDto;
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

    /**
     * 按页查询用户
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<SysUser> findByPage(SysUserDto sysUserDto,int pageNum, int pageSize);

    /**
     * 保存用户
     * @param sysUser
     */
    public void saveSysUser(SysUser sysUser);

    /**
     * 修改用户
     * @param sysUser
     *
     */
    public void updateSysUser(SysUser sysUser);

    /**
     * 删除用户
     * @param id
     */
    public void deleteById(Long id);
}
