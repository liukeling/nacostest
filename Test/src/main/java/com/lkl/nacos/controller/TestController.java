package com.lkl.nacos.controller;

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

    @ResponseBody
    @RequestMapping("getValue")
    public String getValue(){
        return testValue;
    }
}
