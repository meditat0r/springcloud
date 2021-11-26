package com.kuang.myRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author meditat0r
 * @create 2021/11/26 13:53
 */
@Configuration
public class KuangRule {

    @Bean
    public IRule diyRule(){
        return new RandomRule();
    }
}
