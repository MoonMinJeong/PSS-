package com.example.pss.domain.user.present.dto;

import com.example.pss.global.enums.Authority;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenResponse {
    private final String accessToken;
    private final String refreshToken;
    private final Authority authority;
}
