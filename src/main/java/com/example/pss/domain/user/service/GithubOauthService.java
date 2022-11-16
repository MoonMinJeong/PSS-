package com.example.pss.domain.user.service;

import com.example.pss.domain.user.domain.User;
import com.example.pss.domain.user.domain.repository.UserRepository;
import com.example.pss.domain.user.present.dto.CodeRequest;
import com.example.pss.domain.user.present.dto.TokenResponse;
import com.example.pss.global.enums.Authority;
import com.example.pss.global.properties.GithubProperties;
import com.example.pss.global.security.jwt.JwtTokenProvider;
import com.example.pss.infrastructure.feign.client.GithubAuthClient;
import com.example.pss.infrastructure.feign.client.GithubGetClient;
import com.example.pss.infrastructure.feign.dto.response.GithubInfoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class GithubOauthService {
    private final GithubAuthClient githubAuthClient;
    private final GithubGetClient githubGetClient;
    private final GithubProperties githubProperties;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public TokenResponse getCode(CodeRequest request) {

        String token = "Bearer " + githubAuthClient.GithubAuth(
                githubProperties.getClientId(),
                githubProperties.getClientSecret(),
                request.getCode()
        ).getAccessToken();

        GithubInfoResponse githubInfoResponse = githubGetClient.get(token);

        if (userRepository.findByNickname(githubInfoResponse.getLogin()).isEmpty()) {
            userRepository.save(
                    User.builder()
                            .nickname(githubInfoResponse.getLogin())
                            .imageUrl(githubInfoResponse.getAvatarUrl())
                            .email(githubInfoResponse.getEmail())
                            .authority(Authority.user)
                            .build()
            );
        }

        String accessToken = jwtTokenProvider.generateAccessToken(githubInfoResponse.getLogin());
        String refreshToken = jwtTokenProvider.generateRefreshToken(githubInfoResponse.getLogin());

        return TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .authority(Authority.user)
                .build();
    }
}
