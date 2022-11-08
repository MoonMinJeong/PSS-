package com.example.pss.domain.user.present;

import com.example.pss.domain.user.present.dto.UserListResponse;
import com.example.pss.domain.user.present.dto.UserProfileResponse;
import com.example.pss.domain.user.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserSignService userSignService;
    private final SearchUserService searchUserService;
    private final UserMyPostGetService userMyPostGetService;
    private final UserLikeNoticeGetService userLikeNoticeGetService;
    private final UserSaveMyGetService userSaveMyGetService;

    @GetMapping("/auth/github/callback")
    public void code(String code, HttpServletResponse response) throws IOException, org.json.simple.parser.ParseException {
        String token = userSignService.getCode(code).getAccessToken();
        Cookie cookie = new Cookie("access_token", token);
        cookie.setPath("/");
        cookie.setMaxAge(60*60*24);
        response.addCookie(cookie);
    }

    @GetMapping("/login/oauth2/code/google")
    public String get(String code) {
        return code;
    }

    @GetMapping("/user")
    public UserListResponse userList(@RequestParam String nickname) {
        return searchUserService.userList(nickname);
    }

    @GetMapping("/profile/my")
    public UserProfileResponse getMyPost() {
        return userMyPostGetService.getMyPost();
    }

    @GetMapping("/profile/like")
    public UserProfileResponse getMyLikePost() {
        return userLikeNoticeGetService.getMyLikePost();
    }

    @GetMapping("/profile/save")
    public UserProfileResponse getMySavePost() {
        return userSaveMyGetService.getMySavePost();
    }
}
