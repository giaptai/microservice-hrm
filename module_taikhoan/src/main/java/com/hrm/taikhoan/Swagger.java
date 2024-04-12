package com.hrm.taikhoan;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@SecurityScheme(
        name = "Bearer Authentication",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class Swagger {
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .packagesToScan("com.hrm.taikhoan.controller")
                .build();
    }

    @Bean
    public OpenAPI openAPI() {
        Server gatewayServer = new Server();
        gatewayServer.setUrl("http://localhost:8888/api/v1");
        Server internalServer = new Server();
        internalServer.setUrl("http://localhost:8082/api/v1");
        return new OpenAPI().servers(List.of(gatewayServer, internalServer));
    }
}
