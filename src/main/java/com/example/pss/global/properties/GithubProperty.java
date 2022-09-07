package com.example.pss.global.properties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ConstructorBinding
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "spring.security.oauth2.client.registration.github")
public class GithubProperty {
    private final String clientId;
    private final String clientSecret;
    private final String redirect_url;
    private final String token_uri;
    private final String user_info_uri;
}
