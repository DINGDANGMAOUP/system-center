package com.yinlu.system.module.builder.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author dzhao1
 */
@Data
@ConfigurationProperties("spring.datasource.dynamic.datasource.master")
public class CustomDataSourceProperties {

  /**
   * 数据源表名
   */
  private String tableName;
  /**
   * 数据库连接地址
   */
  private String url;
  /**
   * 登入名
   */
  private String username;
  /**
   * 登入凭证
   */
  private String password;
  /**
   * 数据库连接驱动
   */
  private String driverClassName;

}
