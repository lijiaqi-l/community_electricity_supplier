package com.sqds.ces.biz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CesBizApplication {

    public static void main(String[] args) {
        SpringApplication.run(CesBizApplication.class, args);
    }

}
