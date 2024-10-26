package com.zack.manager.mapper;

import com.zack.model.dto.system.AssignMenuDto;

import java.util.List;

public interface SysRoleMenuMapper {
    public abstract List<Long> findSysRoleMenuByRoleId(Long roleId);

    public abstract void deleteByRoleId(Long roleId);

    public abstract void doAssign(AssignMenuDto assignMenuDto);
}
