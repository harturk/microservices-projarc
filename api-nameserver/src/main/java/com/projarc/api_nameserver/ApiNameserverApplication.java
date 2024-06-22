package com.projarc.api_nameserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ApiNameserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiNameserverApplication.class, args);
    }

}
