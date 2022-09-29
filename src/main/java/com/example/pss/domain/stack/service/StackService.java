package com.example.pss.domain.stack.service;

import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.notice.facade.NoticeFacade;
import com.example.pss.domain.stack.domain.Stack;
import com.example.pss.domain.stack.domain.repository.StackRepository;
import com.example.pss.domain.stack.facade.StackFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class StackService {
    private final StackRepository stackRepository;
    private final NoticeFacade noticeFacade;
    private final StackFacade stackFacade;

    public Stack createStack(String techName, UUID noticeId) {
        Notice notice = noticeFacade.findById(noticeId);

        Stack stack = stackRepository.save(
                Stack.builder()
                        .notice(notice)
                        .techName(techName)
                        .build()
        );
        return stack;
    }

    public void deleteStack(Long stackId) {
        Stack stack = stackFacade.findById(stackId);

        stackRepository.delete(stack);
    }
}
