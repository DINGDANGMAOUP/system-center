package com.yinlu.system.generator.model;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/** @author dzhao1 */
@Data
public class TableName {
  @TableField("TABLE_NAME")
  private String tableName;
}
