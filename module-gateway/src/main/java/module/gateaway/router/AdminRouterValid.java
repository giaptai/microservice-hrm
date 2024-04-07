package module.gateaway.router;


import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class AdminRouterValid {
    public static final List<String> adminApiEndpoints = List.of(
            "/api/v1/nhan-vien/ho-so",
            "/api/v1/nhan-vien/tai-khoan",
            "/api/v1/khen-thuong"
    );
    public Predicate<ServerHttpRequest> isSecured =
            request -> adminApiEndpoints
                    .stream()
                    .anyMatch(uri -> request.getURI().getPath().contains(uri));
}
