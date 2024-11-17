package com.zack.service.user.mapper;

import com.zack.model.enity.user.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserInfoMapper {
    void save(UserInfo userInfo);

    UserInfo getByUsername(@Param("username") String username);

    void updateById(UserInfo userInfo);


}
