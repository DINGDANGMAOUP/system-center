package com.yinlu.system.dashboard.service;

import com.yinlu.system.dashboard.model.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 */
public interface SysMenuService extends IService<SysMenu> {

  List<SysMenu> findByUser( String userName);
}
