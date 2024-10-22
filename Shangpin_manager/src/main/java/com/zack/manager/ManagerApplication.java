package com.zack.manager;
import com.zack.common.anno.EnableGlobaleExceptionHandler;
import com.zack.common.anno.EnableKnife4j;
import com.zack.manager.properties.UserAuthProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(UserAuthProperties.class)
@EnableGlobaleExceptionHandler
@EnableKnife4j
@MapperScan("com.zack.manager.mapper")
public class ManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class,args);

    }
}
