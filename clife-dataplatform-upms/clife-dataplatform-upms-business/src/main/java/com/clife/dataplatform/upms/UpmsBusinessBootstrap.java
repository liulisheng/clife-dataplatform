package com.clife.dataplatform.upms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.clife.dataplatform.upms.dao")
public class UpmsBusinessBootstrap {
    public static void main(String[] args) {
       SpringApplication.run(UpmsBusinessBootstrap.class, args);
//        new SpringApplicationBuilder(BusinessBootstrap.class)
//                .web(WebApplicationType.NONE)
//                .run(args);
    }

}
