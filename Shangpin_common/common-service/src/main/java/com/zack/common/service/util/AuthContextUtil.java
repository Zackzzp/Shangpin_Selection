package com.zack.common.service.util;


import com.zack.model.enity.user.UserInfo;

public class AuthContextUtil {
    private static final ThreadLocal<UserInfo> userInfoThreadLocal = new ThreadLocal<>();
    //获取数据
    public static UserInfo getUserInfo() {
        return userInfoThreadLocal.get();
    }
    //存储数据
    public static void setUserInfo(UserInfo userInfo) {
        userInfoThreadLocal.set(userInfo);
    }
    //删除数据
    public static void removeUserInfo() {
        userInfoThreadLocal.remove();
    }
}
