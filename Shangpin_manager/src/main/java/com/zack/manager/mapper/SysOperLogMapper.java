package com.zack.manager.mapper;

import com.zack.model.enity.system.SysOperLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysOperLogMapper {
    public abstract void insert(SysOperLog sysOperLog);
}
