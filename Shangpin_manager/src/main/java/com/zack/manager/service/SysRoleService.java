package com.zack.manager.service;

import com.github.pagehelper.PageInfo;
import com.zack.model.dto.system.SysRoleDto;
import com.zack.model.enity.system.SysRole;

public interface SysRoleService {
    /**
     * 按页查询
     *
     * @param sysRoleDto
     * @param pageNum
     * @param pageSize
     * @return
     */
    public abstract PageInfo<SysRole> findByPage(SysRoleDto sysRoleDto, Integer pageNum, Integer pageSize);

    /**
     * 添加角色
     * @param sysRole
     */
    public abstract void saveRole(SysRole sysRole);

    /**
     * 修改角色
     * @param sysRole
     */
    public abstract void updateSysRole(SysRole sysRole);

    /**
     * 删除角色
     * @param id
     */
    public abstract void deleteById(Long id);
}
