package com.example.pss.domain.user.service;

import com.example.pss.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSignService {
    private final UserRepository userRepository;

    
}
