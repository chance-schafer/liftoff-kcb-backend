package org.launchcode.liftoff_kcb_backend.security;

import io.jsonwebtoken.*;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTGenerator {
    @NonNull
    public final String JWT_SECRET;

    public JWTGenerator(@Value("${app.jwt.secret}") final String jwtSecret) {
        JWT_SECRET = jwtSecret;
    }


    public  String generateToken(Authentication authentication){
        String username = authentication.getName();
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + SecurityConstant.JWT_EXPIRATION);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }


    public String getUsernameFromJWT(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token);
            return true;
        }catch (MalformedJwtException e){
            throw new AuthenticationCredentialsNotFoundException("Invalid token");
        } catch (ExpiredJwtException e){
            throw new AuthenticationCredentialsNotFoundException("Expired token");
        } catch (UnsupportedJwtException e){
            throw new AuthenticationCredentialsNotFoundException("Unsupported token");
        } catch (IllegalArgumentException e){
            throw new AuthenticationCredentialsNotFoundException("Empty token");
        }
    }
}
