package com.wuwei.dao;

import com.wuwei.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptDao {
    public  boolean addDept(Dept dept);
    public  Dept queryById(long deptno);
    public List<Dept> queryAll();
}
