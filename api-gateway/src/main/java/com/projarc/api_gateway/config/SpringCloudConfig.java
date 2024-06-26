package com.projarc.api_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        System.out.println("Entrou no gatewayRoutes");
        return builder.routes()
                .route(r -> r.path("/servcad/assinaturas/assinvalida/**")
                        .uri("lb://api-cache"))
                .build();
    }
}
