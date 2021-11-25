package com.kuang.springcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import com.kuang.springcloud.service.DeptService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author meditat0r
 * @create 2021/11/25 15:32
 */
@RestController
public class DeptController {
    @Resource
    private DeptService deptService;

    // 获取一些配置的信息，得到具体的微服务
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable Long id){
        return deptService.queryById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> queryAll(){
        return deptService.queryAll();
    }

    @GetMapping("/dept/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        List<ServiceInstance> instances = discoveryClient.getInstances("springcloud-provider-dept");
        // 查看各instance的Host、Port、Url、ServiceId
        return this.discoveryClient;
    }
}
