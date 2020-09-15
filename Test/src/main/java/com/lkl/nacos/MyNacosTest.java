package com.lkl.nacos;

import com.lkl.nacos.util.StartListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.ArrayList;

@SpringBootApplication
@EnableDiscoveryClient
public class MyNacosTest {
    public static void main(String[] args){
//        SpringApplication.run(MyNacosTest.class,args);
        SpringApplication application = new SpringApplication(MyNacosTest.class);
        application.addListeners(new StartListener());
        application.run(args);
    }
}
