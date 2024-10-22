package com.zack.common.util;

import com.zack.model.enity.system.SysUser;

public class AuthContextUtil {
    private static final ThreadLocal<SysUser> threadLocal = new ThreadLocal<>();
    //获取数据
    public static SysUser getUser() {
        return threadLocal.get();
    }
    //存储数据
    public static void setUser(SysUser user) {
        threadLocal.set(user);
    }
    //删除数据
    public static void removeUser() {
        threadLocal.remove();
    }
}
