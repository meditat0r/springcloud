package com.kuang.springcloud.service;

import com.kuang.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author meditat0r
 * @create 2021/11/26 16:07
 */

/**
 * 服务熔断：服务出现异常，服务端进行处理，返回相关信息
 * 服务降级：服务出现异常无法链接，客户端提前配置异常处理
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept queryById(Long id) {
                return new Dept().setDeptno(id)
                        .setDname("id=>"+id+",没有对应的信息,客户端提供了降级的信息@Hystrix")
                        .setDb_source("no this db_resource");
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }

            @Override
            public boolean addDept(Dept dept) {
                return false;
            }
        };
    }
}
