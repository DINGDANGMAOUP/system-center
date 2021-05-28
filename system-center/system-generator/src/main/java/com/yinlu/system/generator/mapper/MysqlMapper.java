package com.yinlu.system.generator.mapper;

import com.yinlu.system.generator.model.MysqlTableField;
import com.yinlu.system.generator.pojo.dto.MysqlTableInfo;
import com.yinlu.system.generator.model.TableName;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author dzhao1
 */
public interface MysqlMapper {

  List<MysqlTableInfo> tables();

  List<MysqlTableField> getByDBNameAndTableName(@Param("tableSchema") String tableSchema,@Param("tableName") String tableName);

  List<TableName> listToTable(@Param("sourceName") String sourceName);
}
