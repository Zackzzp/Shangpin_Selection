package com.zack.common.log.service;

import com.zack.model.enity.system.SysOperLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

public interface AsyncOperLogService {			// 保存日志数据
    public abstract void saveSysOperLog(SysOperLog sysOperLog) ;
}



