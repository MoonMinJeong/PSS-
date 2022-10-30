package com.example.pss.domain.user.facade;

import com.example.pss.domain.user.domain.User;
import com.example.pss.domain.user.domain.repository.UserRepository;
import com.example.pss.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {
    private final UserRepository userRepository;

    public User getCurrentUser() {
        String nickname = SecurityContextHolder.getContext().getAuthentication().getName();

        return userRepository.findByNickname(nickname)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
