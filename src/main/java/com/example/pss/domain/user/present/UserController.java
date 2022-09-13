package com.example.pss.domain.user.present;

import com.example.pss.domain.user.service.UserSignService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserSignService userSignService;
    private String authCode;

    @GetMapping("/auth/github/callback")
    public void code(String code) {
        this.authCode = code;
    }
}
