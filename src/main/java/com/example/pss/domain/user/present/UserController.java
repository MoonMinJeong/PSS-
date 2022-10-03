package com.example.pss.domain.user.present;

import com.example.pss.domain.user.present.dto.TokenResponse;
import com.example.pss.domain.user.service.UserSignService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserSignService userSignService;

    @GetMapping("/auth/github/callback")
    public TokenResponse code(String code) throws IOException, org.json.simple.parser.ParseException {
         return userSignService.getCode(code);
    }

    @GetMapping("/login/oauth2/code/google")
    public String get(String code) {
        return code;
    }
}
