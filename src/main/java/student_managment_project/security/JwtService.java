package student_managment_project.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.websocket.Decoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;

@Service
public class JwtService {
    private String jwtSecret = "TEST";

    private long jwtExpiration = 36000;

    private SecretKey getLoginKey(){
        byte[] keyByte = Decoders.BASE64.decode(jwtSecret);

        return Keys.hmacShaKeyFor(keyByte);
    }

    private String generateToken(UserDetails userDetails){
        Date now = new Date();

        Date expiration = new Date(
                now.getTime() + jwtExpiration
        );

        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(now)
                .expiration(expiration)
                .signWith(getLoginKey())
                .compact();
    }
}
