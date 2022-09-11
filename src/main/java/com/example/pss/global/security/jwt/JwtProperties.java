package com.example.pss.global.security.jwt;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ConstructorBinding
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {
    private final String jwtSecret;
    private final Long accessExp;
    private final Long refreshExp;
    private final String jwtHeader;
    private final String jwtPrefix;
}
