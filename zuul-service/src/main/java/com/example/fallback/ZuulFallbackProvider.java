package com.example.fallback;

import com.alibaba.csp.sentinel.adapter.gateway.zuul.fallback.BlockResponse;
import com.alibaba.csp.sentinel.adapter.gateway.zuul.fallback.ZuulBlockFallbackProvider;
import com.alibaba.csp.sentinel.log.RecordLog;
import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @Author: zhouyuyang
 * @Date: 2020/7/17 10:13
 */
public class ZuulFallbackProvider implements ZuulBlockFallbackProvider {
    @Override
    public String getRoute() {
        return "*";
    }

    @Override
    public BlockResponse fallbackResponse(String route, Throwable cause) {
        RecordLog.info(String.format("[Sentinel DefaultBlockFallbackProvider] Run fallback route: %s", route));
        if (cause instanceof BlockException) {
            return new BlockResponse(429, "Sentinel block exception", route);
        } else {
            return new BlockResponse(500, "System Error", route);
        }
    }
}
