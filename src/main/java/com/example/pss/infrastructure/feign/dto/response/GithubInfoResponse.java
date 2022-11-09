package com.example.pss.infrastructure.feign.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GithubInfoResponse {
    private String login;
    private String avatarUrl;
    private String email;
}
