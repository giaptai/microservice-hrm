package module.gateaway.config;

import module.gateaway.filter.AuthenticationFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    private final AuthenticationFilter filter;

    public GatewayConfig(AuthenticationFilter filter) {
        this.filter = filter;
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("ho-so-id",
                        pred -> pred.path("/api/v1/ho-so/**",
                                        "/api/v1/nhan-vien/ho-so/**",
                                        "/api/v1/ca-nhan/ho-so/**")
                                .filters(f -> f.filter(filter))
                                .uri("http://localhost:8081")
                )
                .route("ho-so-chu-tiet-id",
                        pred -> pred.path("/api/v1/ho-so/**",
                                        "/api/v1/**")
                                .filters(f -> f.filter(filter))
                                .uri("http://localhost:8083")
                )
                .route("dang-nhap-id",
                        pred -> pred.path("/api/v1/dang-nhap")
                                .uri("http://localhost:8082")
                )
                .route("tai-khoan-id",
                        pred -> pred.path("/api/v1/nhan-vien/tai-khoan/**",
                                        "/api/v1/ca-nhan/tai-khoan/**")
                                .filters(f -> f.filter(filter))
                                .uri("http://localhost:8082")
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
                                .uri("http://localhost:8080")
                )
                .build();
    }
}
