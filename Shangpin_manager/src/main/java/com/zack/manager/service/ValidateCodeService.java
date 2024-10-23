package com.zack.manager.service;

import com.zack.model.vo.system.ValidateCodeVo;
import org.springframework.stereotype.Service;


public interface ValidateCodeService {
    // 获取验证码图片
    public abstract ValidateCodeVo generateValidateCode();

}
