package com.yinlu.system.generator.pojo.dto;

import lombok.Builder;
import lombok.Data;

/**
 * maven生成项目所需参数对象
 * @author dzhao1 */
@Data
@Builder(toBuilder = true)
public class MavenArchTypeDTO {
  private String archetypeGroupId;
  private String archetypeArtifactId;
  private String archetypeCatalog;
  private String demoGroupId;
  private String demoArtifactId;
  private String demoPackage;
  private String demoVersion;
  private String buildPath;
}
