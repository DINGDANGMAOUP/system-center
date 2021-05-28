package com.yinlu.system.generator.utils;

import com.yinlu.system.generator.model.MysqlTableField;
import com.yinlu.system.generator.pojo.dto.MysqlTableInfo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * mysql对象工具
 * @author dzhao1 */
public class MysqlTableUtil {
  public static List<MysqlTableInfo> init(List<MysqlTableField> mysqlTableFieldList) {
    List<MysqlTableInfo> tableList = new ArrayList<>();
    //分类封装table
    mysqlTableFieldList.stream()
        .collect(Collectors.groupingBy(MysqlTableField::getTableName, Collectors.toList()))
        .forEach((name, list) -> tableList.add(new MysqlTableInfo(name, list)));
    //对table_field排序
    tableList.forEach(table->table.getColumns().sort(Comparator.comparing(MysqlTableField::getOrdinalPosition)));
    return tableList;
  }
}
