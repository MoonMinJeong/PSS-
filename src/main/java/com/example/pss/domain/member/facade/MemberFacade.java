package com.example.pss.domain.member.facade;

import com.example.pss.domain.member.domain.Member;
import com.example.pss.domain.member.domain.repository.MemberRepository;
import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.user.domain.User;
import com.example.pss.domain.user.exception.UserNotFoundException;
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

    public List<Member> findByList(List<String> list, Notice notice, User user) {
        List<Member> members = new ArrayList<>();

        for(String nickname : list) {
            if(memberRepository.findByNicknameAndNotice(nickname, notice).isEmpty()) {
                members.add(
                        memberRepository.save(
                                Member.builder()
                                        .nickname(nickname)
                                        .user(user)
                                        .notice(notice)
                                        .build()
                        )
                );
            } else {
                Member member = memberRepository.findByNicknameAndNotice(nickname, notice)
                        .orElseThrow(() -> UserNotFoundException.EXCEPTION);

                members.add(member);
            }
        }

        return members;
    }
}
