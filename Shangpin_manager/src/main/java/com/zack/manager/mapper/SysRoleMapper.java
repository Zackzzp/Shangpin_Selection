package com.zack.manager.mapper;

import com.zack.model.dto.system.SysRoleDto;
import com.zack.model.enity.system.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRoleMapper {
    public abstract List<SysRole> findByPage(SysRoleDto sysRoleDto);
    public abstract void saveRole(SysRole sysRole);
    public abstract void updateSysRole(SysRole sysRole);
    public abstract void deleteById(Long id);
}
