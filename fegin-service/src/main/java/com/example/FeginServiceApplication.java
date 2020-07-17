package com.example;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import com.example.service.RemoteService;
import com.example.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: zhouyuyang
 * @Date: 2020/7/15 16:32
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class FeginServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeginServiceApplication.class, args);
    }

    @Autowired
    private RemoteService remoteService;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hello-fegin")
    public String helloFegin(){
        return remoteService.hello();
    }

    @GetMapping("/hello-nacos")
    public String helloNacos(){
        return restTemplate.getForObject("http://nacos-service/hello-nacos", String.class);
    }

    @GetMapping("/hello")
    public String hello(){
        return restTemplate.getForObject("http://nacos-service/hello", String.class);
    }

    /**
     * 开启Sentinel对RestTemplate的支持
     * @return
     */
    @Bean
    @LoadBalanced
    @SentinelRestTemplate(blockHandler = "handleException", blockHandlerClass = ExceptionUtil.class)
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
