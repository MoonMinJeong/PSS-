package com.example.pss.domain.stack.facade;

import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.stack.domain.Stack;
import com.example.pss.domain.stack.domain.repository.StackRepository;
import com.example.pss.domain.stack.exception.StackNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class StackFacade {
    private final StackRepository stackRepository;

    public Stack findById(Long id) {
        return stackRepository.findById(id)
                .orElseThrow(() -> StackNotFoundException.EXCEPTION);
    }

    @Transactional
    public List<String> findAllByNotice(Notice notice) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < stackRepository.findAllByNotice(notice).size(); i++) {
            list.add(stackRepository.findAllByNotice(notice)
                    .get(i)
                    .getTechName());
        }
        return list;
    }

    public List<Stack> findByList(List<String> list, Notice notice) {
        List<Stack> stacks = new ArrayList<>();

        for (String techName : list) {
            if (stackRepository.findByTechNameAndNotice(techName, notice).isEmpty()) {
                stacks.add(
                        stackRepository.save(
                                Stack.builder()
                                        .techName(techName)
                                        .notice(notice)
                                        .build()
                        )
                );
            } else {
                Stack stack = stackRepository.findByTechNameAndNotice(techName, notice)
                        .orElseThrow(() -> StackNotFoundException.EXCEPTION);

                stacks.add(stack);
            }
        }

        return stacks;
    }
}
