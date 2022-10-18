package com.example.pss.domain.stack.facade;

import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.stack.domain.Stack;
import com.example.pss.domain.stack.domain.repository.StackRepository;
import com.example.pss.domain.stack.exception.StackNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class StackFacade {
    private final StackRepository stackRepository;

    public Stack findById(Long id) {
        return stackRepository.findById(id)
                .orElseThrow(() -> StackNotFoundException.EXCEPTION);
    }

    public List<String> findAllByNotice(Notice notice) {
        List<String> list = new ArrayList<>();

        for(int i = 0; i<stackRepository.findAllByNotice(notice).size(); i++) {
            list.add(stackRepository.findAllByNotice(notice)
                    .get(i)
                    .getTechName());
        }
        return list;
    }
}
