package com.yinlu.system.generator;

import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
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
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.yinlu.system.generator.controller.LoadController;
import com.yinlu.system.generator.mapper.MysqlMapper;
import com.yinlu.system.generator.model.SystemDataSource;
import com.yinlu.system.generator.model.TableName;
import com.yinlu.system.generator.service.SystemDataSourceService;
import com.yinlu.system.generator.utils.ZipUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.Resource;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class ApplicationTest {
@Resource
  LoadController loadController;
@Resource
MysqlMapper mapper;
@Resource
DataSource dataSource;



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

  @Resource
  SystemDataSourceService systemDataSourceService;
@Test
  void file() throws IOException {
  List<SystemDataSource> list = systemDataSourceService.list();
  log.info(list.toString());
//  String path="D:/a/s/c";
//  String file1=path+File.separator+"d.txt";
//    File dir = new File(path);
//    dir.mkdirs();
//  File file = new File(file1);
//  file.createNewFile();

  }

  @Test
  void test(){
    DynamicDataSourceContextHolder.push("YinLuDWQAS");
    List<TableName> yinLuDWQAS = mapper.listToTable("YinLuDWQAS");
    System.out.println(yinLuDWQAS.toString());
//    DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
//    log.info(ds.getCurrentDataSources().keySet().toString());
//    DynamicDataSourceContextHolder.push("kuroneko");
//    List<MysqlTableInfo> tableInfoList = mapper.listToTable("kuroneko");
//    log.info(kuroneko.toString());
//    Result now = loadController.now();
//    log.info(now.toString());
//    List<MysqlTableInfo> tables = mapper.tables();
//    tables.forEach(table->log.info(table.toString()));
  }
  @Test
  void maven() throws IOException, InterruptedException {
    //当前目录
//    String currentDirectory = System.getProperty("user.dir") + File.separator+"temp";
    String currentDirectory ="D:\\a";

    //archetypeGroupId
    String archetypeGroupId="com.yinlu";
    //archetypeArtifactId
    String archetypeArtifactId="code-generator-archetype";
    //archetypeCatalog
    String archetypeCatalog="local";
    //groupId
    String demoGroupId="com.demo";
    //artifactId
    String demoArtifactId="exam";
    //package
    String demoPackage=demoGroupId+"."+demoArtifactId;
    //version
    String demoVersion="1.0.0";
    // 生成原型  mvn archetype:generate
    String buildDemo =
        "cd "
            + currentDirectory
            + " &&  mvn archetype:generate \"-DinteractiveMode=false\" "
            + "\"-DarchetypeGroupId="
            + archetypeGroupId
            + "\" "
            + "\"-DarchetypeArtifactId="
            + archetypeArtifactId
            + "\" "
            + "\"-DarchetypeCatalog="
            + archetypeCatalog
            + "\" "
            + "\"-DgroupId="
            + demoGroupId
            + "\" "
            + "\"-DartifactId="
            + demoArtifactId
            + "\" "
            + "\"-Dpackage="
            + demoPackage
            + "\" "
            + "\"-Dversion="+demoVersion+"\" ";

// 生成项目后的根目录
    String demoPath=currentDirectory+File.separator+demoArtifactId;
    File file = new File(currentDirectory);
    if (!file.exists()) {
      file.mkdirs();
    }
    log.info(buildDemo);
    Process demoProcess = Runtime.getRuntime().exec(getCommand(buildDemo));
    demoProcess.waitFor();
    demoProcess.destroy();

//    生成通同业务代码
    // 全局配置
    globalConfig.setOutputDir(demoPath+File.separator+"src/main/java");
    globalConfig.setAuthor("kuroneko");
    globalConfig.setOpen(false);
    globalConfig.setSwagger2(true);
    globalConfig.setActiveRecord(true);
    globalConfig.setBaseResultMap(true);
    globalConfig.setEnableCache(true);
//    autoGenerator.setGlobalConfig(globalConfig);

    // 数据源配置
    dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/kuroneko?serverTimezone=UTC");
    dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
    dataSourceConfig.setUsername("root");
    dataSourceConfig.setPassword("root");
//    autoGenerator.setDataSource(dataSourceConfig);
    // 包配置
    packageConfig.setModuleName(demoArtifactId);
    packageConfig.setParent(demoGroupId);
    packageConfig.setEntity("model");
//    packageConfig.setXml("/src/main/java/resources");
//    autoGenerator.setPackageInfo(packageConfig);
    // 策略配置
    strategy.setNaming(NamingStrategy.underline_to_camel);
    strategy.setColumnNaming(NamingStrategy.underline_to_camel);
    strategy.setEntityLombokModel(true);
    strategy.setRestControllerStyle(true);
    strategy.setChainModel(true);
    strategy.setEntityTableFieldAnnotationEnable(true);
    templateConfig.setXml(null);
//    autoGenerator.setTemplate(templateConfig);
    // 公共父类
    // 写于父类中的公共字段
    strategy.setSuperEntityColumns("id");
//    strategy.setInclude("sys_user,sys_log");
    strategy.setControllerMappingHyphenStyle(true);
//    strategy.setTablePrefix("demo_");
//    autoGenerator.setStrategy(strategy);

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

//    打包zip

    String zipPath=currentDirectory+File.separator+demoArtifactId;
    String buildZip=zipPath+".zip";
    FileOutputStream fileOutputStream = new FileOutputStream(buildZip);
    log.info(buildZip);
    ZipUtils.toZip(zipPath,fileOutputStream,true);
    fileOutputStream.close();

  }


  @Test
  void gen(){

    // 全局配置
    globalConfig.setOutputDir("D:/a/demo/src/main/java");
    globalConfig.setAuthor("kuroneko");
    globalConfig.setOpen(false);
    globalConfig.setSwagger2(true);
    autoGenerator.setGlobalConfig(globalConfig);

    // 数据源配置
    dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/kuroneko?serverTimezone=UTC");
    dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
    dataSourceConfig.setUsername("root");
    dataSourceConfig.setPassword("root");
    autoGenerator.setDataSource(dataSourceConfig);

    // 包配置
    packageConfig.setModuleName("demo");
    packageConfig.setParent("com");
    autoGenerator.setPackageInfo(packageConfig);


    // 配置模板
//    templateConfig.setXml(null);
//    autoGenerator.setTemplate(templateConfig);

    // 策略配置
    strategy.setNaming(NamingStrategy.underline_to_camel);
    strategy.setColumnNaming(NamingStrategy.underline_to_camel);
    strategy.setEntityLombokModel(true);
    strategy.setRestControllerStyle(true);
    // 公共父类
    // 写于父类中的公共字段
    strategy.setSuperEntityColumns("id");
    strategy.setInclude("sys_user");
    strategy.setControllerMappingHyphenStyle(true);
    strategy.setTablePrefix("demo_");
    autoGenerator.setStrategy(strategy);
    autoGenerator.execute();

  }
  private static String[] getCommand(String command) {
    String os = System.getProperty("os.name");
    String shell = "/bin/bash";
    String c = "-c";
    if (os.toLowerCase().startsWith("win")) {
      shell = "cmd";
      c = "/c";
    }
    String[] cmd = {shell, c, command};
    return cmd;
  }
}
