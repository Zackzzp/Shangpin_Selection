package com.zack.manager;
import com.github.tobato.fastdfs.FdfsClientConfig;
import com.zack.common.anno.EnableGlobaleExceptionHandler;
import com.zack.common.anno.EnableKnife4j;
import com.zack.common.anno.EnableLogAspect;
import com.zack.manager.properties.UserAuthProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;

@SpringBootApplication
@EnableConfigurationProperties(UserAuthProperties.class)
@EnableGlobaleExceptionHandler
@Import(FdfsClientConfig.class)
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
@EnableKnife4j
@EnableLogAspect
@MapperScan("com.zack.manager.mapper")
public class ManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class,args);

    }
}
