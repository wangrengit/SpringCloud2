package com.wuwei.controller;

import com.wuwei.pojo.Dept;
import com.wuwei.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {
    @Autowired
    FeignService feignService;

    //添加部门
    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return feignService.addDept(dept);
    }
    //根据id获取部门
    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") long id){

        return feignService.queryById(id);
    }
    //获取所有部门
    @RequestMapping("/consumer/dept/list")
    public List<Dept> getAll(){

        return feignService.queryAll();
    }
}
