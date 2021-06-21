package com.yinlu.system.dashboard;

import com.yinlu.system.common.swagger.annotation.EnableSwagger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @author dzhao1
 */
@EnableOpenApi
@EnableSwagger
@SpringBootApplication
public class DashboardApplication {
  public static void main(String[] args) {
    //
    SpringApplication.run(DashboardApplication.class, args);
  }
}
