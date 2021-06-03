package com.yinlu.system.module.builder.handler;

import com.yinlu.system.module.builder.constants.AutoCodeConstants;
import com.yinlu.system.module.builder.pojo.dto.PathDTO;
import java.io.File;

/** @author dzhao1 */
public class PathHandler {

  public static PathDTO build(String projectName) {
    String projectRootPath = AutoCodeConstants.CACHE_INIT + File.separator + projectName;
    projectName = projectName.replaceAll("-", "/");
    String projectDir = AutoCodeConstants.PROJECT_DIR_PREFIX + File.separator + projectName;
    String mainPath = projectRootPath + "/src/main";
    String javaPath = mainPath + "/java" + File.separator + projectDir;
    String staticPath = mainPath + "/resources/static";
    String templatesPath = mainPath + "/resources/templates";
    String testPath = projectRootPath + "/src/test/java" + File.separator + projectDir;
    return PathDTO.builder()
        .projectRootPath(projectRootPath)
        .projectDir(projectDir)
        .mainPath(mainPath)
        .javaPath(javaPath)
        .staticPath(staticPath)
        .templatesPath(templatesPath)
        .testPath(testPath)
        .build();
  }
}
