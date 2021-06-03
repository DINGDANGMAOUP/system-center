package com.yinlu.system.module.builder.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.yinlu.system.core.result.Result;
import com.yinlu.system.module.builder.config.FileBuildConfig;
import com.yinlu.system.module.builder.constants.AutoCodeConstants;
import com.yinlu.system.module.builder.handler.code.GenericCodeHandler;
import com.yinlu.system.module.builder.handler.ProjectInitHandler;
import com.yinlu.system.module.builder.model.SystemDataSource;
import com.yinlu.system.module.builder.pojo.dto.PathDTO;
import com.yinlu.system.module.builder.pojo.vo.TemplateBuildInfoVO;
import com.yinlu.system.module.builder.service.SystemDataSourceService;
import com.yinlu.system.module.builder.utils.ZipUtils;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.time.LocalDateTime;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gen")
public class BuilderController {
  @Resource ProjectInitHandler projectInitHandler;
  @Resource GenericCodeHandler genericCodeHandler;
  @Resource SystemDataSourceService systemDataSourceService;

  @GetMapping("build")
  public Result build(@RequestParam("sourceName") String sourceName, HttpServletResponse response)
      throws TemplateException, IOException {

    SystemDataSource ds =
        systemDataSourceService.getOne(
            Wrappers.<SystemDataSource>lambdaQuery()
                .eq(SystemDataSource::getSourceName, sourceName));
    FileBuildConfig build =
        FileBuildConfig.builder()
            .Application(true)
            .ApplicationTest(true)
            .applicationYml(true)
            .applicationDevYml(true)
            .applicationTestYml(true)
            .applicationProdYml(true)
            .pom(true)
            .banner(true)
            .build();
    TemplateBuildInfoVO buildInfo =
        TemplateBuildInfoVO.builder()
            .author("kuroneko")
            .projectName("system-example")
            .date(LocalDateTime.now())
            .description("test")
            .packageBaseParent(AutoCodeConstants.GROUP_ID + ".system.example")
            .UCCName("SystemExample")
            .build();
    PathDTO path = projectInitHandler.execute(build, buildInfo);
    genericCodeHandler.execute(path, buildInfo, ds);
    ZipUtils.toZip(path.getProjectRootPath(), response.getOutputStream(), true);
    return Result.success();
  }
}
