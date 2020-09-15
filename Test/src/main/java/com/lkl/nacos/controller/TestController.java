package com.lkl.nacos.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
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

    @ResponseBody
    @RequestMapping("getValue")
    public String getValue(){

        try (Entry entry = SphU.entry(Constant.SENTINEL_SOURCE_NAME_HELLO_WORLD)) {
            // Your business logic here.
            System.out.println("==========成功通过哨兵=========");
            return testValue;
        } catch (BlockException e) {
            // Handle rejected request.
            System.out.println("===========被哨兵拦截======");
            e.printStackTrace();
            return "failed by sentinel";
        }
    }
}
