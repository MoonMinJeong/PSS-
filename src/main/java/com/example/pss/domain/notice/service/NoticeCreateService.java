package com.example.pss.domain.notice.service;

import com.example.pss.domain.member.domain.Member;
import com.example.pss.domain.member.domain.repository.MemberRepository;
import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.notice.domain.repository.NoticeRepository;
import com.example.pss.domain.notice.domain.type.NoticeType;
import com.example.pss.domain.notice.present.dto.request.CreateRequest;
import com.example.pss.domain.notice.present.dto.response.NoticeIdResponse;
import com.example.pss.domain.stack.domain.Stack;
import com.example.pss.domain.stack.domain.repository.StackRepository;
import com.example.pss.domain.user.domain.User;
import com.example.pss.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeCreateService {
    private final NoticeRepository noticeRepository;
    private final MemberRepository memberRepository;
    private final StackRepository stackRepository;
    private final UserFacade userFacade;

    @Transactional
    public NoticeIdResponse create(CreateRequest request) {
        User user = userFacade.getCurrentUser();

        List<Stack> stack = new ArrayList<>();
        List<Member> members = new ArrayList<>();

        Notice notice = noticeRepository.save(
                Notice.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .imageUrl(request.getImageUrl())
                        .noticeType(NoticeType.POST)
                        .star(0)
                        .viewCount(0)
                        .introduction(request.getContent().substring(0,20))
                        .user(user)
                        .build()
        );

        for (String tech : request.getStacks()) {
            if (stackRepository.findByTechNameAndNotice(tech, notice).isEmpty()) {
                stack.add(
                        stackRepository.save(
                                Stack.builder()
                                        .techName(tech)
                                        .notice(notice)
                                        .build()
                        )
                );
            }
        }

        for (String nickname : request.getNicknames()) {
            if (memberRepository.findByNicknameAndNotice(nickname, notice).isEmpty()) {
                members.add(
                        memberRepository.save(
                                Member.builder()
                                        .nickname(nickname)
                                        .user(user)
                                        .notice(notice)
                                        .build()
                        )
                );
            }
        }

        notice.updateList(stack, members);
        return new NoticeIdResponse(notice.getId());
    }
}
