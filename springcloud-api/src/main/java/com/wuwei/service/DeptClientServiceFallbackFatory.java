package com.wuwei.service;

import com.wuwei.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallbackFatory  implements FallbackFactory {
    @Override
    public Object create(Throwable throwable) {
        return new FeignService() {
            @Override
            public boolean addDept(Dept dept) {
                return false;
            }
            @Override
            public Dept queryById(long id) {
                return new Dept().setDeptno(id)
                        .setDname("id->"+id+"没有对应的信息，客户端提供了降级的信息，这个服务现在已经被关闭");
            }
            @Override
            public List<Dept> queryAll() {
                return null;
            }
        };
    }
}
