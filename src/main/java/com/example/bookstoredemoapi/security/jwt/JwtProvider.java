package com.example.bookstoredemoapi.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Date;
import java.util.stream.Collectors;

public class JwtProvider {

    @Value("${app.jwt.secret}")
    private String jwtSecret;
    @Value("${app.jwt.token.prefix}")
    private String jwtTokenPrefix;
    @Value("${app.jwt.header.string}")
    private String jwtHeaderString;
    @Value("${app.jwt.expiration-in-ms}")
    private long jwtExpirationInMs;

    public String generateToken(Authentication authentication){
        String authorities=authentication
                .getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining());
        return Jwts.builder()
                .setSubject(authentication.getName())
                .claim("roles",authorities)
                .setExpiration(new Date(System.currentTimeMillis()+jwtExpirationInMs))
                .signWith(SignatureAlgorithm.HS512,jwtSecret)
                .compact();

    }
}
