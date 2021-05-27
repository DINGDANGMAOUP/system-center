package com.yinlu.system.generator.controller;

import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import com.yinlu.system.generator.mapper.MysqlMapper;
import com.yinlu.system.generator.model.MysqlTableInfo;
import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dzhao1
 */
@RestController
@Slf4j
public class TestController {
  @Resource
  MysqlMapper mapper;
  @GetMapping("getList")
  public void select(){
    List<MysqlTableInfo> tables = mapper.tables();
    tables.forEach(table->log.info(table.toString()));
  }
  @GetMapping("push")
  public void push(){
    String mysql = DynamicDataSourceContextHolder.push("mysql");
    log.info(mysql);
  }

}
