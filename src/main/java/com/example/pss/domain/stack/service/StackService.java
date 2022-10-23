package com.example.pss.domain.stack.service;

import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.notice.domain.TechStackEntity;
import com.example.pss.domain.notice.facade.NoticeFacade;
import com.example.pss.domain.stack.domain.Stack;
import com.example.pss.domain.stack.domain.repository.StackRepository;
import com.example.pss.domain.stack.facade.StackFacade;
import com.example.pss.domain.stack.present.dto.StackRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class StackService {
    private final StackRepository stackRepository;
    private final NoticeFacade noticeFacade;
    private final StackFacade stackFacade;

    public void createStack(StackRequest request, UUID noticeId) {
        Notice notice = noticeFacade.findById(noticeId);

        stackRepository.save(
                Stack.builder()
                        .notice(notice)
                        .techName(request.getTech())
                        .build()
        );
    }

    @Transactional
    public void deleteStack(Long stackId) {
        Stack stack = stackFacade.findById(stackId);

        stackRepository.delete(stack);
    }
}
