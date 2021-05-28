package com.yinlu.system.generator.service;

import com.yinlu.system.generator.model.MysqlTableField;
import com.yinlu.system.generator.model.TableName;
import java.util.List;

/**
 * @author dzhao1
 */
public interface MysqlService {

  /**
   * 查询表字段详情
   * @param tableSchema 所属数据库
   * @param tableName 表名
   * @return 表详情对象
   */
  List<MysqlTableField> getByDBNameAndTableName(String tableSchema, String tableName);

  List<TableName> listToTable(String sourceName);
}
