package com.yinlu.system.dashboard.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yinlu.system.dashboard.model.SysDept;
import com.yinlu.system.dashboard.service.SysDeptService;
import com.yinlu.system.dashboard.mapper.SysDeptMapper;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author dzhao1
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept>
implements SysDeptService{


  @Override
  public List<SysDept> findTree() {
    List<SysDept> sysDepts = new ArrayList<>();
    List<SysDept> depts = list();
    for (SysDept dept : depts) {
      if (dept.getParentId() == null || dept.getParentId() == 0) {
        dept.setLevel(0);
        sysDepts.add(dept);
      }
    }
    findChildren(sysDepts, depts);
    return sysDepts;
  }

  private void findChildren(List<SysDept> sysDepts, List<SysDept> depts) {
    for (SysDept sysDept : sysDepts) {
      List<SysDept> children = new ArrayList<>();
      for (SysDept dept : depts) {
        if (sysDept.getId() != null && sysDept.getId().equals(dept.getParentId())) {
          dept.setParentName(dept.getName());
          dept.setLevel(sysDept.getLevel() + 1);
          children.add(dept);
        }
      }
      sysDept.setChildren(children);
      findChildren(children, depts);
    }
  }
}




