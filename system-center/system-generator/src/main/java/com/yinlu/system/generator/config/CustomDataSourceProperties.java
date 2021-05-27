package com.yinlu.system.generator.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@Data

@ConfigurationProperties("customize.datasource")
public class CustomDataSourceProperties {
  private String tableName;
  private String url;
  private String username;
  private String password;
  private String driverClassName;

}
