package com.zack.manager;
import com.zack.common.anno.EnableGlobaleExceptionHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableGlobaleExceptionHandler
@MapperScan("com.zack.manager.mapper")
public class ManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class,args);

    }
}
