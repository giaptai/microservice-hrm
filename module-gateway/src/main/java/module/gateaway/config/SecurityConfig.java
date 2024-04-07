//package module.gateaway.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.HttpStatusEntryPoint;
//import org.springframework.security.web.server.DelegatingServerAuthenticationEntryPoint;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//@EnableWebFluxSecurity
//public class SecurityConfig {
//    @Bean
//    public SecurityWebFilterChain filterChain(ServerHttpSecurity security) {
//        security.authorizeExchange(
//                        auth -> auth
//                                .pathMatchers("/api/v1/dan-toc").hasAuthority("ADMIN")
//                                .anyExchange().authenticated()
//                ).httpBasic(withDefaults());
//        return security.build();
//    }
////    @Bean
////    public SecurityFilterChain filterChain2(HttpSecurity security ) throws Exception {
////        security.authorizeHttpRequests(
////                config->config
////                        .requestMatchers("/api/v1/dan-toc").hasAuthority("ADMIN")
////                        .anyRequest().permitAll()
////        );
////        return security.build();
////    }
//}
