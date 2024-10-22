package com.zack.manager.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
@Data
@ConfigurationProperties(prefix = "zack.auth")
public class UserAuthProperties {
    private List<String> noAuthUrls;
}
