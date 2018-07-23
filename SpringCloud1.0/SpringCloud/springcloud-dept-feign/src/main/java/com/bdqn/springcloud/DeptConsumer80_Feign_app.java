package com.bdqn.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.bdqn.springcloud")
@ComponentScan("com.bdqn.springcloud")
public class DeptConsumer80_Feign_app {
    public static void main(String[] args){
        SpringApplication.run(DeptConsumer80_Feign_app.class,args);
    }

}
