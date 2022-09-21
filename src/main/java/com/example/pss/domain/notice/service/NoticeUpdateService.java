package com.example.pss.domain.notice.service;

import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.notice.facade.NoticeFacade;
import com.example.pss.domain.notice.present.dto.request.UpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NoticeUpdateService {
    private final NoticeFacade noticeFacade;

    @Transactional
    public void update(UpdateRequest request, UUID uuid) {
        Notice notice = noticeFacade.findById(uuid);

        notice.UpdateNotice(request.getTitle(), request.getContent(), request.getImageUrl(), request.getIntroduction());
    }
}
