package com.lkl.nacos;

//import com.alibaba.cloud.nacos.NacosConfigProperties;
import com.lkl.nacos.util.StartListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;

@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling
public class MyNacosTest {
    public static void main(String[] args){
//        SpringApplication.run(MyNacosTest.class,args);
        SpringApplication application = new SpringApplication(MyNacosTest.class);
        application.addListeners(new StartListener());
        application.run(args);
    }
}
