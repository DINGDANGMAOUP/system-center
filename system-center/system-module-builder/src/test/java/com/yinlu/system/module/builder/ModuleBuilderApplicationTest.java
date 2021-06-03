package com.yinlu.system.module.builder;

import com.yinlu.system.module.builder.common.FtlTemplate;
import com.yinlu.system.module.builder.config.FileBuildConfig;
import com.yinlu.system.module.builder.handler.ProjectInitHandler;
import com.yinlu.system.module.builder.pojo.vo.TemplateBuildInfoVO;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class ModuleBuilderApplicationTest {
  @Resource
  ProjectInitHandler projectInitHandler;

  @Test
  void test(){
    String str="abc-def";
    char[] chars = str.toCharArray();
    StringBuilder sbr = new StringBuilder();
    boolean upFlag=true;
    for (char s : chars) {
      if (upFlag){
          sbr.append(Character.toUpperCase(s));
          upFlag=false;
      }else if (s=='-'){
          upFlag=true;
      }else {
        sbr.append(s);
        upFlag=false;
      }
    }
    log.info(sbr.toString());
//    Arrays.stream(str.split("-")).map((char1,char2)-> {
////      char1.equals("-") &&((char1.compareTo("A")>0) &&("z".compareTo(char1)))<0?1:2
//    })
//    log.info(FtlTemplate.application_prod.name());
  }
  @Test
  void eum() throws TemplateException, IOException {
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
            .projectName("example")
            .date(LocalDateTime.now())
            .description("test")
            .packageBaseParent("com.yinlu.system.example")
            .build();
    projectInitHandler.execute(build, buildInfo);
  }
}
