package hrm.module.cauhinh;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

import static java.util.Arrays.asList;

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
                .packagesToScan("hrm.module.cauhinh.controllers")
                .build();
    }

    @Bean
    public OpenAPI openAPI() {
        Server gatewayServer = new Server();
        gatewayServer.setUrl("http://localhost:8888/api/v1");
        Server internalServer = new Server();
        internalServer.setUrl("http://localhost:8080/api/v1");
        return new OpenAPI().servers(List.of(gatewayServer, internalServer));
    }
//    @Bean
//    public WebMvcConfigurer webMvcConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedOrigins("http://localhost:8080/**", "http://localhost:8888/**")
//                        .allowedMethods("GET", "POST", "PATCH", "PUT", "DELETE")
//                        .allowedHeaders("*")
//                        .maxAge(3600);
//            }
//        };
//    }
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(List.of("http://localhost:8080", "http://localhost:8888"));
//        configuration.setAllowedMethods(asList("GET", "POST", "PATCH", "PUT", "DELETE"));
//        configuration.setAllowedHeaders(List.of("*")); //Keep in mind however that the CORS spec does not allow "*" when allowCredentials is set to true
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
}
