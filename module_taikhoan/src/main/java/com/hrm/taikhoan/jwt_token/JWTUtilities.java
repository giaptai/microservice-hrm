package com.hrm.taikhoan.jwt_token;

import com.hrm.taikhoan.models.TaiKhoan;
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
    public String generationToken(TaiKhoan taiKhoan) {
        Map<String, String> map = new HashMap<>();
        map.put("taiKhoanId", String.valueOf(taiKhoan.getId()));
        map.put("role", taiKhoan.getRoleTaiKhoan().name());
        return Jwts.builder()
                .subject(taiKhoan.getUsername())
                .claims(map)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }
}
