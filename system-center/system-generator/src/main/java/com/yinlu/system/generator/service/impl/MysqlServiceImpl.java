package com.yinlu.system.generator.service.impl;

import com.yinlu.system.generator.mapper.MysqlMapper;
import com.yinlu.system.generator.model.MysqlTableField;
import com.yinlu.system.generator.model.TableName;
import com.yinlu.system.generator.service.MysqlService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author dzhao1
 */
@Service
public class MysqlServiceImpl implements MysqlService {
  @Resource
  MysqlMapper mysqlMapper;

  @Override
  public List<MysqlTableField> getByDBNameAndTableName(String tableSchema, String tableName) {
    return mysqlMapper.getByDBNameAndTableName(tableSchema,tableName);
  }

  @Override
  public List<TableName> listToTable(String sourceName) {
    return mysqlMapper.listToTable(sourceName);
  }
}
