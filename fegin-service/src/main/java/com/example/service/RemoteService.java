package com.example.service;

import com.example.hystrix.RemoteHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: zhouyuyang
 * @Date: 2020/7/15 16:35
 */
@FeignClient(name = "nacos-service", fallback = RemoteHystrix.class)
public interface RemoteService {

    @GetMapping("/hello-nacos")
    String helloNacos();

    @GetMapping("/hello")
    String hello();
}
