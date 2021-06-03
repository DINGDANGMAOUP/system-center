package com.yinlu.system.module.builder.utils;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author dzhao1
 */
public class UpperCamelCaseUtil {
  public static String build(String str){
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
    return sbr.toString();
  }

}
