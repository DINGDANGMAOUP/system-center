package com.yinlu.system.generator.controller;

import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.creator.DefaultDataSourceCreator;
import com.baomidou.dynamic.datasource.creator.HikariDataSourceCreator;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import com.yinlu.system.core.result.Result;
import com.yinlu.system.generator.DataSourceDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import javax.sql.DataSource;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dzhao1
 */
@RestController
@Slf4j
@RequestMapping("/datasources")
@Api(tags = "添加删除数据源")
public class LoadController {

  @Resource
  DataSource dataSource;
  @Resource
  DefaultDataSourceCreator dataSourceCreator; // 3.3.2及以上版本使用这个，无特殊要求推荐使用
  //  private final BasicDataSourceCreator basicDataSourceCreator;
  //  private final JndiDataSourceCreator jndiDataSourceCreator;
  //  private final DruidDataSourceCreator druidDataSourceCreator;
  @Resource
   HikariDataSourceCreator hikariDataSourceCreator;

  @GetMapping
  @ApiOperation("获取当前所有数据源")
  public Result now() {
    DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
    return Result.success(ds.getCurrentDataSources().keySet());
  }
  @GetMapping("/switch/{sourceName}")
  @ApiOperation("切换默认数据源")
  public Result Primary(@PathVariable("sourceName") String sourceName){
    DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
    ds.setPrimary(sourceName);
    return  Result.success();
  }
  @PostMapping("/add")
  @ApiOperation("通用添加数据源（推荐）")
  public Result add(@Validated @RequestBody DataSourceDTO dto) {
    DataSourceProperty dataSourceProperty = new DataSourceProperty();
    BeanUtils.copyProperties(dto, dataSourceProperty);
    DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
    DataSource dataSource = dataSourceCreator.createDataSource(dataSourceProperty);
    ds.addDataSource(dto.getSourceName(), dataSource);
    return Result.success(ds.getCurrentDataSources().keySet());
  }

  //  @PostMapping("/addBasic")
  //  @ApiOperation(value = "添加基础数据源", notes = "调用Springboot内置方法创建数据源，兼容1,2")
  //  public Set<String> addBasic(@Validated @RequestBody DataSourceDTO dto) {
  //      DataSourceProperty dataSourceProperty = new DataSourceProperty();
  //      BeanUtils.copyProperties(dto, dataSourceProperty);
  //      DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
  //      DataSource dataSource = basicDataSourceCreator.createDataSource(dataSourceProperty);
  //      ds.addDataSource(dto.getPollName(), dataSource);
  //      return ds.getCurrentDataSources().keySet();
  //  }

  //  @PostMapping("/addJndi")
  //  @ApiOperation("添加JNDI数据源")
  //  public Set<String> addJndi(String pollName, String jndiName) {
  //      DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
  //      DataSource dataSource = jndiDataSourceCreator.createDataSource(jndiName);
  //      ds.addDataSource(pollName, dataSource);
  //      return ds.getCurrentDataSources().keySet();
  //  }

  //  @PostMapping("/addDruid")
  //  @ApiOperation("基础Druid数据源")
  //  public Set<String> addDruid(@Validated @RequestBody DataSourceDTO dto) {
  //      DataSourceProperty dataSourceProperty = new DataSourceProperty();
  //      BeanUtils.copyProperties(dto, dataSourceProperty);
  //      DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
  //      DataSource dataSource = druidDataSourceCreator.createDataSource(dataSourceProperty);
  //      ds.addDataSource(dto.getPollName(), dataSource);
  //      return ds.getCurrentDataSources().keySet();
  //  }

  @PostMapping("/addHikariCP")
  @ApiOperation("基础HikariCP数据源")
  public Result addHikariCP(@Validated @RequestBody DataSourceDTO dto) {
    DataSourceProperty dataSourceProperty = new DataSourceProperty();
    BeanUtils.copyProperties(dto, dataSourceProperty);
    DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
    DataSource dataSource = hikariDataSourceCreator.createDataSource(dataSourceProperty);
    ds.addDataSource(dto.getSourceName(), dataSource);
    return Result.success(ds.getCurrentDataSources().keySet());
  }

  @DeleteMapping("remove/{sourceName}")
  @ApiOperation("删除数据源")
  public Result remove(@PathVariable("sourceName") String sourceName) {
    DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
    ds.removeDataSource(sourceName);
    return Result.success();
  }
  @GetMapping("push/{ds}")
  @ApiOperation("切换数据源")
  public Result push(@PathVariable("ds") String ds){
    String mysql = DynamicDataSourceContextHolder.push(ds);
    return Result.success(mysql);
  }
}
