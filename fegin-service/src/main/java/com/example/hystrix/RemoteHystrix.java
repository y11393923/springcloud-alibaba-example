package com.example.hystrix;

import com.example.service.RemoteService;
import org.springframework.stereotype.Component;

/**
 * @Author: zhouyuyang
 * @Date: 2020/7/15 16:37
 */
@Component
public class RemoteHystrix implements RemoteService {

    @Override
    public String helloNacos() {
        return "请稍后重试";
    }

    @Override
    public String hello() {
        return "请稍后重试";
    }
}
