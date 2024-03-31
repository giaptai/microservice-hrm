package com.hrm.taikhoan.security.jwt_utilities;

/*
 * this class help generating
 * and validating a token
 */

import com.hrm.taikhoan.models.TaiKhoan;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JWTUtilities {
    private SecretKey key;
    //create time
    private static final long EXPIRATION_TIME = 8*60*60*1000; // 1 hour
    private final String ALGORITHM = "HmacSHA256"; //thuật toán
    private final String SECRET_KEY = "qwertyuiasdfghjkzxcnmvjfgfgdfesdfafdfdgfgfhfgfdsvdgfbodfmhktnidh"; //khóa bí mật

    public JWTUtilities() {
        //giải mã chuỗi secretStr thành byte[]
//        byte[] keyBytes = Base64.getDecoder().decode(secretStr.getBytes(StandardCharsets.UTF_8));
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        this.key = new SecretKeySpec(keyBytes, ALGORITHM);
    }

    //tạo token ngẫu nhiên
    public String generationToken(UserDetails userDetails) {
        Map<String, String> map = new HashMap<>();
        return Jwts.builder()
                .subject(userDetails.getUsername())
                .claims(map)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }
//    public String generationToken(UserDetails userDetails) {
//        Map<String, String> map = new HashMap<>();
//        map.put("name", userDetails.getUsername());
//        map.put("password", userDetails.getPassword());
//        return Jwts.builder()
//                .subject(userDetails.getPassword())
//                .claims(map)
//                .issuedAt(new Date(System.currentTimeMillis()))
//                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                .signWith(key)
//                .compact();
//    }

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

    public String extractUsername(String token) {
        return extractClaims(token, claims -> claims.getSubject());
    }

    //từ token và khóa bí mật
    //láy thông tin user đang nhập
    private <T> T extractClaims(String token, Function<Claims, T> claimsFunction) {
        return claimsFunction.apply(
                Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload()
        );
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    //xem thu token het han chua
    public boolean isTokenExpired(String token) {
        return extractClaims(token, Claims::getExpiration)
                .before(new Date(System.currentTimeMillis()));
    }
}
