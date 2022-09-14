package com.example.pss.domain.user.present;

import com.example.pss.domain.user.service.UserSignService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserSignService userSignService;

    @GetMapping("/auth/github/callback")
    public String code(String code) throws UnsupportedEncodingException {
        return userSignService.getCode(code);
    }
}
