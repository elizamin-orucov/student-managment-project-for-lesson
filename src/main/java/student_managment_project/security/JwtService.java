package student_managment_project.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {
    private String jwtSecret = "TEST";

    private long jwtExpiration = 36000;

    private SecretKey getLoginKey(){
        byte[] keyByte = Decoders.BASE64.decode(jwtSecret);

        return Keys.hmacShaKeyFor(keyByte);
    }

    public String generateToken(UserDetails userDetails){
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

    public String extractUsername(String token){
        return extractAllClaims(token).getSubject();
    }

    public Claims extractAllClaims(String token){

        return Jwts.parser()
                .verifyWith(getLoginKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean isTokenValid(
            String token,
            UserDetails userDetails
    ){
        String username = extractUsername(token);

        return username.equals(userDetails.getUsername())
                && userDetails.isEnabled()
                && userDetails.isAccountNonLocked()
                && userDetails.isCredentialsNonExpired()
                && userDetails.isCredentialsNonExpired();
    }



}
