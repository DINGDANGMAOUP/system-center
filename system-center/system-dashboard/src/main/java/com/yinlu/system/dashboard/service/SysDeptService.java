package com.yinlu.system.dashboard.service;

import com.yinlu.system.dashboard.model.SysDept;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 *
 */
public interface SysDeptService extends IService<SysDept> {

  List<SysDept> findTree();
}
