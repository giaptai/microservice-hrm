package module.gateaway.config;

import module.gateaway.filter.AuthenticationFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.cors.reactive.CorsUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Configuration
public class GatewayConfig {
    private final AuthenticationFilter filter;

    @Value("${gateway-port.cau-hinh}")
    private String cauHinhURL;

    @Value("${gateway-port.tai-khoan}")
    private String taiKhoanURL;

    @Value("${gateway-port.ho-so}")
    private String hoSoURL;

    @Value("${gateway-port.ho-so-chi-tiet}")
    private String hoSoChiTietURL;

    public GatewayConfig(AuthenticationFilter filter) {
        this.filter = filter;
    }

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

    @Bean
    public WebFilter corsFilter() {
        // https://stackoverflow.com/questions/63144563/how-to-disable-global-cors-config-in-spring-cloud-gateway-yml-config-to-allow-r
        final String ALLOWED_HEADERS = "x-requested-with, Content-Type, Content-Length, Authorization, credential, X-XSRF-TOKEN";
        final String ALLOWED_METHODS = "GET, PUT, POST, DELETE, OPTIONS, PATCH";
        final String MAX_AGE = "7200";
        return (ServerWebExchange ctx, WebFilterChain chain) -> {
            ServerHttpRequest request = ctx.getRequest();
            if (CorsUtils.isCorsRequest(request)) {
                ServerHttpResponse response = ctx.getResponse();
                HttpHeaders headers = response.getHeaders();
                headers.add("Access-Control-Allow-Origin", "*"); //only one is allowed
                headers.add("Access-Control-Allow-Methods", ALLOWED_METHODS);
                headers.add("Access-Control-Max-Age", MAX_AGE); //OPTION how long the results of a preflight request (that is the information contained in the Access-Control-Allow-Methods and Access-Control-Allow-Headers headers) can be cached.
                headers.add("Access-Control-Allow-Headers", ALLOWED_HEADERS);
                if (request.getMethod() == HttpMethod.OPTIONS) {
                    response.setStatusCode(HttpStatus.OK);
                    return Mono.empty();
                }
            }
            return chain.filter(ctx);
        };
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("ho-so-id",
                        pred -> pred.path("/api/v1/nhan-vien/ho-so/**",
                                        "/api/v1/ca-nhan/ho-so/**")
                                .filters(f -> f.filter(filter))
                                .uri(hoSoURL)
                )
                .route("dang-nhap-id",
                        pred -> pred.path("/api/v1/dang-nhap")
                                .uri(taiKhoanURL)
                )
                .route("tai-khoan-id",
                        pred -> pred.path("/api/v1/nhan-vien/tai-khoan/**",
                                        "/api/v1/ca-nhan/tai-khoan/**")
                                .filters(f -> f.filter(filter))
                                .uri(taiKhoanURL)
                )
                .route("cau-hinh-id",
                        pred -> pred.path("/api/v1/bac-luong/**",
                                        "/api/v1/cap-bac-loai-quan-ham-quan-doi/**",
                                        "/api/v1/chuc-danh-dang/**",
                                        "/api/v1/chuc-vu/**",
                                        "/api/v1/coquan-tochuc-donvi/**",
                                        "/api/v1/danh-hieu-nha-nuoc-phong/**",
                                        "/api/v1/dan-toc/**",
                                        "/api/v1/doi-tuong-chinh-sach/**",
                                        "/api/v1/hinh-thuc-khen-thuong/**",
                                        "/api/v1/hoc-ham/**",
                                        "/api/v1/loai-phu-cap/**",
                                        "/api/v1/moi-quan-he/**",
                                        "/api/v1/nhom-mau/**",
                                        "/api/v1/thanh-phan-gia-dinh/**",
                                        "/api/v1/ton-giao/**",
                                        "/api/v1/trinh-do-chuyen-mon/**",
                                        "/api/v1/trinh-do-giao-duc-pho-thong/**",
                                        "/api/v1/vi-tri-viec-lam/**",
                                        "/api/v1/loai-cong-chuc/**",
                                        "/api/v1/loai-vien-chuc/**",
                                        "/api/v1/nhom-cong-chuc/**",
                                        "/api/v1/nhom-vien-chuc/**",
                                        "/api/v1/he-so-luong-cong-chuc/**",
                                        "/api/v1/he-so-luong-vien-chuc/**",
                                        "/api/v1/ngach-cong-chuc/**",
                                        "/api/v1/ngach-vien-chuc/**"
                                )
                                .uri(cauHinhURL)
                )
//this route must be at last because the predicate path is "/api/v1/**" is match all the path above
                .route("ho-so-chi-tiet-id",
                        pred -> pred.path("/api/v1/{id}/**", "/api/v1/ca-nhan/**")
                                .filters(f -> f.filter(filter))
                                .uri(hoSoChiTietURL)
                )
                .build();
    }
}
