package module.gateaway;

import io.jsonwebtoken.Claims;
import module.gateaway.jwt.JWTUtilities;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RefreshScope
public class AuthenticationFilter implements GatewayFilter {
    private JWTUtilities jwtUtilities;

    public AuthenticationFilter(JWTUtilities jwtUtilities) {
        this.jwtUtilities = jwtUtilities;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ApplicationContext context = exchange.getApplicationContext();
        Mono<?> principal = exchange.getPrincipal();
        ServerHttpRequest request = exchange.getRequest();
        if (this.isAuthMissing(request)) {
            return this.onError(exchange, HttpStatus.UNAUTHORIZED);
        }
        final String token = this.getAuthHeader(request).substring(7);
        if (!jwtUtilities.isTokenValid(token)) {
            return this.onError(exchange, HttpStatus.FORBIDDEN);
        }
        this.updateRequest(exchange, token);
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

    private void updateRequest(ServerWebExchange exchange, String token) {
        Claims claims = jwtUtilities.extractAllClaims(token);
        exchange.getRequest()
                .mutate()
                .header("username-gateway", String.valueOf(claims.get("sub")))
                .header("role", String.valueOf(claims.get("role")))
                .build();
    }
}
