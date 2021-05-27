package com.yinlu.system.generator.mapper;

import com.yinlu.system.generator.model.MysqlTableInfo;
import java.util.List;

/**
 * @author dzhao1
 */
public interface MysqlMapper {

  List<MysqlTableInfo> tables();
}
