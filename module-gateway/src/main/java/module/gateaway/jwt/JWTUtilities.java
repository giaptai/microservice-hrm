package module.gateaway.jwt;

/*
 * this class help generating
 * and validating a token
 */

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import org.springframework.stereotype.Component;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.function.Function;

@Component
public class JWTUtilities {
    private SecretKey key;
    private final String ALGORITHM = "HmacSHA256"; //thuật toán
    private final String SECRET_KEY = "qwertyuiasdfghjkzxcnmvjfgfgdfesdfafdfdgfgfhfgfdsvdgfbodfmhktnidh"; //khóa bí mật

    public JWTUtilities() {
        //giải mã chuỗi secretStr thành byte[]
//        byte[] keyBytes = Base64.getDecoder().decode(secretStr.getBytes(StandardCharsets.UTF_8));
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        this.key = new SecretKeySpec(keyBytes, ALGORITHM);
    }

    private String extractUsername(String token) {
        return extractClaims(token, claims -> claims.getSubject());
    }

    //từ token và khóa bí mật
    //lấy thông tin user đăng nhập
    private <T> T extractClaims(String token, Function<Claims, T> claimsFunction) {
        return claimsFunction.apply(
                Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload()
        );
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();
    }

    public boolean isTokenValid(String token) {
        final String username = extractUsername(token);
        boolean checkTokenExp = isTokenExpired(token);
        return (username != null && !checkTokenExp);
    }

    //xem thu token het han chua
    // so sánh ngày hết hạn với ngày hiẹn tại, nếu before false thì chưa hết hạn, trua thì hết cmnr
    public boolean isTokenExpired(String token) {
        Date dateCheck = extractClaims(token, Claims::getExpiration);
        Date currDate = new Date(System.currentTimeMillis());
        return dateCheck.before(currDate);
    }
}
