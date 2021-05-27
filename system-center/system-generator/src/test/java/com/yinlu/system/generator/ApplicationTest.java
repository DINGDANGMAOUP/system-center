package com.yinlu.system.generator;

import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.yinlu.system.generator.mapper.MysqlMapper;
import com.yinlu.system.generator.model.MysqlTableInfo;
import java.util.List;
import javax.annotation.Resource;
import javax.sql.DataSource;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class ApplicationTest {

  @Resource
  MysqlMapper mapper;

  @Test
  void test(){

//    List<MysqlTableInfo> tables = mapper.tables();
//    tables.forEach(table->log.info(table.toString()));
  }
}
