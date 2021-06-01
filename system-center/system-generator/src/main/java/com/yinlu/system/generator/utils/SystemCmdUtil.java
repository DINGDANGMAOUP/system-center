package com.yinlu.system.generator.utils;

public class SystemCmdUtil {
  public static String[] getCommand(String command) {
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
