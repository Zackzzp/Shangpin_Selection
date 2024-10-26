package com.zack.manager.service;

import com.zack.model.dto.system.AssignMenuDto;

import java.util.Map;
import java.util.Objects;

public interface SysRoleMenuService {
    /**
     * 查询角色对应菜单
     * @param roleID
     * @return
     */
    public abstract Map<String, Object> findSysRoleMenuByRoleId(Long roleID);

    /**
     * 保存菜单
     * @param assignMenuDto
     */
    public abstract void doAssign(AssignMenuDto assignMenuDto);
}
