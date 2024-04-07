//package com.hrm.taikhoan.security;
//
//import com.hrm.taikhoan.security.jwt_utilities.JWTUtilities;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Component
//@RequiredArgsConstructor
//public class JWTAuthFilter extends OncePerRequestFilter {
//    private final JWTUtilities jwtUtilities;
//
//    private final TaiKhoanUserDetailsService taiKhoanUserDetailsService;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        final String authHeader = request.getHeader("Authorization");
//        final String jwtToken;
//        final String userName;
//        if (authHeader == null || authHeader.isBlank()) {
//            filterChain.doFilter(request, response);
//            return;
//        }
////        else {
//        jwtToken = authHeader.substring(7); //bỏ "Bearer "
//        userName = jwtUtilities.extractUsername(jwtToken);
//        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//            UserDetails userDetails = taiKhoanUserDetailsService.loadUserByUsername(userName);
//            if (jwtUtilities.isTokenValid(jwtToken, userDetails)) {
//                SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
//                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
//                        userDetails, null, userDetails.getAuthorities()
//                );
//                token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                securityContext.setAuthentication(token);
//                SecurityContextHolder.setContext(securityContext);
//            }
//        }
//        filterChain.doFilter(request, response);
////    }
//    }
//}
