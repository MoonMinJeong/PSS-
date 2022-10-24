package com.example.pss.domain.member.facade;

import com.example.pss.domain.member.domain.repository.MemberRepository;
import com.example.pss.domain.notice.domain.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class MemberFacade {
    private final MemberRepository memberRepository;

    public List<String> findAllByNotice(Notice notice) {
        List<String> list = new ArrayList<>();

        for(int i = 0; i<memberRepository.findAllByNotice(notice).size(); i++) {
            list.add(memberRepository.findAllByNotice(notice)
                    .get(i)
                    .getNickname());
        }
        return list;
    }
}
