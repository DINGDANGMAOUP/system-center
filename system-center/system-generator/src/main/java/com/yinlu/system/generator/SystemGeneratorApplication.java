package com.yinlu.system.generator;

import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.yinlu.system.common.swagger.annotation.EnableSwagger;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
@EnableSwagger
@MapperScan("com.yinlu.system.generator.mapper")
public class SystemGeneratorApplication {



    public static void main(String[] args) {
        SpringApplication.run(SystemGeneratorApplication.class, args);
    }


}
