package com.projarc.api_cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ApiCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiCacheApplication.class, args);
    }

}
