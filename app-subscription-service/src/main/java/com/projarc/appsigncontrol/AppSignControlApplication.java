package com.projarc.appsigncontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AppSignControlApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppSignControlApplication.class, args);
    }

}
