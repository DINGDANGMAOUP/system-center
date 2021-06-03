package com.yinlu.system.module.builder.handler.file;


import com.yinlu.system.module.builder.common.FileType;
import com.yinlu.system.module.builder.common.FtlTemplate;
import com.yinlu.system.module.builder.config.FileBuildConfig;
import com.yinlu.system.module.builder.constants.AutoCodeConstants;
import com.yinlu.system.module.builder.pojo.dto.PathDTO;
import com.yinlu.system.module.builder.pojo.vo.FileBuildVO;
import com.yinlu.system.module.builder.pojo.vo.TemplateBuildInfoVO;
import com.yinlu.system.module.builder.utils.UpperCamelCaseUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

/**
 * 初始化java文件
 * @author dzhao1
 */
@Component
@Slf4j
public class InitFileHandler {
  @Resource
  Configuration configuration;

  public void init(PathDTO pathDTO, FileBuildConfig fileBuildConfig, TemplateBuildInfoVO templateBuildInfoVO)
      throws IOException, TemplateException {
    String javaPath = pathDTO.getJavaPath();
    String testPath = pathDTO.getTestPath();
    String resourcesPath = pathDTO.getMainPath()+File.separator+"resources";
    String projectRootPath = pathDTO.getProjectRootPath();
    List<FileBuildVO> fileBuilds=new ArrayList<>();
    if (fileBuildConfig.isApplication()){
      Template template = configuration.getTemplate(FtlTemplate.Application.getPath());
      String out = FreeMarkerTemplateUtils.processTemplateIntoString(template, templateBuildInfoVO);
      File file = new File(javaPath+File.separator+ templateBuildInfoVO.getUCCName()+FtlTemplate.Application.getName() + FileType.JAVA.getSuffix());
      fileBuilds.add(FileBuildVO.builder().file(file).out(out).build());
    }
    if (fileBuildConfig.isApplicationTest()){
      Template template = configuration.getTemplate(FtlTemplate.ApplicationTest.getPath());
      String out = FreeMarkerTemplateUtils.processTemplateIntoString(template, templateBuildInfoVO);
      File file = new File(testPath+File.separator+templateBuildInfoVO.getUCCName()+FtlTemplate.ApplicationTest.getName() + FileType.JAVA.getSuffix());
      fileBuilds.add(FileBuildVO.builder().file(file).out(out).build());
    }
    if (fileBuildConfig.isApplicationYml()){
      Template template = configuration.getTemplate(FtlTemplate.application.getPath());
      String out = FreeMarkerTemplateUtils.processTemplateIntoString(template, templateBuildInfoVO);
      File file = new File(resourcesPath+File.separator+FtlTemplate.application.getName() + FileType.YML.getSuffix());
      fileBuilds.add(FileBuildVO.builder().file(file).out(out).build());
    }
    if (fileBuildConfig.isApplicationDevYml()){
      Template template = configuration.getTemplate(FtlTemplate.application_dev.getPath());
      String out = FreeMarkerTemplateUtils.processTemplateIntoString(template, templateBuildInfoVO);
      File file = new File(resourcesPath+File.separator+FtlTemplate.application_dev.getName() + FileType.YML.getSuffix());
      fileBuilds.add(FileBuildVO.builder().file(file).out(out).build());
    }
    if (fileBuildConfig.isApplicationTestYml()){
      Template template = configuration.getTemplate(FtlTemplate.application_test.getPath());
      String out = FreeMarkerTemplateUtils.processTemplateIntoString(template, templateBuildInfoVO);
      File file = new File(resourcesPath+File.separator+FtlTemplate.application_test.getName() + FileType.YML.getSuffix());
      fileBuilds.add(FileBuildVO.builder().file(file).out(out).build());
    }
    if (fileBuildConfig.isApplicationProdYml()){
      Template template = configuration.getTemplate(FtlTemplate.application_prod.getPath());
      String out = FreeMarkerTemplateUtils.processTemplateIntoString(template, templateBuildInfoVO);
      File file = new File(resourcesPath+File.separator+FtlTemplate.application_prod.getName() + FileType.YML.getSuffix());
      fileBuilds.add(FileBuildVO.builder().file(file).out(out).build());
    }
    if (fileBuildConfig.isPom()){
      Template template = configuration.getTemplate(FtlTemplate.pom.getPath());
      String out = FreeMarkerTemplateUtils.processTemplateIntoString(template, templateBuildInfoVO);
      File file = new File(projectRootPath+File.separator+FtlTemplate.pom.getName() + FileType.XML.getSuffix());
      fileBuilds.add(FileBuildVO.builder().file(file).out(out).build());
    }
    if (fileBuildConfig.isBanner()){
      Template template = configuration.getTemplate(FtlTemplate.banner.getPath());
      String out = FreeMarkerTemplateUtils.processTemplateIntoString(template, templateBuildInfoVO);
      File file = new File(resourcesPath+File.separator+FtlTemplate.banner.getName() + FileType.TXT.getSuffix());
      fileBuilds.add(FileBuildVO.builder().file(file).out(out).build());
    }

    fileBuilds.forEach(build->{
      try {
        FileUtils.touch(build.getFile());
        FileUtils.writeStringToFile(build.getFile(), build.getOut(), AutoCodeConstants.CODING);
      } catch (IOException e) {
        e.printStackTrace();
      }
    });
  }
}
