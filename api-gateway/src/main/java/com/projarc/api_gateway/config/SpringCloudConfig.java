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
        // Mapeia a rota para o serviço api-cache
        return builder.routes()
                .route(r -> r.path("/assinvalida/**")
                        .uri("lb://api-cache"))
                .build();
    }
}
