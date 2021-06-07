package com.yinlu.system.module.builder.utils;

/** @author dzhao1 */
public class UpperCamelCaseUtil {
  public static String build(String str) {
    char[] chars = str.toCharArray();
    StringBuilder sbr = new StringBuilder();
    boolean flag = true;
    for (char s : chars) {
      if (flag) {
        sbr.append(Character.toUpperCase(s));
        flag = false;
      } else if (s == '-') {
        flag = true;
      } else {
        sbr.append(s);
        flag = false;
      }
    }
    return sbr.toString();
  }
}
