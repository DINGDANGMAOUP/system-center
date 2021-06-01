package com.yinlu.system.generator.controller;

import cn.hutool.http.server.HttpServerResponse;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.yinlu.system.core.result.Result;
import com.yinlu.system.generator.model.SystemDataSource;
import com.yinlu.system.generator.pojo.dto.CodeGenDTO;
import com.yinlu.system.generator.pojo.dto.MavenArchTypeDTO;
import com.yinlu.system.generator.pojo.vo.DemoBuildInfoVO;
import com.yinlu.system.generator.service.SystemDataSourceService;
import com.yinlu.system.generator.utils.CodeGeneratorUtil;
import com.yinlu.system.generator.utils.MavenUtil;
import com.yinlu.system.generator.utils.ZipUtils;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** @author dzhao1 */
@Slf4j
@RestController
@Api(tags = "项目生产打包控制层")
@RequestMapping("/gen")
public class GenerateController {

  @Resource
  SystemDataSourceService systemDataSourceService;
  @Resource
  CodeGeneratorUtil codeGeneratorUtil;
  @PostMapping("produce")
  public Result produce(@RequestBody DemoBuildInfoVO demoBuildInfoVO , HttpServerResponse response)
      throws IOException, InterruptedException {
    String author = demoBuildInfoVO.getAuthor();
    String modelName = demoBuildInfoVO.getModelName();
    String sourceName = demoBuildInfoVO.getSourceName();
    String tableName = demoBuildInfoVO.getTableName();
    SystemDataSource ds = systemDataSourceService.getOne(
        Wrappers.<SystemDataSource>lambdaQuery().eq(SystemDataSource::getSourceName, sourceName));

    MavenArchTypeDTO mavenArchTypeDTO =
        MavenArchTypeDTO.builder()
            .archetypeGroupId("com.yinlu")
            .archetypeArtifactId("code-generator-archetype")
            .archetypeCatalog("local")
            .demoGroupId("com.yinlu")
            .demoArtifactId(modelName)
            .demoVersion("1.0.0")
            .buildPath("D:\\a")
            .build();
    MavenUtil.execute(mavenArchTypeDTO);
    CodeGenDTO build = CodeGenDTO.builder().mavenArchTypeDTO(mavenArchTypeDTO).systemDataSource(ds)
        .build();
    codeGeneratorUtil.execute(build);
    String zipPath = mavenArchTypeDTO.getBuildPath() + File.separator + mavenArchTypeDTO.getDemoArtifactId();
    String buildZip=zipPath+".zip";
    FileOutputStream fileOutputStream = new FileOutputStream(buildZip);
    log.info(buildZip);
    ZipUtils.toZip(zipPath,fileOutputStream,true);
    response.write(new File(buildZip));
    fileOutputStream.close();
    return Result.success();
  }
}
