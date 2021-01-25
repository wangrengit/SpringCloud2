package com.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WuRule {

    @Bean
    public IRule getRule(){
//        return  new RandomRule();  //这里返回的是系统自带的随机算法
        return new WuweiRandomRule();
    }
}
