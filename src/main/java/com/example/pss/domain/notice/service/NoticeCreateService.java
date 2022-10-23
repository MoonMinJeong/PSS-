package com.example.pss.domain.notice.service;

import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.notice.domain.TechStackEntity;
import com.example.pss.domain.notice.domain.repository.NoticeRepository;
import com.example.pss.domain.notice.present.dto.request.CreateRequest;
import com.example.pss.domain.user.domain.User;
import com.example.pss.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class NoticeCreateService {
    private final NoticeRepository noticeRepository;
    private final UserFacade userFacade;

    @Transactional
    public void create(CreateRequest request) {
        User user = userFacade.getCurrentUser();

        Notice notice = noticeRepository.save(
                Notice.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .imageUrl(request.getImageUrl())
                        .star(0)
                        .viewCount(0)
                        .introduction(request.getIntroduction())
                        .isMine(true)
                        .user(user)
                        .build()
        );
    }
}
