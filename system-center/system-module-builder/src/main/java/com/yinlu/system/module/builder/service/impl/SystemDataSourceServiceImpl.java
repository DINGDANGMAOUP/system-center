package com.yinlu.system.module.builder.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yinlu.system.module.builder.mapper.SystemDataSourceMapper;
import com.yinlu.system.module.builder.model.SystemDataSource;
import com.yinlu.system.module.builder.service.SystemDataSourceService;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
@DS("master")
public class SystemDataSourceServiceImpl extends ServiceImpl<SystemDataSourceMapper, SystemDataSource>
implements SystemDataSourceService {

}




