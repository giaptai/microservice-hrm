package module.gateaway.router;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class OpenRouterValid {
    public static final List<String> openApiEndpoints = List.of(
            "/api/v1/dang-nhap",
            "/api/v1/bac-luong",
            "/api/v1/cap-bac-loai-quan-ham-quan-doi",
            "/api/v1/chuc-danh-dang",
            "/api/v1/chuc-vu",
            "/api/v1/coquan-tochuc-donvi",
            "/api/v1/danh-hieu-nha-nuoc-phong",
            "/api/v1/dan-toc",
            "/api/v1/doi-tuong-chinh-sach",
            "/api/v1/hinh-thuc-khen-thuong",
            "/api/v1/hoc-ham",
            "/api/v1/loai-phu-cap",
            "/api/v1/moi-quan-he",
            "/api/v1/nhom-mau",
            "/api/v1/thanh-phan-gia-dinh",
            "/api/v1/ton-giao",
            "/api/v1/trinh-do-chuyen-mon",
            "/api/v1/trinh-do-giao-duc-pho-thong",
            "/api/v1/vi-tri-viec-lam",
            "/api/v1/loai-cong-chuc",
            "/api/v1/loai-vien-chuc",
            "/api/v1/nhom-cong-chuc",
            "/api/v1/nhom-vien-chuc",
            "/api/v1/he-so-luong-cong-chuc",
            "/api/v1/he-so-luong-vien-chuc",
            "/api/v1/ngach-cong-chuc",
            "/api/v1/ngach-vien-chuc/**"
    );
    public Predicate<ServerHttpRequest> isSecured =
            request -> openApiEndpoints
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));
}
