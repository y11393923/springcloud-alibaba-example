package com.example.api;

import org.apache.dubbo.config.annotation.Service;

/**
 * @Author: zhouyuyang
 * @Date: 2020/7/16 11:02
 */
@Service
public class RemoteServiceImpl implements RemoteService {

    @Override
    public String hello(String name) {
        return "hello " + name;
    }
}
