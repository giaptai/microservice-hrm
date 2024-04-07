//package com.hrm.taikhoan.security;
//
//import com.hrm.taikhoan.models.TaiKhoan;
//import com.hrm.taikhoan.repository.TaiKhoanRepository;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class TaiKhoanUserDetailsService implements UserDetailsService {
//    private final TaiKhoanRepository taiKhoanRepository;
//
//    public TaiKhoanUserDetailsService(TaiKhoanRepository taiKhoanRepository) {
//        this.taiKhoanRepository = taiKhoanRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        TaiKhoan taiKhoan = taiKhoanRepository.findByUsername(username);
//        if (taiKhoan == null) {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
//        return taiKhoan;
//    }
//}
