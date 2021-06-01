package com.yinlu.system.generator.pojo.dto;

import com.yinlu.system.generator.model.TableName;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

/** @author dzhao1 */
@Data
@AllArgsConstructor
public class DataInfoDTO {
  private String sourceName;
  private List<TableName> tableNames;
}
