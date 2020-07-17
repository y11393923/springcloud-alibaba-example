package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: zhouyuyang
 * @Date: 2020/7/15 15:44
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class NacosServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosServiceApplication.class, args);
    }

    @GetMapping("/hello-nacos")
    public String helloNacos(){
        return "你好，nacos";
    }

    @GetMapping("/hello")
    public String hello(HttpServletRequest request){
        return "hello port is : " + request.getLocalPort();
    }

}
