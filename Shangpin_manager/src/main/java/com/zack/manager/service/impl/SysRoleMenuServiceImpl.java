package com.zack.manager.service.impl;

import com.zack.manager.mapper.SysRoleMenuMapper;
import com.zack.manager.service.SysMenuService;
import com.zack.manager.service.SysRoleMenuService;
import com.zack.model.dto.system.AssignMenuDto;
import com.zack.model.enity.system.SysMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService {
    @Autowired
    SysMenuService sysMenuService;
    @Autowired
    SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public Map<String, Object> findSysRoleMenuByRoleId(Long roleId) {
        List<SysMenu> sysMenuList = sysMenuService.findNodes();
        List<Long> roleMenuIds = sysRoleMenuMapper.findSysRoleMenuByRoleId(roleId);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("sysMenuList", sysMenuList);
        resultMap.put("roleMenuIds", roleMenuIds);
        return resultMap;
    }

    @Override
    @Transactional
    public void doAssign(AssignMenuDto assignMenuDto) {
        sysRoleMenuMapper.deleteByRoleId(assignMenuDto.getRoleId());
        List <Map<String,Number>> menuInfo=assignMenuDto.getMenuIdList();
        if (menuInfo!=null&&menuInfo.size()>0) {
            sysRoleMenuMapper.doAssign(assignMenuDto);
        }
    }
}
