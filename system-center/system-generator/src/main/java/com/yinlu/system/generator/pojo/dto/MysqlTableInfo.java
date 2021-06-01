package com.yinlu.system.generator.pojo.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.yinlu.system.generator.model.MysqlTableField;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * mysql 表详情对象
 *
 * @author dzhao1
 */
@Data
@AllArgsConstructor
public class MysqlTableInfo {

  /** 表名 */
  @TableField("TABLE_NAME")
  private String tableName;
  /** 字段 */
  @TableField(exist = false)
  private List<MysqlTableField> columns;
}
