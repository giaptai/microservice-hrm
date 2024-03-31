package com.hrm.taikhoan.security;

import com.hrm.taikhoan.enums.RoleTaiKhoan;
import com.hrm.taikhoan.response.ResEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

import static java.util.Arrays.asList;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig implements WebMvcConfigurer {

    private final TaiKhoanUserDetailsService taiKhoanUserDetailsService;

    private final JWTAuthFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        security.cors(corsConfigurer -> corsConfigurer.configurationSource(corsConfigurationSource()))
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(configure ->
                        configure
                                .requestMatchers(HttpMethod.GET, "/ca-nhan/tai-khoan").hasAnyAuthority("ADMIN", "EMPLOYEE")
                                .requestMatchers(
                                        "/nhan-vien/**",
                                        "/tin-hoc/**",
                                        "/quan-he-gia-dinh/**",
                                        "/qua-trinh-cong-tac/**",
                                        "/phu-cap-khac/**",
                                        "/ngoai-ngu/**",
                                        "/nghiep-vu-chuyen-nganh/**",
                                        "/ly-luan-chinh-tri/**",
                                        "/luong-ban-than/**",
                                        "/lam-viec-o-nuoc-ngoai/**",
                                        "/lam-viec-cho-che-do-cu/**",
                                        "/ky-luat/**",
                                        "/kien-thuc-an-ninh-quoc-phong/**",
                                        "/khen-thuong/**").hasAuthority("ADMIN")
                                .requestMatchers("/ca-nhan/**").hasAuthority("EMPLOYEE")
                                .anyRequest().permitAll()
                )
                .logout(logout -> logout
//                                .logoutUrl("/dang-xuat").permitAll()
                                .logoutSuccessUrl("/dang-xuat").permitAll()
                )
                .exceptionHandling(execHandle ->
                        execHandle
                                .accessDeniedPage("/tu-choi")
                                .authenticationEntryPoint(new HttpStatusEntryPoint(ResEnum.KHONG_DUOC_UY_QUYEN.getStatusCode()))
                )
                .sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider()).addFilterBefore(
                        jwtAuthFilter, UsernamePasswordAuthenticationFilter.class
                );
        return security.build();
    }

    //cors
//    @Bean
//    public WebMvcConfigurer webMvcConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedOrigins("http://localhost:8082/**")
//                        .allowedMethods("GET", "POST", "PATCH", "DELETE")
//                        .maxAge(3600);
//            }
//        };
//    }

    //another cors
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:8082"));
        configuration.setAllowedMethods(asList("GET", "POST", "PATCH", "PUT", "DELETE"));
        configuration.setAllowedHeaders(List.of("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(taiKhoanUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    //mã hóa mật khẩu plain-text hoặc bcrypt
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
