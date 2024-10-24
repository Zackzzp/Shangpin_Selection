package com.zack.manager.mapper;

import com.github.pagehelper.PageInfo;
import com.zack.model.dto.system.SysUserDto;
import org.apache.catalina.LifecycleState;
import org.apache.ibatis.annotations.Mapper;
import com.zack.model.enity.system.SysUser;

import java.util.List;

@Mapper
public  interface SysUserMapper {
    /**
     * 根据用户名查询用户数据
     *
     * @param userName
     * @return
     */
    public abstract SysUser selectByUserName(String userName);

    /**
     * 按页查询用户
     * @param sysUserDto
     * @return
     */
    public abstract List<SysUser> findByPage(SysUserDto sysUserDto);

    /**
     * 插入用户
     * @param sysUser
     */
    public abstract void saveSysUser(SysUser sysUser);

    /**
     * 修改用户
     * @param sysUser
     */
    public abstract void updateSysUser(SysUser sysUser);

    /**
     * 删除用户
     * @param id
     */
    public abstract void deleteById(Long id);


}
