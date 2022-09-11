package com.example.pss.global.config;

import com.example.pss.global.exception.ExceptionHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class FilterConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final ObjectMapper objectMapper;

    @Override
    public void configure(HttpSecurity httpSecurity) {
        ExceptionHandler exceptionHandler = new ExceptionHandler(objectMapper);
        httpSecurity.addFilterBefore(exceptionHandler, UsernamePasswordAuthenticationFilter.class);
    }
}
