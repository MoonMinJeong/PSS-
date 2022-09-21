package com.example.pss.domain.notice.facade;

import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.notice.domain.repository.NoticeRepository;
import com.example.pss.domain.notice.exception.NoticeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class NoticeFacade {
    private final NoticeRepository noticeRepository;

    public Notice findById(UUID uuid) {
        return noticeRepository.findById(uuid)
                .orElseThrow(() -> NoticeNotFoundException.EXCEPTION);
    }
}
