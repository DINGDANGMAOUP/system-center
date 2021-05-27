package com.yinlu.system.dashboard.controller;

import com.yinlu.system.core.result.Result;
import com.yinlu.system.dashboard.model.SystemDataSource;
import com.yinlu.system.dashboard.service.SystemDataSourceService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dzhao1
 */
@RestController
@RequestMapping("/datasource")
public class DataSourceController {
  @Resource
  SystemDataSourceService systemDataSourceService;

  @PutMapping("add")
  public Result add(@RequestBody SystemDataSource systemDataSource){
    boolean save = systemDataSourceService.save(systemDataSource);
    return Result.success(save);
  }
  @DeleteMapping("remove")
  public Result remove(@RequestBody SystemDataSource systemDataSource){
    boolean remove = systemDataSourceService.removeById(systemDataSource.getId());
    return Result.success(remove);
  }
  @PostMapping("update")
  public Result update(@RequestBody SystemDataSource systemDataSource){
    boolean update = systemDataSourceService.updateById(systemDataSource);
    return Result.success(update);
  }

  @GetMapping("list")
  public Result list(){
    List<SystemDataSource> list = systemDataSourceService.list();
    return Result.success(list);
  }

}
