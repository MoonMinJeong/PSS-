package com.example.pss.infrastructure.feign.client;

import com.example.pss.infrastructure.feign.dto.response.GithubInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "GithubGetClient", url = "https://api.github.com/user")
public interface GithubGetClient {

    @GetMapping(produces = "application/json")
    GithubInfoResponse get(@RequestHeader("Authorization") String accessToken);
}
