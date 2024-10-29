package com.zack.manager.service;

import com.zack.model.enity.system.SysMenu;
import com.zack.model.vo.system.SysMenuVo;

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

    /**
     * 按id删除菜单
     * @param id
     */
    public abstract void removeById(Long id);

    /**
     * 修改菜单
     * @param sysMenu
     */
    public abstract void updateById(SysMenu sysMenu);

    /**
     * 动态菜单
     * @return
     */
    public abstract List<SysMenuVo> findUserMenuList();
}
