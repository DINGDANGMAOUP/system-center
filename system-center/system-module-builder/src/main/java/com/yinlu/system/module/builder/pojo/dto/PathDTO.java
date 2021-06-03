package com.yinlu.system.module.builder.pojo.dto;

import javax.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

/**
 * String projectRootPath= AutoCodeConstants.CACHE_PATH+File.separator+projectName;
 * demoName=demoName.replaceAll("-","/");
 * String projectDir=AutoCodeConstants.DEMO_DIR_PREFIX+File.separator+projectName;
 * String mainPath=projectRootPath+"/src/main";
 *
 * String javaPath =mainPath+"/java"+File.separator+projectDir;
 * String staticPath =mainPath+"/resources/static";
 * String templatesPath=mainPath+"/resources/templates";
 * String testPath=projectRootPath+"/src/test/java"+File.separator+projectDir;
 *
 * @author dzhao1 */
@Data
@Builder(toBuilder = true)
public class PathDTO {

  /**
   * 项目根路径
   */
  @NotBlank
  String projectRootPath;
  /**
   * base包相对路径
   */
  @NotBlank
  String projectDir;
  /**
   * main包绝对路径
   */
  @NotBlank
  String mainPath;

  /**
   * base包绝对路径
   */
  @NotBlank
  String javaPath;
  /**
   * static包绝对路径
   */
  @NotBlank
  String staticPath;
  /**
   * templates包绝对路径
   */
  @NotBlank
  String templatesPath;
  /**
   * test包绝对路径
   */
  @NotBlank
  String testPath;
}
