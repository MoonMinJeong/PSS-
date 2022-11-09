package com.example.pss.infrastructure.feign.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GithubTokenResponse {
    private String accessToken;
    private String tokenType;
    private String scope;
}
