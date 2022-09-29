package com.example.pss.domain.stack.facade;

import com.example.pss.domain.stack.domain.Stack;
import com.example.pss.domain.stack.domain.repository.StackRepository;
import com.example.pss.domain.stack.exception.StackNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StackFacade {
    private final StackRepository stackRepository;

    public Stack findById(Long id) {
        return stackRepository.findById(id)
                .orElseThrow(() -> StackNotFoundException.EXCEPTION);
    }
}
