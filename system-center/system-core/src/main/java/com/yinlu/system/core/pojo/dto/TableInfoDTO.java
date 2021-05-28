package com.yinlu.system.core.pojo.dto;

import lombok.Data;

/**
 * @author dzhao1
 */
@Data
public class TableInfoDTO {

  /**
   * 所属数据库
   */
  private String tableSchema;
  /**
   * 表名
   */
  private String tableName;

}
