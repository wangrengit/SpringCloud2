package com.wuwei.controller;

import com.wuwei.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DeptConsumerController {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;

    //    private static final String REST_URL_PREFIX="http://localhost:8001";
//    负载均衡，这里就使用注册的服务名
    private static final String REST_URL_PREFIX="http://SPRINGCLOUD-PROVIDER-DEPT";

    //添加部门
    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
//        可以传map
//        Map<String,Object> hashMap=new HashMap<>();
//        hashMap.put("dname",dept.getDname());
//        可以传json
//        JSONObject json = new JSONObject();
//        json.put("age", 18);
//        这里传的是实体类
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }
    //根据id获取部门
    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") long id){
        List<ServiceInstance> instances=discoveryClient.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for(ServiceInstance instance:instances){
            System.out.println(instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }
    //获取所有部门
    @RequestMapping("/consumer/dept/list")
    public List<Dept> getAll(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }
}
