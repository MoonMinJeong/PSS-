package com.example.pss.domain.user.service;

import com.example.pss.domain.user.domain.repository.UserRepository;
import com.example.pss.global.properties.GithubProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;


@Service
@RequiredArgsConstructor
public class UserSignService {
    private final UserRepository userRepository;
    private final GithubProperties githubProperties;

    public String getCode(String code) throws UnsupportedEncodingException {
        StringBuilder builder = new StringBuilder("https://github.com/login/oauth/access_token");
        builder.append("?").append(URLEncoder.encode("client_id", "UTF-8")).append("=").append(githubProperties.getClientId());
        builder.append("&").append(URLEncoder.encode("client_secret", "UTF-8")).append("=").append(githubProperties.getClientSecret());
        builder.append("&").append(URLEncoder.encode("code", "UTF-8")).append("=").append(code);

        return builder.toString();
    }
}
