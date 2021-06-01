package com.yinlu.system.generator.utils;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.yinlu.system.generator.model.SystemDataSource;
import com.yinlu.system.generator.pojo.dto.CodeGenDTO;
import com.yinlu.system.generator.pojo.dto.MavenArchTypeDTO;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @author dzhao1
 */
@Component
public class CodeGeneratorUtil {
  @Resource
  AutoGenerator autoGenerator;
  @Resource
  GlobalConfig globalConfig;
  @Resource
  DataSourceConfig dataSourceConfig;
  @Resource
  PackageConfig packageConfig;
  @Resource
  StrategyConfig strategy;
  @Resource
  TemplateConfig templateConfig;
  public void execute(CodeGenDTO codeGenDTO){
    MavenArchTypeDTO mavenArchTypeDTO = codeGenDTO.getMavenArchTypeDTO();
    SystemDataSource systemDataSource = codeGenDTO.getSystemDataSource();
    String demoArtifactId = mavenArchTypeDTO.getDemoArtifactId();
    String demoGroupId = mavenArchTypeDTO.getDemoGroupId();
    String buildPath = mavenArchTypeDTO.getBuildPath();
    String demoPath=buildPath+ File.separator+mavenArchTypeDTO.getDemoArtifactId();
    // 全局配置
    globalConfig.setOutputDir(buildPath+ File.separator+"src/main/java");
    globalConfig.setAuthor("kuroneko");
    globalConfig.setOpen(false);
    globalConfig.setSwagger2(true);
    globalConfig.setActiveRecord(true);
    globalConfig.setBaseResultMap(true);
    globalConfig.setEnableCache(true);

    // 数据源配置
    dataSourceConfig.setUrl(systemDataSource.getUrl());
    dataSourceConfig.setDriverName(systemDataSource.getDriver());
    dataSourceConfig.setUsername(systemDataSource.getUsername());
    dataSourceConfig.setPassword(systemDataSource.getPassword());
    // 包配置
    packageConfig.setModuleName(demoArtifactId);
    packageConfig.setParent(demoGroupId);
    packageConfig.setEntity("model");
    // 策略配置
    strategy.setNaming(NamingStrategy.underline_to_camel);
    strategy.setColumnNaming(NamingStrategy.underline_to_camel);
    strategy.setEntityLombokModel(true);
    strategy.setRestControllerStyle(true);
    strategy.setChainModel(true);
    strategy.setEntityTableFieldAnnotationEnable(true);
    // 公共父类
    // 写于父类中的公共字段
    strategy.setSuperEntityColumns("id");
//    strategy.setInclude("sys_user,sys_log");
    strategy.setControllerMappingHyphenStyle(true);
//    strategy.setTablePrefix("demo_");

    templateConfig.setXml(null);
    // 自定义配置
    InjectionConfig cfg = new InjectionConfig() {
      @Override
      public void initMap() {
        // to do nothing
      }
    };
    // 如果模板引擎是 freemarker
    String templatePath = "/templates/mapper.xml.ftl";
    // 自定义输出配置
    List<FileOutConfig> focList = new ArrayList<>();
    // 自定义配置会被优先输出
    focList.add(new FileOutConfig(templatePath) {
      @Override
      public String outputFile(TableInfo tableInfo) {
        // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
        return demoPath + "/src/main/resources/mapper/"
            + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
      }
    });
    cfg.setFileOutConfigList(focList);
    autoGenerator.setCfg(cfg);
    autoGenerator.execute();
  }

}
