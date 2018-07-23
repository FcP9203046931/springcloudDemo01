package com.bdqn.springcloud.controller;

import com.bdqn.springcloud.entity.Dept;
import com.bdqn.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long id){
        Dept dept = deptService.findById(id);
        if(dept == null){
            throw new RuntimeException("该ID:"+id+"没有相对应的东西");
        }
        return dept;
    }
    public Dept processHystrix_Get(@PathVariable("id") Long id){
        Dept dept =new Dept();
        dept.setDeptNo(id);
        dept.setdName("该ID:"+id+"没有对应的信息,null--@HystriCommand");
        return dept;
    }
}
