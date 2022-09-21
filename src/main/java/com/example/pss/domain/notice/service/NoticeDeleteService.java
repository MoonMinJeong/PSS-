package com.example.pss.domain.notice.service;

import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.notice.domain.repository.NoticeRepository;
import com.example.pss.domain.notice.facade.NoticeFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NoticeDeleteService {
    private final NoticeFacade noticeFacade;
    private final NoticeRepository noticeRepository;

    @Transactional
    public void delete(UUID uuid) {
        Notice notice = noticeFacade.findById(uuid);
        noticeRepository.delete(notice);
    }
}
