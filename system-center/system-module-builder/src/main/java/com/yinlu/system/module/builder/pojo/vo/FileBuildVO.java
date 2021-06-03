package com.yinlu.system.module.builder.pojo.vo;

import java.io.File;
import lombok.Builder;
import lombok.Data;

/**
 * 文件构建对象
 * @author dzhao1
 */
@Data
@Builder(toBuilder = true)
public class FileBuildVO {
 private File file;
 private String out;
}
