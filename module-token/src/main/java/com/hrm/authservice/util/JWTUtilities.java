package com.hrm.authservice.util;

/* this class help generating token */

import com.hrm.authservice.model.ResTaiKhoan;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTUtilities {
    private final SecretKey key;
    private static final long EXPIRATION_TIME = 8 * 60 * 60 * 1000; // 1 hour
    private final String ALGORITHM = "HmacSHA256"; //thuật toán
    private final String SECRET_KEY = "qwertyuiasdfghjkzxcnmvjfgfgdfesdfafdfdgfgfhfgfdsvdgfbodfmhktnidh"; //khóa bí mật

    public JWTUtilities() {
        //giải mã chuỗi secretStr thành byte[]
//        byte[] keyBytes = Base64.getDecoder().decode(secretStr.getBytes(StandardCharsets.UTF_8));
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        this.key = new SecretKeySpec(keyBytes, ALGORITHM);
    }

    //tạo token ngẫu nhiên
    public String generationToken(ResTaiKhoan resTaiKhoan) {
        Map<String, String> map = new HashMap<>();
        map.put("taiKhoanId", String.valueOf(resTaiKhoan.getId()));
        map.put("role", resTaiKhoan.getRole());
        return Jwts.builder()
                .subject(resTaiKhoan.getUsername())
                .claims(map)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }

    //tao refresh token, éo xài
//    public String refreshToken(Map<String, Object> claims, UserDetails userDetails) {
//        return Jwts.builder()
//                .claims(claims)
//                .subject(userDetails.getUsername())
//                .issuedAt(new Date(System.currentTimeMillis()))
//                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                .signWith(key)
//                .compact();
//    }

//    public String extractUsername(String token) {
//        return extractClaims(token, claims -> claims.getSubject());
//    }

    //từ token và khóa bí mật
    //láy thông tin user đang nhập
//    private <T> T extractClaims(String token, Function<Claims, T> claimsFunction) {
//        return claimsFunction.apply(
//                Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload()
//        );
//    }

 /*   public boolean isTokenValid(String token, TaiKhoan userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }*/

    //xem thu token het han chua
//    public boolean isTokenExpired(String token) {
//        return extractClaims(token, Claims::getExpiration)
//                .before(new Date(System.currentTimeMillis()));
//    }
}
