package com.example.pss.domain.star.service;

import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.notice.facade.NoticeFacade;
import com.example.pss.domain.star.domain.Star;
import com.example.pss.domain.star.domain.repository.StarRepository;
import com.example.pss.domain.star.exception.StarNotFoundException;
import com.example.pss.domain.star.facade.StarFacade;
import com.example.pss.domain.star.present.dto.StarRequest;
import com.example.pss.domain.user.domain.User;
import com.example.pss.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class StarService {
    private final StarRepository starRepository;
    private final UserFacade userFacade;
    private final NoticeFacade noticeFacade;
    private final StarFacade starFacade;

    public void create(UUID noticeId, StarRequest request) {
        User user = userFacade.getCurrentUser();
        Notice notice = noticeFacade.findById(noticeId);

        starRepository.save(
                Star.builder()
                        .stars(request.getStars())
                        .user(user)
                        .notice(notice)
                        .build()
        );

        notice.updateStar(starFacade.findAllByNotice(notice));
    }

    @Transactional
    public void update(UUID noticeId, StarRequest request) {
        User user = userFacade.getCurrentUser();

        Star star = starRepository.findByNoticeAndUser(noticeFacade.findById(noticeId), user)
                .orElseThrow(() -> StarNotFoundException.EXCEPTION);

        star.update(request.getStars());
    }
}
