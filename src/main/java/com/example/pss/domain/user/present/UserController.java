package com.example.pss.domain.user.present;

import com.example.pss.domain.user.service.UserSignService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserSignService userSignService;

    @GetMapping("/get")
    public OAuth2AccessToken accessToken(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient) {
        return authorizedClient.getAccessToken();
    }

    @GetMapping("/use")
    public OAuth2User index(@AuthenticationPrincipal OAuth2User oauth2User) {
        return oauth2User;
    }
}
