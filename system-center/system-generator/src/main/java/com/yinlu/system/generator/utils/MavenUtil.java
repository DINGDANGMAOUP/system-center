package com.yinlu.system.generator.utils;

import com.yinlu.system.generator.pojo.dto.MavenArchTypeDTO;
import java.io.File;
import java.io.IOException;
import jdk.jshell.JShell;

/**
 * @author dzhao1
 */
public class MavenUtil {
  public static void execute(MavenArchTypeDTO mavenArchTypeDTO)
      throws IOException, InterruptedException {
    String archetypeGroupId = mavenArchTypeDTO.getArchetypeGroupId();
    String archetypeArtifactId = mavenArchTypeDTO.getArchetypeArtifactId();
    String archetypeCatalog = mavenArchTypeDTO.getArchetypeCatalog();
    String demoGroupId = mavenArchTypeDTO.getDemoGroupId();
    String demoArtifactId = mavenArchTypeDTO.getDemoArtifactId();
    String demoPackage = demoGroupId+"."+demoArtifactId;
    String demoVersion = mavenArchTypeDTO.getDemoVersion();
    String buildPath = mavenArchTypeDTO.getBuildPath();

    // 生成原型  mvn archetype:generate
    String buildShell =
        "cd "
            + buildPath
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

    File file = new File(buildPath);
    if (!file.exists()) {
      file.mkdirs();
    }
    Process demoProcess = Runtime.getRuntime().exec(SystemCmdUtil.getCommand(buildShell));
    demoProcess.waitFor();
    demoProcess.destroy();
  }

}
