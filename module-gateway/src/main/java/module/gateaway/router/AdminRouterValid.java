package module.gateaway.router;


import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class AdminRouterValid {
    public static final List<String> adminApiEndpoints = List.of(
            "/api/v1/ca-nhan/tai-khoan",
            "/api/v1/nhan-vien/ho-so",
            "/api/v1/nhan-vien/tai-khoan",
            "/api/v1/khen-thuong",
            "/api/v1/kien-thuc-an-ninh-quoc-phong",
            "/api/v1/ky-luat",
            "/api/v1/lam-viec-cho-che-do-cu",
            "/api/v1/lam-viec-o-nuoc-ngoai",
            "/api/v1/luong-ban-than",
            "/api/v1/ly-luan-chinh-tri",
            "/api/v1/nghiep-vu-chuyen-nganh",
            "/api/v1/ngoai-ngu",
            "/api/v1/phu-cap-khac",
            "/api/v1/quan-he-gia-dinh",
            "/api/v1/qua-trinh-cong-tac",
            "/api/v1/tin-hoc"
    );
    public Predicate<ServerHttpRequest> isSecured =
            request -> adminApiEndpoints
                    .stream()
                    .anyMatch(uri -> request.getURI().getPath().contains(uri));
}
