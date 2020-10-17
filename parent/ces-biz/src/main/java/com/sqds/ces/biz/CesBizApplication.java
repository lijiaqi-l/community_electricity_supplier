package com.sqds.ces.biz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.sqds.ces.biz.mapper")
@EnableCaching
@EnableTransactionManagement
public class CesBizApplication {

    public static void main(String[] args) {
        SpringApplication.run(CesBizApplication.class, args);
    }

}
