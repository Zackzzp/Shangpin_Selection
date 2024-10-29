package com.zack.manager.service.impl;

import com.zack.common.exception.ZackException;
import com.zack.manager.SysMenuHelper;
import com.zack.manager.mapper.SysMenuMapper;
import com.zack.manager.service.SysMenuService;
import com.zack.model.enity.system.SysMenu;
import com.zack.model.enity.system.SysUser;
import com.zack.model.vo.system.SysMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import com.zack.model.vo.common.ResultCodeEnum;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import com.zack.common.util.AuthContextUtil;

@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenu> findNodes() {
        List<SysMenu> sysMenuList = sysMenuMapper.selectAll();
        if (CollectionUtils.isEmpty(sysMenuList)) {
            return null;
        }
        List<SysMenu> treeList = SysMenuHelper.buildTree(sysMenuList);
        return treeList;
    }

    @Override
    public void save(SysMenu sysMenu) {
        sysMenuMapper.insert(sysMenu);
    }

    @Override
    public void removeById(Long id) {
        int count = sysMenuMapper.countByParentId(id);  // 先查询是否存在子菜单，如果存在不允许进行删除
        if (count > 0) {
            throw new ZackException(ResultCodeEnum.NODE_ERROR);
        }
        sysMenuMapper.deleteById(id);
    }

    @Override
    public void updateById(SysMenu sysMenu) {
        sysMenuMapper.updateById(sysMenu);
    }

    @Override
    public List<SysMenuVo> findUserMenuList() {

        SysUser sysUser = AuthContextUtil.getUser();
        Long userId = sysUser.getId();          // 获取当前登录用户的id

        List<SysMenu> sysMenuList = sysMenuMapper.selectListByUserId(userId) ;

        //构建树形数据
        List<SysMenu> sysMenuTreeList = SysMenuHelper.buildTree(sysMenuList);
        return this.buildMenus(sysMenuTreeList);
    }

// 将List<SysMenu>对象转换成List<SysMenuVo>对象
    private List<SysMenuVo> buildMenus(List<SysMenu> menus) {

        List<SysMenuVo> sysMenuVoList = new LinkedList<SysMenuVo>();
        for (SysMenu sysMenu : menus) {
            SysMenuVo sysMenuVo = new SysMenuVo();
            sysMenuVo.setTitle(sysMenu.getTitle());
            sysMenuVo.setName(sysMenu.getComponent());
            List<SysMenu> children = sysMenu.getChildren();
            if (!CollectionUtils.isEmpty(children)) {
                sysMenuVo.setChildren(buildMenus(children));
            }
            sysMenuVoList.add(sysMenuVo);
        }
        return sysMenuVoList;
    }
}
