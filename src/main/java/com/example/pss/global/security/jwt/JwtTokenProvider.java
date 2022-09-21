package com.example.pss.global.security.jwt;

import com.example.pss.domain.auth.domain.Refresh;
import com.example.pss.domain.auth.domain.repository.RefreshRepository;
import com.example.pss.global.exception.ExpiredJwtException;
import com.example.pss.global.exception.InvalidJwtException;
import com.example.pss.global.security.auth.AuthDetailsService;
import com.nimbusds.oauth2.sdk.token.RefreshToken;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {
    private final JwtProperties jwtProperties;
    private final AuthDetailsService authDetailsService;
    private final RefreshRepository refreshRepository;

    public String generateRefreshToken(String id) {
        String refreshToken = generateToken(id, "refresh", jwtProperties.getRefreshExp());

        refreshRepository.save(
                Refresh.builder()
                        .nickname(id)
                        .token(refreshToken)
                        .timeToLive(jwtProperties.getRefreshExp())
                        .build()
        );

        return refreshToken;
    }

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

    public String resolveToken(HttpServletRequest request) {
        String bearer = request.getHeader(jwtProperties.getJwtHeader());
        return parseToken(bearer);
    }

    public Claims getTokenBody(String token) {
        try {
            return Jwts.parser().setSigningKey(jwtProperties.getJwtSecret())
                    .parseClaimsJws(token).getBody();
        } catch (io.jsonwebtoken.ExpiredJwtException e) {
            throw ExpiredJwtException.EXCEPTION;
        } catch (Exception e) {
            throw InvalidJwtException.EXCEPTION;
        }
    }

    public String getTokenSubject(String token) {
        return getTokenBody(token).getSubject();
    }

    public Authentication authentication(String token) {
        UserDetails userDetails = authDetailsService.loadUserByUsername(getTokenSubject(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }
}
