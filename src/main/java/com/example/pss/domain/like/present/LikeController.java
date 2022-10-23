package com.example.pss.domain.like.present;

import com.example.pss.domain.like.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/like")
public class LikeController {
    private final LikeService likeService;

    @PostMapping("/{noticeId}")
    public void updateLike(@PathVariable("noticeId") UUID id) {
        likeService.likeTopic(id);
    }

    @DeleteMapping("/{noticeId}")
    public void deleteLike(@PathVariable("noticeId") UUID id) {
        likeService.deleteLikeTopic(id);
    }
}
