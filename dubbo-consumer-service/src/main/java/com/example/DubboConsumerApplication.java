package com.example;

import com.example.api.RemoteService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhouyuyang
 * @Date: 2020/7/16 11:18
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class DubboConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class, args);
    }

    @Reference(check = false)
    private RemoteService remoteService;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", required = false) String name){
        return remoteService.hello(name);
    }
}
