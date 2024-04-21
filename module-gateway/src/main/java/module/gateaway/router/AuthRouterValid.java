package module.gateaway.router;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class AuthRouterValid {
    public static final List<String> authApiEndpoints = List.of(
            "/api/v1/ca-nhan/tai-khoan"
    );
    public Predicate<ServerHttpRequest> isSecured =
            request -> authApiEndpoints
                    .stream()
                    .anyMatch(uri -> request.getURI().getPath().contains(uri));
}
