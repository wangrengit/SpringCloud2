package com.wuwei.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wuwei.pojo.Dept;
import com.wuwei.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//提供Restful服务
@RestController
public class DeptController {
    @Autowired
    DeptService deptService;
    @PostMapping("/dept/add")
    public boolean addDept(@RequestBody Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod ="queryById_Error",commandProperties = {
           @HystrixProperty(name="circuitBreaker.enabled",value = "true"), /*是否开启断路器*/
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),/*请求次数*/
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),/*时间窗口期*/
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60") /*失败率达到多少后跳闸*/
    })
    public Dept queryById(@PathVariable("id") long id){
        Dept dept=deptService.queryById(id);
        if(dept == null){
            throw new RuntimeException();
        }
        return dept;
    }

    public Dept queryById_Error(@PathVariable("id") long id){
        return new Dept().setDeptno(id)
                         .setDname("id->"+id+"没有对应信息，null--@Hystrix")
                         .setDb_source("no this database in Mysql");
    }

    @GetMapping("/dept/list")
    public List<Dept> queryAll(){
        return deptService.queryAll();
    }
}
