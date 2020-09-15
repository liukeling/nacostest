package com.lkl.nacos.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lkl.nacos.annotation.SentinelAnnotation;
import com.lkl.nacos.util.Constant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RefreshScope
@RequestMapping(value = "test")
public class TestController {

    @Value("${testVal:ee}")
    private String testValue;

    @SentinelAnnotation(sentinelName = Constant.SENTINEL_SOURCE_NAME_HELLO_WORLD
            ,failedVal = "failed by sentinel")
    @ResponseBody
    @RequestMapping("getValue")
    public String getValue(){
        return testValue;
    }
}
