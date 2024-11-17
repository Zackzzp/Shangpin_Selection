package com.zack.service.user.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zack.common.exception.ZackException;
import com.zack.model.vo.common.ResultCodeEnum;
import com.zack.service.user.service.SmsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class SmsServiceImpl implements SmsService {

    @Autowired
    private RedisTemplate<String , String> redisTemplate ;

    @Override
    public void sendValidateCode(String phone) {
        String validateCode = RandomStringUtils.randomNumeric(4);      // 生成验证码
        redisTemplate.opsForValue().set("phone:code:" + phone , validateCode , 5 , TimeUnit.MINUTES);
        Map<String, Object> param = new HashMap<>();
        param.put("code", validateCode);
        sendSms(phone , "CST_ptdie100" , param) ;
    }

    // 发送短信方法
    public void sendSms(String phone, String templateCode, Map<String, Object> param) {

        String host = "https://dfsns.market.alicloudapi.com";
        String path = "/data/send_sms";
        String method = "POST";
        String appcode = "您的appCode";
        Map<String, String> headers = new HashMap<>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<>();
        Map<String, String> bodys = new HashMap<>();

        StringBuffer contentBuffer = new StringBuffer();
        param.entrySet().forEach( item -> {
            contentBuffer.append(item.getKey()).append(":").append(item.getValue()).append(",");
        });
        String content = contentBuffer.substring(0, contentBuffer.length() - 1);

        bodys.put("content", content);
        bodys.put("phone_number", phone);
        bodys.put("template_id", templateCode);

        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);

            //获取response的body
            String data = EntityUtils.toString(response.getEntity());

            HashMap<String, String> resultMap = JSONObject.parseObject(data, HashMap.class);
            String status = resultMap.get("status");

            if(!"OK".equals(status)){
                String reason = resultMap.get("reason");
                log.error("短信发送失败：status = " + status + ", reason = " + reason);
                throw new ZackException(ResultCodeEnum.DATA_ERROR.getCode(), "短信发送失败");
            }

        } catch (Exception e) {
            throw new ZackException(ResultCodeEnum.DATA_ERROR.getCode(), "短信发送失败");
        }
    }
}