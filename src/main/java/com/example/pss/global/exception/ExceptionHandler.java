package com.example.pss.global.exception;

import com.example.pss.global.exception.error.ErrorCode;
import com.example.pss.global.exception.error.PssException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@Component
public class ExceptionHandler extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (PssException e) {
            ErrorCode errorCode = e.getErrorCode();

            ErrorResponse errorResponse = new ErrorResponse(errorCode.getStatus(), errorCode.getMessage());

            String errorResult = objectMapper.writeValueAsString(errorResponse);

            response.setStatus(errorCode.getStatus());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.getWriter().write(errorResult);
        }
    }
}
