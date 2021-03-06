package com.bdqn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer//启动注册中心服务端，接受其他服务的注册
public class EurekeServer_config_7001_app {
    public static void main(String[] args){
        SpringApplication.run(EurekeServer_config_7001_app.class,args);
    }

}
