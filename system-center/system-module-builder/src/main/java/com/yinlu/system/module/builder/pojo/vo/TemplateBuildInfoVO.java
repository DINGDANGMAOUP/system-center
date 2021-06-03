package com.yinlu.system.module.builder.pojo.vo;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

/**
 * 模板填充对象
 *
 * @author dzhao1
 */
@Data
@Builder(toBuilder = true)
public class TemplateBuildInfoVO {
  private String projectName;
  private String author;
  private LocalDateTime date;
  private String description;
  private String packageBaseParent;
  /** 连接符转首字母大写参数 */
  private String UCCName;
}
