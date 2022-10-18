package com.example.pss.domain.user.service;

import com.example.pss.domain.user.domain.User;
import com.example.pss.domain.user.domain.repository.UserRepository;
import com.example.pss.domain.user.present.dto.UserListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SearchUserService {
    private final UserRepository userRepository;

    public UserListResponse userList(String nickname) {
        List<UserListResponse.UserResponse> list = userRepository.findByNicknameContaining(nickname)
                .stream()
                .map(this::userResponse)
                .collect(Collectors.toList());

        return new UserListResponse(list);
    }

    private UserListResponse.UserResponse userResponse(User user) {
        return UserListResponse.UserResponse.builder()
                .id(user.getId())
                .nickname(user.getNickname())
                .imageUrl(user.getImageUrl())
                .build();
    }
}
