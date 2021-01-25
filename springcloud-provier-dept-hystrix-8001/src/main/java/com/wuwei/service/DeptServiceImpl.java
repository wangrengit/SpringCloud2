package com.wuwei.service;

import com.wuwei.dao.DeptDao;
import com.wuwei.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl  implements DeptService{
    @Autowired
    DeptDao deptDao;

    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept queryById(long id) {
        Dept dept=deptDao.queryById(id);
        return dept;
    }

    @Override
    public List<Dept> queryAll() {
        List<Dept> dept=deptDao.queryAll();
        return dept;
    }
}
