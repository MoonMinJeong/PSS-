package com.example.pss.domain.notice.service;

import com.example.pss.domain.member.domain.Member;
import com.example.pss.domain.member.domain.repository.MemberRepository;
import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.notice.domain.repository.NoticeRepository;
import com.example.pss.domain.notice.domain.type.NoticeType;
import com.example.pss.domain.notice.facade.NoticeFacade;
import com.example.pss.domain.notice.present.dto.request.CreateRequest;
import com.example.pss.domain.notice.present.dto.request.CreateReviewRequest;
import com.example.pss.domain.notice.present.dto.response.NoticeIdResponse;
import com.example.pss.domain.review.domain.Review;
import com.example.pss.domain.review.domain.repository.ReviewRepository;
import com.example.pss.domain.stack.domain.Stack;
import com.example.pss.domain.stack.domain.repository.StackRepository;
import com.example.pss.domain.user.domain.User;
import com.example.pss.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class NoticeReviewCreateService {
    private final NoticeRepository noticeRepository;
    private final NoticeFacade noticeFacade;
    private final MemberRepository memberRepository;
    private final StackRepository stackRepository;
    private final UserFacade userFacade;
    private final ReviewRepository reviewRepository;

    @Transactional
    public NoticeIdResponse save(CreateReviewRequest request, UUID noticeId) {
        User user = userFacade.getCurrentUser();

        Notice notices = noticeFacade.findById(noticeId);

        Notice notice = noticeRepository.save(
                Notice.builder()
                        .title(notices.getTitle() + "의 회고록")
                        .content(request.getContent())
                        .imageUrl(request.getImageUrl())
                        .noticeType(NoticeType.POST)
                        .star(0)
                        .viewCount(0)
                        .introduction(request.getContent().substring(20))
                        .isMine(true)
                        .user(user)
                        .build()
        );

        List<Stack> stackList = new ArrayList<>();
        List<Member> memberList = new ArrayList<>();

        for (Stack tech : notices.getStacks()) {
                stackList.add(
                        stackRepository.save(
                                Stack.builder()
                                        .techName(tech.getTechName())
                                        .notice(notice)
                                        .build()
                        )
                );
        }

        for (Member nickname : notices.getMembers()) {
                memberList.add(
                        memberRepository.save(
                                Member.builder()
                                        .nickname(nickname.getNickname())
                                        .user(user)
                                        .notice(notice)
                                        .build()
                        )
                );
        }

        notice.updateList(stackList, memberList);

        reviewRepository.save(
                Review.builder()
                        .user(userFacade.getCurrentUser())
                        .notice(notices)
                        .build()
        );

        return new NoticeIdResponse(notice.getId());
    }
}
