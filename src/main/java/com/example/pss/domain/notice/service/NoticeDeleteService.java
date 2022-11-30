package com.example.pss.domain.notice.service;

import com.example.pss.domain.comment.domain.repository.CommentRepository;
import com.example.pss.domain.member.domain.repository.MemberRepository;
import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.notice.domain.repository.NoticeRepository;
import com.example.pss.domain.notice.facade.NoticeFacade;
import com.example.pss.domain.reply.domain.repository.ReplyRepository;
import com.example.pss.domain.review.domain.repository.ReviewRepository;
import com.example.pss.domain.stack.domain.repository.StackRepository;
import com.example.pss.domain.star.domain.repository.StarRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoticeDeleteService {
    private final NoticeFacade noticeFacade;
    private final CommentRepository commentRepository;
    private final ReplyRepository replyRepository;
    private final NoticeRepository noticeRepository;
    private final StackRepository stackRepository;
    private final StarRepository starRepository;
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void delete(UUID uuid) {
        Notice notice = noticeFacade.findById(uuid);

        replyRepository.deleteAllByNotice(notice);
        commentRepository.deleteAllByNotice(notice);
        starRepository.deleteAllByNotice(notice);
        memberRepository.deleteAllByNotice(notice);
        stackRepository.deleteAllByNotice(notice);
        reviewRepository.deleteReviewsByNotice(notice);
        noticeRepository.delete(notice);
    }
}
