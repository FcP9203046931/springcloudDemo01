package com.bdqn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient//微服务客户端
@EnableDiscoveryClient//微服务发现注解
public class DeptProvider_config_8001_app {
    public static void main(String[] args){
        SpringApplication.run(DeptProvider_config_8001_app.class,args);
    }

}
