package com.yinlu.system.module.builder.constants;

import java.io.File;

/**
 * 系统常量管理
 * @author dzhao1
 */
public interface AutoCodeConstants {
  String MYSQL_TABLE_INFO_SQL="SHOW FULL FIELDS FROM %s";
  /**
   * 当前根目录
   */
  String CURRENT_PATH=System.getProperty("user.dir");
  /**
   * groupId
   */
  String GROUP_ID="com.yinlu";
  String PROJECT_DIR_PREFIX="com/yinlu";
  /**
   * 缓存目录
   */
  String CACHE_PATH="cache";
  /**
   * 初始化绝对路径 cache
   */
  String CACHE_INIT=AutoCodeConstants.CURRENT_PATH+ File.separator+AutoCodeConstants.CACHE_PATH;
  /**
   * 编码规则
   */
  String ENCODE="UTF-8";
}
