package com.wuwei.service;

import com.wuwei.pojo.Dept;

import java.util.List;

public interface DeptService {
      boolean addDept(Dept dept);
      Dept queryById(long id);
      List<Dept> queryAll();
}
