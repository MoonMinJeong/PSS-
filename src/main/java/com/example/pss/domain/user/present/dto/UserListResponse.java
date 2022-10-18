package com.example.pss.domain.user.present.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class UserListResponse {
    private List<UserResponse> list;

    @Getter
    @Builder
    public static class UserResponse {
        private UUID id;
        private String nickname;
        private String imageUrl;
    }
}
