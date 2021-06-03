package com.yinlu.system.module.builder.handler;

import com.yinlu.system.module.builder.constants.AutoCodeConstants;
import java.io.File;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/** @author dzhao1 */
@Component
@Slf4j
public class InitCacheHandler {
  @PostConstruct
  private void init() {
    // 初始化缓存目录
    File cache = new File(AutoCodeConstants.CACHE_INIT);
    log.info("开始初始化cache缓存目录");
    log.info("输出路径：{}", AutoCodeConstants.CACHE_INIT);
    if (cache.exists()) {
      log.warn("cache缓存目录已存在,跳过初始化。。。。。。。。。。。");
    } else {
      cache.mkdirs();
      log.info("cache缓存目录初始化成功。。。。。。。。。。。");
    }
  }
}
