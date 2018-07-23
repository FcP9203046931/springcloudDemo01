package com.bdqn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class springcloud_cofing_3344_app {
    public static void main(String[] args){
        SpringApplication.run(springcloud_cofing_3344_app.class,args);
    }
}
