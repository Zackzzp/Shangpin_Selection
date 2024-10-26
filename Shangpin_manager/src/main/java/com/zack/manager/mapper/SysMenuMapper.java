package com.zack.manager.mapper;

import com.zack.model.enity.system.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysMenuMapper {

   public abstract List <SysMenu>  selectAll();

   public abstract void insert(SysMenu sysMenu);

   public abstract int countByParentId(Long id);

   public abstract void deleteById(Long id);

   public abstract void updateById(SysMenu sysMenu);
}
