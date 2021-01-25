package com.wuwei;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class DeptTest {
    @Autowired
    RestTemplate restTemplate;

    @Test
    public void test01(){
        System.out.println(restTemplate.getClass());
    }
}
