package com.example.config;

import com.alibaba.csp.sentinel.adapter.gateway.zuul.fallback.ZuulBlockFallbackManager;
import com.alibaba.csp.sentinel.adapter.gateway.zuul.filters.SentinelZuulErrorFilter;
import com.alibaba.csp.sentinel.adapter.gateway.zuul.filters.SentinelZuulPostFilter;
import com.alibaba.csp.sentinel.adapter.gateway.zuul.filters.SentinelZuulPreFilter;
import com.example.fallback.ZuulFallbackProvider;
import com.netflix.zuul.ZuulFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @Author: zhouyuyang
 * @Date: 2020/7/17 10:14
 */
@Configuration
public class ZuulConfig {

    @Bean
    public ZuulFilter sentinelZuulFilter(){
        // We can also provider the filter order in the constructor.
        return new SentinelZuulPreFilter();
    }

    @Bean
    public ZuulFilter sentinelZuulPostFilter() {
        return new SentinelZuulPostFilter();
    }

    @Bean
    public ZuulFilter sentinelZuulErrorFilter() {
        return new SentinelZuulErrorFilter();
    }

    /**
     * 注册 ZuulFallbackProvider
     */
    @PostConstruct
    public void doInit() {
        ZuulBlockFallbackManager.registerProvider(new ZuulFallbackProvider());
    }

}
