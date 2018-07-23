package com.bdqn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer//启动注册中心服务端，接受其他服务的注册
public class EurekeServer7003_app {
    public static void main(String[] args){
        SpringApplication.run(EurekeServer7003_app.class,args);
    }

}
