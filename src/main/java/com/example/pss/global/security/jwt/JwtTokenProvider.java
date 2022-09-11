package com.example.pss.global.security.jwt;

import com.example.pss.domain.auth.domain.repository.RefreshRepository;
import com.example.pss.global.security.auth.AuthDetailsService;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {
    private final JwtProperties jwtProperties;
    private final AuthDetailsService authDetailsService;
    private final RefreshRepository refreshRepository;

    public String generateAccessToken(String id) {
        return generateToken(id, "access", jwtProperties.getAccessExp());
    }

    private String generateToken(String id, String type, Long exp) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getJwtSecret())
                .setSubject(id)
                .claim("typ", type)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + exp * 1000))
                .compact();
    }

    public String parseToken(String bearerToken) {
        if(bearerToken!=null && bearerToken.startsWith(jwtProperties.getJwtPrefix())) {
            return bearerToken.replace(jwtProperties.getJwtPrefix(), "");
        }
        return null;
    }


}
