package com.zack.manager.service;

import com.zack.model.enity.system.SysMenu;

import java.util.List;

public interface SysMenuService {
//    /**
//     * 查找全部目录
//     * @return
//     */
//    public abstract List<SysMenu> selectAll();

    /**
     * 查找树节点
     * @return
     */
    public abstract List<SysMenu> findNodes();

    /**
     * 保存菜单
     * @param sysMenu
     */
    public abstract void save(SysMenu sysMenu);
}
