package com.example.pss.domain.stack.service;

import com.example.pss.domain.stack.domain.Stack;
import com.example.pss.domain.stack.domain.repository.StackRepository;
import com.example.pss.domain.stack.facade.StackFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class StackService {
    private final StackRepository stackRepository;
    private final StackFacade stackFacade;

    @Transactional
    public void deleteStack(Long stackId) {
        Stack stack = stackFacade.findById(stackId);

        stackRepository.delete(stack);
    }
}
