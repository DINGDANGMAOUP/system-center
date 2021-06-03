package com.yinlu.system.module.builder.handler.directory;


import com.yinlu.system.module.builder.pojo.dto.PathDTO;
import java.io.File;


/**
 * 初始化project目录
 * @author dzhao1
 */
public class InitDirHandler {
  public static void init(PathDTO pathDTO)  {
    String[] dirArr={pathDTO.getJavaPath(),pathDTO.getStaticPath(),pathDTO.getTemplatesPath(),pathDTO.getTestPath()};
    for (String dir : dirArr) {
      new File(dir).mkdirs();
    }
  }


}
