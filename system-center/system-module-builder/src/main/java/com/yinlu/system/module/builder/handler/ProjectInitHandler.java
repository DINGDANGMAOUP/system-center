package com.yinlu.system.module.builder.handler;

import com.yinlu.system.module.builder.config.FileBuildConfig;
import com.yinlu.system.module.builder.handler.directory.InitDirHandler;
import com.yinlu.system.module.builder.handler.file.InitFileHandler;
import com.yinlu.system.module.builder.pojo.dto.PathDTO;
import com.yinlu.system.module.builder.pojo.vo.TemplateBuildInfoVO;
import freemarker.template.TemplateException;
import java.io.IOException;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author dzhao1
 */
@Component
@Slf4j
public class ProjectInitHandler {
  @Resource
  InitFileHandler initFileHandler;
  public PathDTO execute(FileBuildConfig fileBuildConfig, TemplateBuildInfoVO templateBuildInfoVO) throws IOException, TemplateException {
    PathDTO build = PathHandler.build(templateBuildInfoVO.getProjectName());
    InitDirHandler.init(build);
    initFileHandler.init(build,fileBuildConfig,templateBuildInfoVO);
    return build;
  }

}
