package com.yinlu.system.module.builder.constants;

/**
 * 目录常量
 * @author dzhao1
 */
public interface ProjectConstants {

  /**
   * 📂常量
   */
  String SRC_DIR="src";
  String MAIN_DIR="main";
  String JAVA_DIR="java";
  String RESOURCES_DIR="resources";
  String STATIC_DIR="static";
  String TEMPLATES_DIR="templates";

  /**
   * 目录结构常量
   */
  String PROJECT_ROOT_PATH= AutoCodeConstants.CACHE_PATH+"/{::projectName::}";
  String MAIN_PATH=PROJECT_ROOT_PATH+"/src/main";
  String JAVA_PATH=MAIN_PATH+"/java/{::projectDir::}";
  String STATIC_PATH=MAIN_PATH+"/resource/static";
  String TEMPLATES_PATH=MAIN_PATH+"/resource/templates";
  String TEST_PATH=PROJECT_ROOT_PATH+"/src/test/java/{::projectDir::}";

}
