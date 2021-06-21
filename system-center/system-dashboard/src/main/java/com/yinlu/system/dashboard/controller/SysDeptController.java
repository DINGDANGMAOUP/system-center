package com.yinlu.system.dashboard.controller;

import com.yinlu.system.core.result.Result;
import com.yinlu.system.dashboard.model.SysDept;
import com.yinlu.system.dashboard.service.SysDeptService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dzhao1
 */
@RestController
@RequestMapping("/dept")
public class SysDeptController {

  @Resource
  SysDeptService sysDeptService;

  @GetMapping("/list")
  public Result list(){
    List<SysDept> list = sysDeptService.list();
    return Result.success(list);
  }
}
