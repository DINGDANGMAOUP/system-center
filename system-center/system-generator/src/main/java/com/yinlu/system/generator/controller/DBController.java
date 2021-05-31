package com.yinlu.system.generator.controller;

import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import com.yinlu.system.core.pojo.dto.TableInfoDTO;
import com.yinlu.system.core.result.Result;
import com.yinlu.system.generator.model.MysqlTableField;
import com.yinlu.system.generator.pojo.dto.DataInfoDTO;
import com.yinlu.system.generator.pojo.dto.MysqlTableInfo;
import com.yinlu.system.generator.model.TableName;
import com.yinlu.system.generator.service.MysqlService;
import com.yinlu.system.generator.utils.MysqlTableUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** @author dzhao1 */
@RestController
@RequestMapping("/db")
@Api(tags = "数据库信息控制层")
@Slf4j
public class DBController {

  @Resource MysqlService mysqlService;
  @Resource DataSource dataSource;

  @GetMapping("/list")
  @ApiOperation("获取所有数据源及其包含表名")
  public Result list() {
    DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
    Set<String> sourceNameList = ds.getCurrentDataSources().keySet();
    List<DataInfoDTO> dataInfoDTOList = new ArrayList<>();
    sourceNameList.forEach(
        s -> {
          DynamicDataSourceContextHolder.push(s);
          List<TableName> tableNames = mysqlService.listToTable(s);
          dataInfoDTOList.add(new DataInfoDTO(s, tableNames));
        });
    return Result.success(dataInfoDTOList);
  }

  /**
   * (搁置)
   * 设置默认数据源 UPDATE `system_data_source` SET `def` = (`source_name` = 2)
   * @return
   */
//  @GetMapping("/def")
//  @ApiOperation("设置默认数据源")
//  public Result defDB() {
//    DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
//    ds.setPrimary();
//    Set<String> sourceNameList = ds.getCurrentDataSources().keySet();
//    List<DataInfoDTO> dataInfoDTOList = new ArrayList<>();
//    sourceNameList.forEach(
//        s -> {
//          DynamicDataSourceContextHolder.push(s);
//          List<TableName> tableNames = mysqlService.listToTable(s);
//          dataInfoDTOList.add(new DataInfoDTO(s, tableNames));
//        });
//    return Result.success(dataInfoDTOList);
//  }

  @GetMapping("/list/{sourceName}")
  @ApiOperation("获取数据源所有表名")
  public Result listToTable(@PathVariable("sourceName") String sourceName) {
    DynamicDataSourceContextHolder.push(sourceName);
    List<TableName> tableInfoList = mysqlService.listToTable(sourceName);
    return Result.success(tableInfoList);
  }

  /**
   * 获取指定表结构
   *
   * @param tableInfoDTO 表名 数据库名
   * @return 表结构集合
   */
  @PostMapping("getTableInfo")
  @ApiOperation("获取指定表结构")
  public Result listByTableName(@RequestBody TableInfoDTO tableInfoDTO) {
    String tableSchema = tableInfoDTO.getTableSchema();
    String tableName = tableInfoDTO.getTableName();
    // 切换数据源
    DynamicDataSourceContextHolder.push(tableSchema);
    List<MysqlTableField> fieldList = mysqlService.getByDBNameAndTableName(tableSchema, tableName);
    List<MysqlTableInfo> mysqlTableInfoList = MysqlTableUtil.init(fieldList);
    return Result.success(mysqlTableInfoList);
  }
}
