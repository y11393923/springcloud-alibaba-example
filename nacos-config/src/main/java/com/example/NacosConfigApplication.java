package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhouyuyang
 * @Date: 2020/7/15 17:13
 *
 * 在Nacos-Server中新建配置，其中Data ID它的定义规则是：${prefix}-${spring.profile.active}.${file-extension}
 *
 * prefix 默认为 spring.application.name 的值，也可以通过配置项 spring.cloud.nacos.config.prefix 来配置。
 * spring.profile.active 即为当前环境对应的 profile，可以通过配置项 spring.profile.active 来配置。
 * file-exetension 为配置内容的数据格式，可以通过配置项 spring.cloud.nacos.config.file-extension 来配置。目前只支持 properties 和 yaml 类型。
 * 注意：当 spring.profile.active 为空时，对应的连接符 - 也将不存在，dataId 的拼接格式变成prefix.{file-extension}
 */
@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
@RestController
public class NacosConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosConfigApplication.class, args);
    }

    @Value("${nacos.config}")
    private String config;

    @GetMapping("/getValue")
    public String getValue() {
        return config;
    }
}
