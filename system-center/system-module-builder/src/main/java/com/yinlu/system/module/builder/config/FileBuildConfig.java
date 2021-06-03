package com.yinlu.system.module.builder.config;

import lombok.Builder;
import lombok.Data;

/**
 * 生成文件策略
 * @author dzhao1
 */
@Data
@Builder(toBuilder = true)
public class FileBuildConfig {
  private boolean Application;
  private boolean pom;
  private boolean applicationYml;
  private boolean applicationDevYml;
  private boolean applicationProdYml;
  private boolean applicationTestYml;
  private boolean banner;
  private boolean ApplicationTest;

}
