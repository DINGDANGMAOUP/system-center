package com.yinlu.system.module.builder.config;

import com.baomidou.dynamic.datasource.provider.AbstractJdbcDataSourceProvider;
import com.baomidou.dynamic.datasource.provider.DynamicDataSourceProvider;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import com.yinlu.system.core.constants.SysConstant;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** @author dzhao1 */
@Configuration
@EnableConfigurationProperties(CustomDataSourceProperties.class)
public class DynamicDataSourceConfig {
  @Resource CustomDataSourceProperties customDataSourceProperties;

  @Bean
  public DynamicDataSourceProvider dynamicDataSourceProvider() {
    String tableName = customDataSourceProperties.getTableName();
    String driverClassName = customDataSourceProperties.getDriverClassName();
    String url = customDataSourceProperties.getUrl();
    String username = customDataSourceProperties.getUsername();
    String password = customDataSourceProperties.getPassword();
    return new AbstractJdbcDataSourceProvider(driverClassName, url, username, password) {
      @Override
      protected Map<String, DataSourceProperty> executeStmt(Statement statement)
          throws SQLException {
        ResultSet rs = statement.executeQuery(String.format(SysConstant.DB_SOURCE_SQL, tableName));
        Map<String, DataSourceProperty> map = new HashMap<>(16);
        DataSourceProperty master = new DataSourceProperty();
        master.setUsername(username);
        master.setPassword(password);
        master.setUrl(url);
        master.setDriverClassName(driverClassName);
        map.put("master", master);
        while (rs.next()) {
          String sourceName = rs.getString("source_name");
          String username = rs.getString("username");
          String password = rs.getString("password");
          String url = rs.getString("url");
          String driver = rs.getString("driver");
          DataSourceProperty property = new DataSourceProperty();
          property.setUsername(username);
          property.setPassword(password);
          property.setUrl(url);
          property.setDriverClassName(driver);
          map.put(sourceName, property);
        }
        return map;
      }
    };
  }
}
