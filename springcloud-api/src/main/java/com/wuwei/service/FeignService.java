package com.wuwei.service;

import com.wuwei.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT",fallbackFactory =DeptClientServiceFallbackFatory.class)
public interface FeignService {
    @GetMapping("/dept/add")
    boolean addDept(Dept dept);

    @GetMapping("/dept/get/{id}")
    Dept queryById(@PathVariable("id") long id);

    @GetMapping("/dept/list")
    List<Dept> queryAll();
}
