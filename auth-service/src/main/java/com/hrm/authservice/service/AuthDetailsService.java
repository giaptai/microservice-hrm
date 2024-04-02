//package com.hrm.authservice.service;
//
//import com.hrm.authservice.client.TaiKhoanClient;
//import com.hrm.authservice.config.AuthPrinciple;
//import com.hrm.authservice.model.TaiKhoanDTO;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class AuthDetailsService implements UserDetailsService {
//    private final IAuthService service;
//
//    public AuthDetailsService(AuthService service) {
//        this.service = service;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        TaiKhoanDTO taiKhoan = service.login(username);
//        if (taiKhoan == null) {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
//        AuthPrinciple authPrinciple = new AuthPrinciple();
//        authPrinciple.setTaiKhoanDTO(taiKhoan);
//        authPrinciple.setAuthorities(List.of(new SimpleGrantedAuthority(taiKhoan.getRole())));
//        return authPrinciple;
//    }
//}
