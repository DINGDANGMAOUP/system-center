package com.yinlu.system.module.builder.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 文件后缀
 *
 * @author dzhao1
 */
@Getter
@AllArgsConstructor
public enum FileType {
  //  java
  JAVA(".java"),
  //  xml
  XML(".xml"),
  //  yml
  YML(".yml"),
  //  txt
  TXT(".txt"),
  //  ftl
  FTL(".ftl");
  /** 文件后缀 */
  private final String suffix;
}
