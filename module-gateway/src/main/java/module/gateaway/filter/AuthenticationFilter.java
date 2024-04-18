package module.gateaway.filter;

import io.jsonwebtoken.Claims;
import module.gateaway.jwt.JWTUtilities;
import module.gateaway.router.AdminRouterValid;
import module.gateaway.router.EmployeeRouterValid;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@RefreshScope
public class AuthenticationFilter implements GatewayFilter {
    private final JWTUtilities jwtUtilities;
    private final AdminRouterValid adminRouterValid;
    private final EmployeeRouterValid employeeRouterValid;

    public AuthenticationFilter(JWTUtilities jwtUtilities, AdminRouterValid adminRouterValid, EmployeeRouterValid employeeRouterValid) {
        this.jwtUtilities = jwtUtilities;
        this.adminRouterValid = adminRouterValid;
        this.employeeRouterValid = employeeRouterValid;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        if (adminRouterValid.isSecured.test(request)) {
            if (this.isAuthMissing(request)) {
                return this.onError(exchange, HttpStatus.UNAUTHORIZED);
            }
            final String token = this.getAuthHeader(request).substring(7);
            Claims claims = jwtUtilities.extractAllClaims(token);
//            boolean role = claims.get("role").toString().equalsIgnoreCase("ADMIN");
//            boolean tokenValid = jwtUtilities.isTokenValid(token);
            if (!jwtUtilities.isTokenValid(token) || !claims.get("role").equals("ADMIN")) {
                return this.onError(exchange, HttpStatus.FORBIDDEN);
            }
            this.updateRequest(exchange, claims);
            return chain.filter(exchange);
        }
        if (employeeRouterValid.isSecured.test(request)) {
            if (this.isAuthMissing(request)) {
                return this.onError(exchange, HttpStatus.UNAUTHORIZED);
            }
            final String token = this.getAuthHeader(request).substring(7);
            Claims claims = jwtUtilities.extractAllClaims(token);
            if (!jwtUtilities.isTokenValid(token) || !claims.get("role").equals("EMPLOYEE")) {
                return this.onError(exchange, HttpStatus.FORBIDDEN);
            }
            this.updateRequest(exchange, claims);
            return chain.filter(exchange);
        }
        return chain.filter(exchange);
    }

    private Mono<Void> onError(ServerWebExchange exchange, HttpStatus httpStatus) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(httpStatus);
        return response.setComplete();
    }

    private String getAuthHeader(ServerHttpRequest request) {
        return request.getHeaders().getOrEmpty("Authorization").get(0);
    }

    private boolean isAuthMissing(ServerHttpRequest request) {
        return !request.getHeaders().containsKey("Authorization");
    }

    private void updateRequest(ServerWebExchange exchange, Claims claims) {
        exchange.getRequest()
                .mutate()
                .header("username-gateway", String.valueOf(claims.get("sub")))
                .header("role", String.valueOf(claims.get("role")))
                .header("taiKhoanId", String.valueOf(claims.get("taiKhoanId")))
                .build();
    }
}
