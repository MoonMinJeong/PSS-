package com.example.pss.domain.notice.service;

import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.notice.domain.repository.NoticeRepository;
import com.example.pss.domain.notice.facade.NoticeFacade;
import com.example.pss.domain.notice.present.dto.response.NoticeOneResponse;
import com.example.pss.domain.stack.domain.repository.StackRepository;
import com.example.pss.domain.star.domain.Star;
import com.example.pss.domain.star.domain.repository.StarRepository;
import com.example.pss.domain.star.exception.StarNotFoundException;
import com.example.pss.domain.user.domain.User;
import com.example.pss.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class NoticeIntroService {
    private final NoticeFacade noticeFacade;
    private final NoticeRepository noticeRepository;
    private final StarRepository starRepository;
    private final UserFacade userFacade;
    private final StackRepository stackRepository;

    public NoticeOneResponse getNotice(UUID noticeId) {
        User user = userFacade.getCurrentUser();
        Notice notice = noticeFacade.findById(noticeId);

        Star star = starRepository.findByNoticeAndUser(notice, user)
                .orElseThrow(() -> StarNotFoundException.EXCEPTION);

        return NoticeOneResponse.builder()
                .title(notice.getTitle())
                .content(notice.getContent())
                .createTime(notice.getCreateTime())
                .profileImage(notice.getUser().getImageUrl())
                .email(notice.getUser().getEmail())
                .viewCount(notice.getViewCount())
                .stars(star.getStars())
                .stacks(stackRepository.findAllByNotice(notice))
                .build();
    }
}
