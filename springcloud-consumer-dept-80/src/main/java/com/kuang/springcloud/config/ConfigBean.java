package com.kuang.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author meditat0r
 * @create 2021/11/25 16:46
 */
@Configuration
public class ConfigBean {
    // @Configuration -- spring applicationContext.xml

    /**
     * Ribbon配置负载均衡实现RestTemplate
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
