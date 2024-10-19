package com.zack.manager.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.zack.model.enity.system.SysUser;

@Mapper
public  interface SysUserMapper {
    /**
     * 根据用户名查询用户数据
     *
     * @param userName
     * @return
     */
    public abstract SysUser selectByUserName(String userName);

}
