package com.yinlu.system.dashboard.mapper;

import com.yinlu.system.dashboard.model.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Entity com.yinlu.system.dashboard.model.SysMenu
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

  List<SysMenu> findByUserName(@Param("userName") String userName);
}




