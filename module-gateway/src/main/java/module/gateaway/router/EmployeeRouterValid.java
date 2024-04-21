package module.gateaway.router;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class EmployeeRouterValid {
    public static final List<String> adminApiEndpoints = List.of(
            "/api/v1/ca-nhan/ho-so",
            "/api/v1/ca-nhan/khen-thuong",
            "/api/v1/ca-nhan/kien-thuc-an-ninh-quoc-phong",
            "/api/v1/ca-nhan/ky-luat",
            "/api/v1/ca-nhan/lam-viec-cho-che-do-cu",
            "/api/v1/ca-nhan/lam-viec-o-nuoc-ngoai",
            "/api/v1/ca-nhan/luong-ban-than",
            "/api/v1/ca-nhan/ly-luan-chinh-tri",
            "/api/v1/ca-nhan/nghiep-vu-chuyen-nganh",
            "/api/v1/ca-nhan/ngoai-ngu",
            "/api/v1/ca-nhan/phu-cap-khac",
            "/api/v1/ca-nhan/quan-he-gia-dinh",
            "/api/v1/ca-nhan/qua-trinh-cong-tac",
            "/api/v1/ca-nhan/tin-hoc"
    );
    public Predicate<ServerHttpRequest> isSecured =
            request -> adminApiEndpoints
                    .stream()
                    .anyMatch(uri -> request.getURI().getPath().contains(uri));
}
