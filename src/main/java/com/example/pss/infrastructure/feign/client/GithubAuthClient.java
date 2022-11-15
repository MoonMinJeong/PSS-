package com.example.pss.infrastructure.feign.client;

import com.example.pss.infrastructure.feign.dto.response.GithubTokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "GithubAuthClient", url = "https://github.com/login/oauth/access_token")
public interface GithubAuthClient {
    @PostMapping(produces = "application/json")
    GithubTokenResponse GithubAuth(
            @RequestParam(value = "client_id") String clientId,
            @RequestParam(value = "client_secret") String clientSecret,
            @RequestParam(value = "code") String code
    );
}
