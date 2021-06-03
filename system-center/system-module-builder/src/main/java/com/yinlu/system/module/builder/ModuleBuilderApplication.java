package com.yinlu.system.module.builder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author dzhao1
 */
@MapperScan("com.yinlu.system.module.builder.mapper")
@SpringBootApplication
public class ModuleBuilderApplication {
  public static void main(String[] args) {
    SpringApplication.run(ModuleBuilderApplication.class, args);
  }
}
