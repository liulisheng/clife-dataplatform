package com.clife.dataplatform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.clife.dataplatform.dao")
public class BusinessBootstrap {
    public static void main(String[] args) {
       SpringApplication.run(BusinessBootstrap.class, args);
//        new SpringApplicationBuilder(BusinessBootstrap.class)
//                .web(WebApplicationType.NONE)
//                .run(args);
    }

}
