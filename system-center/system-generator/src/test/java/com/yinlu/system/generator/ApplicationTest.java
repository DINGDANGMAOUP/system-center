package com.yinlu.system.generator;

import com.yinlu.system.generator.controller.LoadController;
import com.yinlu.system.generator.mapper.MysqlMapper;
import com.yinlu.system.generator.service.SystemDataSourceService;
import javax.annotation.Resource;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class ApplicationTest {
@Resource
  SystemDataSourceService systemDataSourceService;
@Resource
  LoadController loadController;
@Resource
MysqlMapper mapper;

@Resource
DataSource dataSource;

  @Test
  void test(){
//    DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
//    log.info(ds.getCurrentDataSources().keySet().toString());
//    DynamicDataSourceContextHolder.push("kuroneko");
//    List<MysqlTableInfo> tableInfoList = mapper.listToTable("kuroneko");
//    log.info(kuroneko.toString());
//    Result now = loadController.now();
//    log.info(now.toString());
//    List<MysqlTableInfo> tables = mapper.tables();
//    tables.forEach(table->log.info(table.toString()));
  }
}
