package com.bdqn.springcloud.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 配置类
 */
@Configuration
public class ConfigBean {
    @Bean
    @LoadBalanced//开启访问时自带负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    /**
     *开启负载均衡随机算法
     * @return
     */
    /*@Bean
    public IRule myRule(){

        //return new RoundRobinRule();//轮询算法 RoundRobinRule()
        //开启随机算法
        return new RandomRule();
    }*/
}
