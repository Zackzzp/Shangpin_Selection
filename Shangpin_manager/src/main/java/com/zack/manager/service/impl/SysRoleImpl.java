package com.zack.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zack.manager.mapper.SysRoleMapper;
import com.zack.manager.service.SysRoleService;
import com.zack.model.dto.system.SysRoleDto;
import com.zack.model.enity.system.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleImpl implements SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public PageInfo<SysRole> findByPage(SysRoleDto sysRoleDto, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysRole> sysRoles = sysRoleMapper.findByPage(sysRoleDto);
        PageInfo<SysRole> pageInfo = new PageInfo<>(sysRoles);
        return pageInfo;
    }

    @Override
    public void saveRole(SysRole sysRole) {
        sysRoleMapper.saveRole(sysRole);
    }

    @Override
    public void updateSysRole(SysRole sysRole) {
        sysRoleMapper.updateSysRole(sysRole);

    }

    @Override
    public void deleteById(Long id) {
        sysRoleMapper.deleteById(id);
    }
}
