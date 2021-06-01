package com.yinlu.system.generator.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author dzhao1
 */
@Data
@ApiModel( "demo构建参数对象")
public class DemoBuildInfoVO {
  @ApiModelProperty(  "模块名")
  private String modelName;
  @ApiModelProperty(  "作者")
  private String author;
  @ApiModelProperty( "数据源")
  private String sourceName;
  @ApiModelProperty( value = "表名",reference = "多个表名用 , 分隔")
  private String tableName;
}
