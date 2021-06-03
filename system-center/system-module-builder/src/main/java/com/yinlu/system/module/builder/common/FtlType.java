package com.yinlu.system.module.builder.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 模板分类
 *
 * @author dzhao1
 */
@Getter
@AllArgsConstructor
public enum FtlType {
  //  java
  JAVA("java"),
  //  pom
  POM("pom"),
  //  resources
  RESOURCES("resources"),
  //  test
  TEST("test");
  /** 包路径 */
  private final String path;
}
