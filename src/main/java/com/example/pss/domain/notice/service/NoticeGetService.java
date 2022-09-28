package com.example.pss.domain.notice.service;

import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.notice.facade.NoticeFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NoticeGetService {
    private final NoticeFacade noticeFacade;

    public Notice getNotice(UUID uuid) {
        return noticeFacade.findById(uuid);
    }
}
