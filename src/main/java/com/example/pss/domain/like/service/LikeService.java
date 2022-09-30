package com.example.pss.domain.like.service;

import com.example.pss.domain.like.domain.Like;
import com.example.pss.domain.like.domain.repository.LikeRepository;
import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.notice.facade.NoticeFacade;
import com.example.pss.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class LikeService {
    private final LikeRepository likeRepository;
    private final NoticeFacade noticeFacade;

    @Transactional
    public void likeTopic(UUID noticeId) {
        Like like = likeRepository.findByNotice_Id(noticeId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        like.updateLikes(like.getLikes() + 1);
    }

    @Transactional
    public void deleteLikeTopic(UUID noticeId) {
        Like like = likeRepository.findByNotice_Id(noticeId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        like.updateLikes(like.getLikes() - 1);
    }
}
