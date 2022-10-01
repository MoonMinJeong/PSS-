package com.example.pss.domain.like.service;

import com.example.pss.domain.like.domain.Like;
import com.example.pss.domain.like.domain.repository.LikeRepository;
import com.example.pss.domain.like.exception.LikeExistsException;
import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.notice.facade.NoticeFacade;
import com.example.pss.domain.user.domain.User;
import com.example.pss.domain.user.exception.UserNotFoundException;
import com.example.pss.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class LikeService {
    private final LikeRepository likeRepository;
    private final UserFacade userFacade;
    private final NoticeFacade noticeFacade;

    @Transactional
    public void likeTopic(UUID noticeId) {
        User user = userFacade.getCurrentUser();
        Notice notice = noticeFacade.findById(noticeId);

        if(likeRepository.findByUserAndNotice(user, notice).isPresent()) {
            throw LikeExistsException.EXCEPTION;
        }

        likeRepository.save(
                Like.builder()
                        .user(user)
                        .notice(notice)
                        .likeCheck(true)
                        .build()
        );
    }

    @Transactional
    public void deleteLikeTopic(UUID noticeId) {
        User user = userFacade.getCurrentUser();
        Notice notice = noticeFacade.findById(noticeId);

        Like like = likeRepository.findByUserAndNotice(user, notice)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        like.likeUpdate(false);
    }
}
