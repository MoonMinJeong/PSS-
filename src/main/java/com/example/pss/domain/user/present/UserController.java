package com.example.pss.domain.user.present;

import com.example.pss.domain.user.present.dto.*;
import com.example.pss.domain.user.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final GithubOauthService githubOauthService;
    private final SearchUserService searchUserService;
    private final UserMyPostGetService userMyPostGetService;
    private final UserLikeNoticeGetService userLikeNoticeGetService;
    private final UserSaveMyGetService userSaveMyGetService;

    @GetMapping("/auth")
    public TokenResponse token(@RequestParam String code) {
        return githubOauthService.getCode(code);
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
