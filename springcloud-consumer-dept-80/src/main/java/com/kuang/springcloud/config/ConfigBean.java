package com.kuang.springcloud.config;

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

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
