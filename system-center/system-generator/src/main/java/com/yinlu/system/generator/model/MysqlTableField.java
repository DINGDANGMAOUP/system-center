package com.yinlu.system.generator.model;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @author dzhao1
 */
@Data
public class MysqlTableField {
  /** 表名 */
  @TableField("TABLE_NAME")
  private String tableName;
  /** 字段名 */
  @TableField("COLUMN_NAME")
  private String columnName;
  /** 数据类型 */
  @TableField("DATA_TYPE")
  private String dataType;
  /** 字段默认值 */
  @TableField("EXTRA")
  private String extra;
  /** 键类型 */
  @TableField("COLUMN_KEY")
  private String columnKey;
  /** 是否允许为空 */
  @TableField("IS_NULLABLE")
  private String isNullable;
  /** 字段备注 */
  @TableField("COLUMN_COMMENT")
  private String columnComment;
  /**
   * 排序字段
   */
  @TableField("ORDINAL_POSITION")
  private long ordinalPosition;



}
