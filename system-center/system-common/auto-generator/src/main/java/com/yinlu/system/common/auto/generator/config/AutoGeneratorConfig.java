package com.yinlu.system.common.auto.generator.config;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** @author dzhao1 */
@Configuration
public class AutoGeneratorConfig {

  /**
   * 代码生成器
   *
   * @return 代码生成器Bean
   */
  @Bean
  AutoGenerator AutoGenerator() {
    return new AutoGenerator()
        .setGlobalConfig(GlobalConfig())
        .setDataSource(DataSourceConfig())
        .setPackageInfo(PackageConfig())
        .setStrategy(StrategyConfig())
        .setTemplate(templateConfig())
        .setTemplateEngine(new FreemarkerTemplateEngine());
  }

  /**
   * 全局配置
   *
   * @return 全局配置Bean
   */
  @Bean
  GlobalConfig GlobalConfig() {
    return new GlobalConfig();
  }

  /**
   * 数据源配置
   *
   * @return 数据源Bean
   */
  @Bean
  DataSourceConfig DataSourceConfig() {
    return new DataSourceConfig();
  }

  /**
   * 包配置
   *
   * @return 包Bean
   */
  @Bean
  PackageConfig PackageConfig() {
    return new PackageConfig();
  }

  /**
   * 策略配置
   *
   * @return 策略Bean
   */
  @Bean
  StrategyConfig StrategyConfig() {
    return new StrategyConfig();
  }

  /**
   * 配置模板
   * @return 配置模板Bean
   */
  @Bean
  TemplateConfig templateConfig(){
    return new TemplateConfig();
  }
  /**
   * 待定 自定义配置器
   *
   * @return 自定义配置器
   */
  //  @Bean
  //  InjectionConfig InjectionConfig(){
  //    return new InjectionConfig() {
  //      @Override
  //      public void initMap() {
  //
  //      }
  //    };
  //  }
}
