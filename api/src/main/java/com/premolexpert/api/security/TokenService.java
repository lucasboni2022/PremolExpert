package com.premolexpert.api.security;

import com.premolexpert.api.entity.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class TokenService {

    @Value("${api.security.token.secret:MySecretKeyForJwtTokenGenerationShouldBeLongEnough}")
    private String secret;

    public String generateToken(Usuario usuario) {
        return Jwts.builder()
                .setSubject(usuario.getUsuLogin())
                .setIssuer("PreMolExpert API")
                .setIssuedAt(new Date())
                .setExpiration(Date.from(LocalDateTime.now().plusHours(24).atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String getSubject(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    private Key getKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }
}
