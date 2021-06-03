package com.yinlu.system.module.builder.common;

import java.io.File;
import lombok.AllArgsConstructor;

/**
 * 模板枚举
 *
 * @author dzhao1
 */
@AllArgsConstructor
public enum FtlTemplate {
  // application
  Application(FtlType.JAVA, "Application", FileType.FTL),
  // applicationTest
  ApplicationTest(FtlType.TEST, "ApplicationTest", FileType.FTL),
  pom(FtlType.POM,"pom",FileType.FTL),
  application(FtlType.RESOURCES,"application",FileType.FTL),
  application_dev(FtlType.RESOURCES,"application-dev",FileType.FTL),
  application_prod(FtlType.RESOURCES,"application-prod",FileType.FTL),
  application_test(FtlType.RESOURCES,"application-test",FileType.FTL),
  banner(FtlType.RESOURCES,"banner",FileType.FTL)
  ;
  /** 模板分类 */
  private final FtlType ftlType;
  /** 模板名 */
  private final String name;
  /** 模板文件类型 */
  private final FileType fileType;

  public String getPath() {
    return this.ftlType.getPath() + File.separator + this.name + this.fileType.getSuffix();
  }
  public String getName(){
    return this.name;
  }
}
